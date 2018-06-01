package mobile;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import model.IMap;
import model.Permeability;
import model.Sprite;
import showboard.BoardFrame;

public class FireBall extends Mobile {

	private static String Moving;

	private static Sprite fireball1;

	private static IMap map;

	private boolean etat;

	private static BoardFrame bf;

	private static final int speed = 200;

	private static final Sprite fireball2 = new Sprite(' ', "fireball_2.png");

	private static final Sprite fireball3 = new Sprite(' ', "fireball_3.png");

	private static final Sprite fireball4 = new Sprite(' ', "fireball_4.png");

	public FireBall(int x, int y, Sprite sprite, IMap map, Permeability permeability, BoardFrame bf, String Moving)
			throws IOException, InterruptedException {
		super(x, y, sprite, map, permeability);
		setMoving(Moving);
		setMap(map);
		setBf(bf);
		FireBall.setFireball(sprite);
		fireball1.loadImage();
		fireball2.loadImage();
		fireball3.loadImage();
		fireball4.loadImage();
		etat = true;
		bf.addPawn(this);

		timer.scheduleAtFixedRate(task, 1, speed);

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

	public BoardFrame getBf() {
		return bf;
	}

	public void setBf(BoardFrame bf) {
		FireBall.bf = bf;
	}

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		FireBall.map = map;
	}

	public static String getMoving() {
		return Moving;
	}

	public static void setMoving(String moving) {
		Moving = moving;
	}

	public static Sprite getFireball() {
		return fireball1;
	}

	public static void setFireball(Sprite fb) {
		FireBall.fireball1 = fb;
	}

	@Override
	public String victory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void magic() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveUp() {
		super.moveUp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobile.Mobile#moveLeft()
	 */
	@Override
	public void moveLeft() {
		super.moveLeft();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobile.Mobile#moveDown()
	 */
	@Override
	public void moveDown() {
		super.moveDown();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mobile.Mobile#moveRight()
	 */
	@Override
	public void moveRight() {
		super.moveRight();
	}

	public void play() {

		spriteChange(this.getSprite());

		if (Moving == "UP") {
			moveUp();
			if (map.getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING) {
				this.setSprite(new Sprite('_', "ground.png"));
				etat = false;
			}

		}

		if (Moving == "DOWN") {
			moveDown();
			if (map.getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING) {
				this.setSprite(new Sprite('_', "ground.png"));
				etat = false;
			}
		}

		if (Moving == "RIGHT") {
			moveRight();
			if (map.getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING) {
				this.die();
				etat = false;
			}
		}

		if (Moving == "LEFT") {
			moveLeft();
			if (map.getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING) {
				this.die();
				etat = false;
			}
		}
	}

	private void spriteChange(Sprite sprite) {

		if (sprite == fireball1) {
			this.setSprite(fireball2);
		}

		if (sprite == fireball2) {
			this.setSprite(fireball3);
		}

		if (sprite == fireball3) {
			this.setSprite(fireball4);
		}

		if (sprite == fireball4) {
			this.setSprite(fireball1);
		}

	}

}