package mobile;

import java.io.IOException;


import model.IMap;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import showboard.BoardFrame;

/**<h1>Class Monster2</h1>
 *  
 * @author group2
 * @version 1.0
 * @see Mobile
 */
public class Monster2 extends Mobile {
	
	/** The monster1. */
	private static Sprite monster2 = new Sprite('2', "monster_2.png");
	
	/** The movement */
	private boolean movement = true;

	/** Constructor of Monster2.
	 * 
	 * @param x
	 * @param y
	 * @param map
	 * @param permeability
	 * @throws IOException
	 */
	public Monster2(int x, int y, IMap map, Permeability permeability) throws IOException {
		super(x, y, monster2, map, permeability);
		monster2.loadImage();
	}

	/** Retourn our monster2.
	 * 
	 * @return monster2
	 */
	public static Sprite getMonster2() {
		return monster2;
	}

	/** Set our Monster2.
	 * 
	 * @param monster2
	 */
	public void setMonster(Sprite monster2) {
		Monster2.monster2 = monster2;
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
		
	}

	/* (non-Javadoc)
	 * @see model.IMobile#getFb()
	 */
	@Override
	public IMobile getFb() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see model.IMobile#monsterDestroyed()
	 */
	@Override
	public void monsterDestroyed(){
		monster2 = new Sprite(' ', "Invisible.png");
		try {
			monster2.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.setSprite(monster2);
		super.setPermeability(Permeability.PENETRABLE);
		this.movement = false;
	}

}
