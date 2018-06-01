package mobile;

import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;

public class Monster3 extends Mobile {
	
	private static Sprite monster3 = new Sprite('3', "monster_3.png");

	public Monster3(int x, int y, IMap map, Permeability permeability) throws IOException {
		super(x, y, monster3, map, permeability);
		monster3.loadImage();
	}

	public static Sprite getMonster1() {
		return monster3;
	}

	public static void setMonster1(Sprite monster3) {
		Monster3.monster3 = monster3;
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
