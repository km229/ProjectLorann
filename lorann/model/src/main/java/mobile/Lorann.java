package mobile;

import java.io.IOException;


import java.util.Timer;
import java.util.TimerTask;

import model.IMap;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import showboard.BoardFrame;


/**
 * <h1>The class Lorann.</h1>
 *
 * @author group2
 * @version 1.0
 * @see Mobile
 */
public class Lorann extends Mobile {

	/** The boardframe bf.*/
	private BoardFrame bf;

	/** The state Moving. */
	private String Moving;

	/** The fireball fb. */
	private FireBall fb;

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

	/** The Constant spriteGround. */
	private static final Sprite spriteGround = new Sprite('c', "ground.png");

	/** The Constant speed of our fireball. */
	private static final int speed = 100;

	/** The etat. */
	private boolean etat;

	/** The Constant fireball1. */
	private static final Sprite fireball1 = new Sprite('c', "fireball_1.png");

	/** The Constant fireball2. */
	private static final Sprite fireball2 = new Sprite(' ', "fireball_2.png");

	/** The Constant fireball3. */
	private static final Sprite fireball3 = new Sprite(' ', "fireball_3.png");

	/** The Constant fireball4. */
	private static final Sprite fireball4 = new Sprite(' ', "fireball_4.png");

	/** The Constant fireball5. */
	private static final Sprite fireball5 = new Sprite(' ', "fireball_5.png");

	/** The icon. */
	private int icon = 0;

	/**
	 * Constructor Lorann
	 * 
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
		Moving = "LEFT";
		timer.scheduleAtFixedRate(task, 1, speed);
		spriteUL.loadImage();
		spriteUR.loadImage();
		spriteBR.loadImage();
		spriteBL.loadImage();
		fireball1.loadImage();
		fireball2.loadImage();
		fireball3.loadImage();
		fireball4.loadImage();
		fireball5.loadImage();
		spriteTurnLeft.loadImage();
		spriteTurnRight.loadImage();
		spriteTurnDown.loadImage();
		spriteTurnUp.loadImage();
		fb = new FireBall(20, 20, fireball1, this.getMap(), this.getPermeability());
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
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.MONSTER) {
			this.setY(this.getY() - 1);
			this.die();
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
		} else if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.MONSTER) {
			this.setX(this.getX() - 1);
			this.die();
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
		} else if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.MONSTER) {
			this.setY(this.getY() + 1);
			this.die();
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
			this.setX(this.getX() + 1);
			this.setHasMoved();
		} else if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.MONSTER) {
			this.setX(this.getX() + 1);
			this.die();
		}
		if (!etat) {
			Moving = "RIGHT";
		}
		this.setSprite(spriteTurnRight);
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
		if (!etat) {
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

	/** Method to change the color of our fireball. 
	 *  
	 *  @param sprite
	 *  
	 * */
	private void spriteChange(Sprite sprite) {
		if (sprite == fireball1) {
			fb.setSprite(fireball2);
		}

		if (sprite == fireball2) {
			fb.setSprite(fireball3);
		}

		if (sprite == fireball3) {
			fb.setSprite(fireball4);
		}

		if (sprite == fireball4) {
			fb.setSprite(fireball5);
		}

		if (sprite == fireball5 || sprite == spriteGround) {
			fb.setSprite(fireball1);
		}

		if (!etat) {
			fb.setSprite(spriteGround);
		}
	}

	/** Method to lauch our fireball in the right direction. */
	
	public void play() {
		spriteChange(fb.getSprite());

		if (Moving == "UP") {
			fb.moveUp();
			if (this.getMap().getOnTheMapXY(fb.getX(), fb.getY()).getPermeability() == Permeability.BLOCKING) {
				
				Moving = "DOWN";
				fb.moveDown();
			}
		}

		if (Moving == "DOWN") {
			fb.moveDown();
			if (this.getMap().getOnTheMapXY(fb.getX(), fb.getY()).getPermeability() == Permeability.BLOCKING) {
				
				Moving = "UP";
				fb.moveUp();
				
			}
		}

		if (Moving == "RIGHT") {
			fb.moveRight();
			if (this.getMap().getOnTheMapXY(fb.getX(), fb.getY()).getPermeability() == Permeability.BLOCKING) {
				
				Moving = "LEFT";
				fb.moveLeft();
				
			}
		}

		if (Moving == "LEFT") {
			fb.moveLeft();
			if (this.getMap().getOnTheMapXY(fb.getX(), fb.getY()).getPermeability() == Permeability.BLOCKING) {
				
				Moving = "RIGHT";
				fb.moveRight();
				
			}

		}
				
		if(fb.getX() == this.getX()) {
			if(fb.getY() == this.getY()) {
				endFireBall();
			}
			
		}

	}

	/** Method to stop the fireball before a wall. */
	public void endFireBall() {
			etat = false;
			fb.setSprite(spriteGround);
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMobile#monsterDestroyed()
	 */
	@Override
	public void monsterDestroyed() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Return our boardframe.
	 * 
	 * @return bf
	 */
	public BoardFrame getBf() {
		return bf;
	}

	/**
	 * Set our boardFrame.
	 * 
	 * @param bf
	 */
	public void setBf(BoardFrame bf) {
		this.bf = bf;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IMobile#geetFb()
	 */
	@Override
	public IMobile getFb() {
		
		return fb;
	}

}
