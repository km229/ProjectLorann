package mobile;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import model.IMap;
import model.Permeability;
import model.Sprite;
import showboard.BoardFrame;

public class Lorann extends Mobile {

	private BoardFrame bf;

	private String Moving;

	private FireBall fb;

	private static final Sprite fireball1 = new Sprite('c', "fireball_1.png");

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

	private static final Sprite spriteGround = new Sprite('c', "ground.png");

	private static final int speed = 200;

	private boolean etat;
	
	private static final Sprite fireball2 = new Sprite(' ', "fireball_2.png");

	private static final Sprite fireball3 = new Sprite(' ', "fireball_3.png");
	
	private static final Sprite fireball4 = new Sprite(' ', "fireball_4.png");

	/** The icon. */
	private int icon = 0;

	/**
	 * @param x
	 *            The position X of Lorann
	 * @param y
	 *            The position Y of Lorann
	 * @param map
	 *            The map
	 * @param level
	 * @param xYMonsters2
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Lorann(final int x, final int y, IMap map) throws IOException, InterruptedException {
		super(x, y, spriteUL, map, Permeability.BLOCKING);
		setBf(bf);
		etat = false;
		timer.scheduleAtFixedRate(task, 1, speed);
		spriteUL.loadImage();
		spriteUR.loadImage();
		spriteBR.loadImage();
		spriteBL.loadImage();
		fireball1.loadImage();
		fireball2.loadImage();
		fireball3.loadImage();
		fireball4.loadImage();
		spriteTurnLeft.loadImage();
		spriteTurnRight.loadImage();
		spriteTurnDown.loadImage();
		spriteTurnUp.loadImage();
		fireball1.loadImage();
		fb = new FireBall(20, 20, fireball1, this.getMap(), this.getPermeability());
	}

	public BoardFrame getBf() {
		return bf;
	}

	public void setBf(BoardFrame bf) {
		this.bf = bf;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobile.Mobile#moveUp()
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
				this.setHasFoundThePurse(this.getX(), this.getY() - 1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setY(this.getY() - 1);
			this.setHasMoved();
		}

		if (!etat) {
			Moving = "UP";
		}
		this.setSprite(spriteTurnUp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobile.Mobile#moveLeft()
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
				this.setHasFoundThePurse(this.getX() - 1, this.getY());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setX(this.getX() - 1);
			this.setHasMoved();
		}
		if (!etat) {
			Moving = "LEFT";
		}
		this.setSprite(spriteTurnLeft);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobile.Mobile#moveDown()
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
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.PURSE) {
			try {
				this.setHasFoundThePurse(this.getX(), this.getY() + 1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setY(this.getY() + 1);
			this.setHasMoved();
		}
		if (!etat) {
			Moving = "DOWN";
		}
		this.setSprite(spriteTurnDown);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobile.Mobile#moveRight()
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
				this.setHasFoundThePurse(this.getX() + 1, this.getY());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!etat) {
				Moving = "RIGHT";
			}
			this.setSprite(spriteTurnRight);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobile.Mobile#doNothing()
	 */
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
		this.icon = (this.icon + 1) % 4;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMobile#victory()
	 */
	@Override
	public String victory() {
		return super.getVictory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMobile#magic()
	 */
	@Override
	public void magic(BoardFrame bf) {
		// TODO Auto-generated method stub
		bf.addPawn(fb);
		if(!etat) {
		fb.setX(this.getX());
		fb.setY(this.getY());
		etat = true;
		}
	}
	
	Timer timer = new Timer();
	TimerTask task = new TimerTask() {
		
		@Override
		public void run() {
			if (etat) {
				play();
			}
		}
	};
	
	private void spriteChange(Sprite sprite) {
		
		if(sprite == fireball1) {
			fb.setSprite(fireball2);
		}
		
		if(sprite == fireball2) {
			fb.setSprite(fireball3);
		}
		
		if(sprite == fireball3) {
			fb.setSprite(fireball4);
		}
		
		if(sprite == fireball4 || sprite == spriteGround) {
			fb.setSprite(fireball1);
		}
		if(!etat) {
			fb.setSprite(spriteGround);
		}
	}
		

	public void play() {
		spriteChange(fb.getSprite());

		if (Moving == "UP") {
			fb.moveUp();
			endFireBall();
		}

		if (Moving == "DOWN") {
			fb.moveDown();
			endFireBall();
		}

		if (Moving == "RIGHT") {
			fb.moveRight();
			endFireBall();
		}

		if (Moving == "LEFT") {
			fb.moveLeft();
			endFireBall();
			
		}

	}

	public void endFireBall() {
		if (this.getMap().getOnTheMapXY(fb.getX(), fb.getY()).getPermeability() == Permeability.BLOCKING) {
		etat = false;
		fb.setSprite(spriteGround);
		}
	}

}
