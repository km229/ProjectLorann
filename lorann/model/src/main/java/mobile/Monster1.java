package mobile;

import java.io.IOException;


import model.IMap;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import showboard.BoardFrame;

/**<h1>Class Monster1</h1>
 *  
 * @author group2
 * @version 1.0
 * @see Mobile
 */
public class Monster1 extends Mobile {
	
	/** The monster1. */
	private static Sprite monster1 = new Sprite('1', "monster_1.png");
	
	/** The movement */
	private boolean movement = true;

	/** Constructor of our Monster1
	 * 
	 * @param x
	 * @param y
	 * @param map
	 * @param permeability
	 * @throws IOException
	 */
	public Monster1(int x, int y,  IMap map, Permeability permeability) throws IOException {
		super(x, y, monster1, map, permeability);
		monster1.loadImage();
	}

	/**
	 * Return our monster1.
	 * 
	 * @return monster1
	 */
	public static Sprite getMonster1() {
		return monster1;
	}

	/**
	 * Set our monster1.
	 * 
	 * @param monster1
	 */
	public void setMonster(Sprite monster1) {
		Monster1.monster1 = monster1;
	}
	
	/* (non-Javadoc)
	 * @see model.IMobile#moveUp()
	 */
	@Override
	public void moveUp() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.PENETRABLE && movement == true) {
			this.setY(this.getY() - 1);
			this.setHasMoved();
		}
	}

	/* (non-Javadoc)
	 * @see model.IMobile#moveLeft()
	 */
	@Override
	public void moveLeft() {
		if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.PENETRABLE && movement == true) {
			this.setX(this.getX() - 1);
			this.setHasMoved();

		}
	}

	/* (non-Javadoc)
	 * @see model.IMobile#moveDown()
	 */
	@Override
	public void moveDown() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.PENETRABLE && movement == true) {
			this.setY(this.getY() + 1);
			this.setHasMoved();
		}
	}

	/* (non-Javadoc)
	 * @see model.IMobile#moveRight()
	 */
	@Override
	public void moveRight() {
		if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.PENETRABLE && movement == true) {
			this.setX(this.getX() + 1);
			this.setHasMoved();
		}
	}

	/* (non-Javadoc)
	 * @see model.IMobile#victory()
	 */
	@Override
	public String victory() {
		return null;
	}

	/* (non-Javadoc)
	 * @see model.IMobile#magic(BoardFrame bf)
	 */
	@Override
	public void magic(BoardFrame bf) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see model.IMobile#getFb()
	 */
	@Override
	public IMobile getFb() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see model.IMobile#monsterDestroyed()
	 */
	@Override
	public void monsterDestroyed(){
		monster1 = new Sprite(' ', "Invisible.png");
		try {
			monster1.loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.setSprite(monster1);
		super.setPermeability(Permeability.PENETRABLE);
		this.movement=false;
	}

}
