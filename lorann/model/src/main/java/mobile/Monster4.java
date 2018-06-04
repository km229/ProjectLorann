package mobile;

import java.io.IOException;

import model.IMap;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import showboard.BoardFrame;

/**<h1>Class Monster4</h1>
 *  
 * @author group2
 * @version 1.0
 * @see Mobile
 */
public class Monster4 extends Mobile {
	
	/** The monster1. */
	private static Sprite monster4 = new Sprite('4', "monster_4.png");
	
	/** The movement */
	private boolean movement = true;

	/**  Constructor of Monster4.
	 * 
	 * @param x
	 * @param y
	 * @param map
	 * @param permeability
	 * @throws IOException
	 */
	public Monster4(int x, int y, IMap map, Permeability permeability) throws IOException {
		super(x, y, monster4, map, permeability);
		monster4.loadImage();
	}

	/** Retourn our monster4.
	 * 
	 * @return monster4
	 */
	public static Sprite getMonster4() {
		return monster4;
	}

	/** Set our Monster4.
	 * 
	 * @param monster4
	 */
	public void setMonster(Sprite monster4) {
		Monster4.monster4 = monster4;
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
		monster4 = new Sprite(' ', "Invisible.png");
		try {
			monster4.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.setSprite(monster4);
		super.setPermeability(Permeability.PENETRABLE);
	}

}
