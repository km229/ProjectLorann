package mobile;


import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;
import showboard.BoardFrame;

/**
 * <h1>The Class ControllerFacade.</h1>
 *
 * @author group2
 * @version 1.0
 * @see Mobile
 * @author group2
 * @version 1.0
 */
public class FireBall extends Mobile {
	
	/** The map. */
	private static IMap map;
	
	/** The fireball1. */
	private static Sprite fireball1;

	/**
	 * Constructor of our Fireball.
	 * 
	 * @param x
	 * @param y
	 * @param sprite
	 * @param map
	 * @param permeability
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public FireBall(int x, int y, Sprite sprite, IMap map, Permeability permeability) throws IOException, InterruptedException {
		super(x, y, sprite, map, permeability);
		setMap(map);
		FireBall.setFireball(sprite);
	}

	/**
	 * Return the map.
	 * @return map
	 */
	public IMap getMap() {
		return map;
	}

	/**
	 * Set the map.
	 * @param map
	 */
	public void setMap(IMap map) {
		FireBall.map = map;
	}

	/**
	 * Return our fireball.
	 * @return fireball1
	 */
	public static Sprite getFireball() {
		return fireball1;
	}

	/**
	 * Set the fireball.
	 * @param fb
	 */
	public static void setFireball(Sprite fb) {
		FireBall.fireball1 = fb;
	}

	/* (non-Javadoc)
	 * @see mobile.Mobile#victory()
	 */
	@Override
	public String victory() {
		return null;
	}

	/* (non-Javadoc)
	 * @see mobile.Mobile#magic(BoardFrame bf)
	 */
	@Override
	public void magic(BoardFrame bf) {
	}
	
	/* (non-Javadoc)
	 * @see mobile.Mobile#moveUp()
	 */
	@Override
	public void moveUp() {
		super.moveUp();
	}
	
	/* (non-Javadoc)
	 * @see mobile.Mobile#moveLeft()
	 */
	@Override
	public void moveLeft() {
		super.moveLeft();
	}

	/* (non-Javadoc)
	 * @see mobile.Mobile#moveDown()
	 */
	@Override
	public void moveDown() {
		super.moveDown();
	}

	/* (non-Javadoc)
	 * @see mobile.Mobile#moveRight()
	 */
	@Override
	public void moveRight() {
		super.moveRight();
	}

	/**
	 * Return our fireball.
	 * @return fb
	 * 			the fireball
	 */
	@Override
	public FireBall getFb() {
		return this;
	}

	/* (non-Javadoc)
	 * @see mobile.Mobile#monsterDestroyed()
	 */
	@Override
	public void monsterDestroyed() {
		// TODO Auto-generated method stub
		
	}
	
}
