package mobile;

import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;

public class Monster4 extends Mobile {
	
	private static Sprite monster4 = new Sprite('4', "monster_4.png");

	public Monster4(int x, int y, IMap map, Permeability permeability) throws IOException {
		super(x, y, monster4, map, permeability);
		monster4.loadImage();
	}

	public static Sprite getMonster4() {
		return monster4;
	}

	public static void setMonster4(Sprite monster4) {
		Monster4.monster4 = monster4;
	}
	
	@Override
	public void moveUp() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.PENETRABLE) {
			this.setY(this.getY() - 1);
			this.setHasMoved();
		}
	}

	@Override
	public void moveLeft() {
		if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.PENETRABLE) {
			this.setX(this.getX() - 1);
			this.setHasMoved();

		}
	}

	@Override
	public void moveDown() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.PENETRABLE) {
			this.setY(this.getY() + 1);
			this.setHasMoved();
		}
	}

	@Override
	public void moveRight() {
		if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.PENETRABLE) {
			this.setX(this.getX() + 1);
			this.setHasMoved();
		}
	}

	@Override
	public String victory() {
		return null;
	}

	@Override
	public void magic() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
