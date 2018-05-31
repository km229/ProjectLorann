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

	private int icon = 0;

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

	@Override
	public void moveUp() {
		super.moveUp();
		this.setSprite(spriteTurnUp);
	}

	@Override
	public void moveLeft() {
		super.moveLeft();
		this.setSprite(spriteTurnLeft);
	}

	@Override
	public void moveDown() {
		super.moveDown();
		this.setSprite(spriteTurnDown);
	}

	@Override
	public void moveRight() {
		super.moveRight();
		this.setSprite(spriteTurnRight);
	}

	@Override
	public void doNothing() {
		switch (this.icon) {
		case 0:
			this.setSprite(spriteUL);
			break;
		case 1:
			this.setSprite(spriteUR);
			break;
		case 2:
			this.setSprite(spriteBR);
			break;
		case 3:
			this.setSprite(spriteBL);
			break;
		}
		this.icon=(this.icon+1)%4;
	}

	@Override
	public Boolean victory() {
		return super.getVictory();
	}

}
