package mobile;

import java.awt.Point;


import java.io.IOException;
import java.util.Observable;

import element.Element;
import model.IMap;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import motionless.Bone;
import motionless.Ground;
import motionless.Purse;
import showboard.IBoard;

/**
 * <h1>Class Mobile</h1>
 * 
 * @author group2
 * @version 1.0
 * @see Element, IMobile
 */

public abstract class Mobile extends Element implements IMobile {

	/** The position. */
	private Point position;

	/** The alive. */
	private Boolean alive = true;

	/** The map. */
	private IMap map;

	/** The board. */
	private IBoard board;

	/** The victory */
	private String victory = "GAME OVER";

	private int score;

	/**
	 * Instantiates a new mobile.
	 *
	 * @param sprite
	 *            the sprite
	 * @param map
	 *            the map
	 * @param permeability
	 *            the permeability
	 */
	Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map);
		this.position = new Point();
	}

	/**
	 * Instantiates a new mobile.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param sprite
	 *            the sprite
	 * @param map
	 *            the map
	 * @param permeability
	 *            the permeability
	 */
	Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
		this(sprite, map, permeability);
		this.setX(x);
		this.setY(y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMobile#moveUp()
	 */
	@Override
	public void moveUp() {

		this.setY(this.getY() - 1);
		this.setHasMoved();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMobile#moveLeft()
	 */
	@Override
	public void moveLeft() {
		this.setX(this.getX() - 1);
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMobile#moveDown()
	 */
	@Override
	public void moveDown() {
		this.setY(this.getY() + 1);
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMobile#moveRight()
	 */
	@Override
	public void moveRight() {
		this.setX(this.getX() + 1);
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMobile#doNothing()
	 */
	@Override
	public void doNothing() {
		this.setHasMoved();
	}

	/**
	 * @param y
	 *            Set the position Y of lorann
	 */
	protected void setY(int y) {
		this.getPosition().y = y;
	}

	/**
	 * @param x
	 *            Set the position X of lorann
	 */
	protected void setX(int x) {
		this.getPosition().x = x;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMobile#getY()
	 */
	public final int getY() {

		return this.getPosition().y;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMobile#getX()
	 */
	public final int getX() {
		return this.getPosition().x;
	}

	/**
	 * Set lorann has moved.
	 */
	protected void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}

	/**
	 * Lorann has found the crystal, the door is now opened.
	 * 
	 * @param x
	 *            Set the position X of the CrystalBall.
	 * @param y
	 *            Set the position Y of the CrystalBall.
	 * @throws IOException
	 * 
	 */
	protected void setHasFoundTheCrystal(int x, int y) throws IOException {
		this.getMap().getOnTheMapXY(x, y).setSprite(new Sprite(' ', "ground.png"));
		this.getMap().getOnTheMapXY(x, y).setPermeability(Permeability.PENETRABLE);
		this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
		this.score += 500;
		for (int i = 0; i < this.getMap().getWidth(); i++) {
			for (int j = 0; j < this.getMap().getHeight(); j++) {
				if (this.getMap().getOnTheMapXY(i, j).getSprite().getConsoleImage() == 'g') {
					this.getMap().getOnTheMapXY(i, j).setSprite(new Sprite('G', "gate_open.png"));
					this.getMap().getOnTheMapXY(i, j).getSprite().loadImage();
					this.getMap().getOnTheMapXY(i, j).setPermeability(Permeability.END);
				}
			}
		}
	}

	/**
	 * This method increases our score if Lorann is on a purse.
	 * 
	 * @param x
	 *            Set the position X of the Purse.
	 * @param y
	 *            Set the position Y of the Purse.
	 * @throws IOException
	 */
	
	
	
	protected void setHasFoundThePurse(int x, int y) throws IOException {
		this.getMap().setOnTheMapXY(new Ground(), x, y);
		this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
		this.score+=100;
	}

	/**
	 * Gets the map
	 * 
	 * @return the map
	 */
	public IMap getMap() {
		return map;
	}

	/**
	 * Set the map
	 * 
	 * @param map
	 */
	public void setMap(IMap map) {
		this.map = map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMobile#isAlive()
	 */
	public Boolean isAlive() {
		return alive;
	}

	/**
	 * Change the state of life.
	 */
	public void die() {
		this.alive = false;
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMobile#isCrashed()
	 */
	public void isCrashed() {
		this.alive = false;
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see showboard.IPawn#getPosition()
	 */
	public Point getPosition() {
		return this.position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position
	 *            the position to set
	 */
	public void setPosition(final Point position) {
		this.position = position;
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	protected IBoard getBoard() {
		return this.board;
	}

	/**
	 * Gets the victory.
	 * 
	 * @return the victory
	 */
	public String getVictory() {
		return victory + " - Score : " + score;
	}

	/**
	 * Set the victory.
	 * 
	 * @param victory
	 */
	public void setVictory(String victory) {
		this.victory = victory;
	}

}
