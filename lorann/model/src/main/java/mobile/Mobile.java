package mobile;

import java.awt.Point;
import java.io.IOException;
import element.Element;
import model.IMap;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import motionless.Ground;
import motionless.MotionlessElementFactory;
import showboard.IBoard;

/**
 * 
 * <h1>Class Mobile</h1>
 *  
 * @author group2
 *
 * @version 1.0
 */

public abstract class Mobile extends Element implements IMobile {

	/** The position.*/
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

	
	/* (non-Javadoc)
	 * @see model.IMobile#moveUp()
	 */
	@Override
	public void moveUp() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.PENETRABLE) {
			this.setY(this.getY() - 1);
			this.setHasMoved();
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1)
				.getPermeability() == Permeability.CRYSTALBALL) {
			try {
				this.setHasFoundTheCrystal(this.getX(), this.getY() - 1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setY(this.getY() - 1);
			this.setHasMoved();
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.END) {
			this.setY(this.getY() - 1);
			this.setVictory("VICTORY");
			this.die();
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.PURSE) {
			try {
				this.setHasFoundThePurse(this.getX(), this.getY()-1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setY(this.getY() - 1);
			this.setHasMoved();
		}
	}
	
	/* (non-Javadoc)
	 * @see model.IMobile#moveLeft()
	 */
	@Override
	public void moveLeft() {
		if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.PENETRABLE) {
			this.setX(this.getX() - 1);
			this.setHasMoved();
		} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY())
				.getPermeability() == Permeability.CRYSTALBALL) {
			try {
				this.setHasFoundTheCrystal(this.getX() - 1, this.getY());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			this.setX(this.getX() - 1);
			this.setHasMoved();
		} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.END) {
			this.setX(this.getX() - 1);
			this.setVictory("VICTORY");
			this.die();
		} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.PURSE) {
			try {
				this.setHasFoundThePurse(this.getX()-1, this.getY());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setX(this.getX() - 1);
			this.setHasMoved();
		}

	}

	
	/* (non-Javadoc)
	 * @see model.IMobile#moveDown()
	 */
	@Override
	public void moveDown() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.PENETRABLE) {
			this.setY(this.getY() + 1);
			this.setHasMoved();
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1)
				.getPermeability() == Permeability.CRYSTALBALL) {
			try {
				this.setHasFoundTheCrystal(this.getX(), this.getY() + 1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setY(this.getY() + 1);
			this.setHasMoved();
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.END) {
			this.setY(this.getY() + 1);
			this.setVictory("VICTORY");
			this.die();
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY()+1).getPermeability() == Permeability.PURSE) {
			try {
				this.setHasFoundThePurse(this.getX(), this.getY()+1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setY(this.getY() + 1);
			this.setHasMoved();
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see model.IMobile#moveRight()
	 */
	@Override
	public void moveRight() {
		if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.PENETRABLE) {
			this.setX(this.getX() + 1);
			this.setHasMoved();
		} else if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY())
				.getPermeability() == Permeability.CRYSTALBALL) {
			try {
				this.setHasFoundTheCrystal(this.getX() + 1, this.getY());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setX(this.getX() + 1);
			this.setHasMoved();

		} else if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.END) {
			this.setX(this.getX() + 1);
			this.setVictory("VICTORY");
			this.die();
		} else if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.PURSE) {
			try {
				this.setHasFoundThePurse(this.getX()+1, this.getY());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setX(this.getX() + 1);
			this.setHasMoved();
		}
	}


	/* (non-Javadoc)
	 * @see model.IMobile#doNothing()
	 */
	@Override
	public void doNothing() {
		this.setHasMoved();
	}

	/**
	 * @param y
	 * 		Set the position Y of lorann
	 */
	protected void setY(int y) {
		this.getPosition().y = y;
		if (this.isCrashed()) {
			this.die();
		}
	}

	/**
	 * @param x
	 * 		Set the position X of lorann
	 */
	protected void setX(int x) {
		this.getPosition().x = x;
		if (this.isCrashed()) {
			this.die();
		}
	}


	/* (non-Javadoc)
	 * @see model.IMobile#getY()
	 */
	public final int getY() {

		return this.getPosition().y;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#getX()
	 */
	public final int getX() {
		return this.getPosition().x;
	}

	/**
	 *  Set lorann has moved
	 */
	protected void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}

	/**
	 * @param x
	 * 		Set the position X of the CrystalBall
	 * @param y
	 * 		Set the position Y of the CrystalBall
	 * @throws IOException
	 * 
	 */
	protected void setHasFoundTheCrystal(int x, int y) throws IOException {
		this.getMap().getOnTheMapXY(x, y).setSprite(new Sprite(' ', "ground.png"));
		this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
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
	 * @param x
	 * 		Set the position X of the Purse
	 * @param y
	 * 		Set the position Y of the Purse
	 * @throws IOException
	 */
	protected void setHasFoundThePurse(int x, int y) throws IOException {
		this.getMap().dieOntheMapXY(x, y);
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

	
	/* (non-Javadoc)
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


	/* (non-Javadoc)
	 * @see model.IMobile#isCrashed()
	 */
	public Boolean isCrashed() {
		return false;
		// TODO Auto-generated method stub
		// return this.getMap().getOnTheMapXY(this.getX(),
		// this.getY()).getPermeability() == Permeability.BLOCKING;
	}

	/* (non-Javadoc)
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
		return victory+" - Score : "+score;
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
