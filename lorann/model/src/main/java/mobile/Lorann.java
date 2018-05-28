package mobile;

import java.awt.Point;

import element.Permeability;
import element.Sprite;

public class Lorann extends Mobile {
	
	   /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('c', "MyVehicle.png");

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnLeft  = new Sprite('c', "lorann_l.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('c', "lorann_r.png");

    /** The Constant spriteTurnUp. */
    private static final Sprite spriteTurnUp  = new Sprite('c', "lorann_u.png");

    /** The Constant spriteTurnDown. */
    private static final Sprite spriteTurnDown = new Sprite('c', "lorann_b.png");


	public Lorann(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doNothing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean isAlive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isDead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return null;
	}

}
