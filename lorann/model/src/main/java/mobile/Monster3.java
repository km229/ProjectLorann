package mobile;

import java.io.IOException;

import model.IMap;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import showboard.BoardFrame;

/**<h1>Class Monster3</h1>
 *  
 * @author group2
 * @version 1.0
 * @see Mobile
 */
public class Monster3 extends Mobile {
	
	/** The monster1. */
	private static Sprite monster3 = new Sprite('3', "monster_3.png");
	
	/** The movement */
	private boolean movement = true;

	/** Constructor of Monster3.
	 * 
	 * @param x
	 * @param y
	 * @param map
	 * @param permeability
	 * @throws IOException
	 */
	public Monster3(int x, int y, IMap map, Permeability permeability) throws IOException {
		super(x, y, monster3, map, permeability);
		monster3.loadImage();
	}

	/** Retourn our monster3.
	 * 
	 * @return monster3
	 */
	public static Sprite getMonster1() {
		return monster3;
	}

	/** Set our Monster3.
	 * 
	 * @param monster3
	 */
	public void setMonster(Sprite monster3) {
		Monster3.monster3 = monster3;
	}
	
	/* (non-Javadoc)
	 * @see model.IMobile#magic(BoardFrame bf)
	 */
	@Override
	public void moveUp() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.PENETRABLE && movement == true) {
			this.setY(this.getY() - 1);
			this.setHasMoved();
		}
	}

	/* (non-Javadoc)
	 * @see model.IMobile#magic(BoardFrame bf)
	 */
	@Override
	public void moveLeft() {
		if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.PENETRABLE && movement == true) {
			this.setX(this.getX() - 1);
			this.setHasMoved();

		}
	}

	/* (non-Javadoc)
	 * @see model.IMobile#magic(BoardFrame bf)
	 */
	@Override
	public void moveDown() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.PENETRABLE && movement == true) {
			this.setY(this.getY() + 1);
			this.setHasMoved();
		}
	}

	/* (non-Javadoc)
	 * @see model.IMobile#magic(BoardFrame bf)
	 */
	@Override
	public void moveRight() {
		if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.PENETRABLE && movement == true) {
			this.setX(this.getX() + 1);
			this.setHasMoved();
		}
	}

	/* (non-Javadoc)
	 * @see model.IMobile#magic(BoardFrame bf)
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
	 * @see model.IMobile#magic(BoardFrame bf)
	 */
	@Override
	public IMobile getFb() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see model.IMobile#magic(BoardFrame bf)
	 */
	@Override
	public void monsterDestroyed(){
		monster3 = new Sprite(' ', "Invisible.png");
		try {
			monster3.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.setSprite(monster3);
		super.setPermeability(Permeability.PENETRABLE);
	}
}
