package mobile;

import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;

public class Monster2 extends Mobile {
	
	private static Sprite monster2 = new Sprite('2', "monster_2.png");

	public Monster2(int x, int y, IMap map, Permeability permeability) throws IOException {
		super(x, y, monster2, map, permeability);
		monster2.loadImage();
	}

	public static Sprite getMonster2() {
		return monster2;
	}

	public static void setMonster2(Sprite monster2) {
		Monster2.monster2 = monster2;
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
