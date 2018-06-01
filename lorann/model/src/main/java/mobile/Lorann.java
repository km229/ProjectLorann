package mobile;

import java.awt.Point;
import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;

public class Lorann extends Mobile {

	/** The Constant SpriteUL */
	private static final Sprite spriteUL = new Sprite('c', "lorann_ul.png");

	/** The Constant SpriteUR */
	private static final Sprite spriteUR = new Sprite('c', "lorann_ur.png");

	/** The Constant SpriteBR */
	private static final Sprite spriteBR = new Sprite('c', "lorann_br.png");

	/** The Constant SpriteBL */
	private static final Sprite spriteBL = new Sprite('c', "lorann_bl.png");

	/** The Constant spriteTurnLeft. */
	private static final Sprite spriteTurnLeft = new Sprite('c', "lorann_l.png");

	/** The Constant spriteTurnRight. */
	private static final Sprite spriteTurnRight = new Sprite('c', "lorann_r.png");

	/** The Constant spriteTurnUp. */
	private static final Sprite spriteTurnUp = new Sprite('c', "lorann_u.png");

	/** The Constant spriteTurnDown. */
	private static final Sprite spriteTurnDown = new Sprite('c', "lorann_b.png");

	/** The icon. */
	private int icon = 0;

	/**
	 * @param x
	 * 		The position X of Lorann
	 * @param y
	 * 		The position Y of Lorann
	 * @param map
	 * 		The map
	 * @throws IOException
	 */
	public Lorann(final int x, final int y, IMap map) throws IOException {
		super(x, y, spriteUL, map, Permeability.BLOCKING);
		spriteUL.loadImage();
		spriteUR.loadImage();
		spriteBR.loadImage();
		spriteBL.loadImage();
		spriteTurnLeft.loadImage();
		spriteTurnRight.loadImage();
		spriteTurnDown.loadImage();
		spriteTurnUp.loadImage();
	}

	/* (non-Javadoc)
	 * @see mobile.Mobile#moveUp()
	 */
	@Override
	public void moveUp() {
		super.moveUp();
		this.setSprite(spriteTurnUp);
	}

	/* (non-Javadoc)
	 * @see mobile.Mobile#moveLeft()
	 */
	@Override
	public void moveLeft() {
		super.moveLeft();
		this.setSprite(spriteTurnLeft);
	}

	/* (non-Javadoc)
	 * @see mobile.Mobile#moveDown()
	 */
	@Override
	public void moveDown() {
		super.moveDown();
		this.setSprite(spriteTurnDown);
	}

	/* (non-Javadoc)
	 * @see mobile.Mobile#moveRight()
	 */
	@Override
	public void moveRight() {
		super.moveRight();
		this.setSprite(spriteTurnRight);
	}

	/* (non-Javadoc)
	 * @see mobile.Mobile#doNothing()
	 */
	@Override
	public void doNothing() {
		switch (this.icon) {
		case 0:
			this.setSprite(spriteUL);
			break;
		case 1:
			this.setSprite(spriteTurnUp);
			break;
		case 2:
			this.setSprite(spriteTurnRight);
			break;
		case 3:
			this.setSprite(spriteBR);
			break;
		case 4:
			this.setSprite(spriteTurnDown);
			break;
		case 5:
			this.setSprite(spriteBL);
			break;
		case 6:
			this.setSprite(spriteTurnLeft);
			break;
		case 7:
			this.setSprite(spriteUL);
			break;
		}
		this.icon=(this.icon+1)%8;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#victory()
	 */
	@Override
	public String victory() {
		return super.getVictory();
	}

	/* (non-Javadoc)
	 * @see model.IMobile#magic()
	 */
	@Override
	public void magic() throws IOException {
		// TODO Auto-generated method stub
		FireBall fb = new FireBall(this.getX(), this.getY(), spriteUL, this.getMap(), this.getPermeability());
		
	}

}
