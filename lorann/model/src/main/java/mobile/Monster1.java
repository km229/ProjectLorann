package mobile;

import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;
import showboard.BoardFrame;

public class Monster1 extends Mobile {
	
	private static Sprite monster1 = new Sprite('1', "monster_1.png");

	public Monster1(int x, int y,  IMap map, Permeability permeability) throws IOException {
		super(x, y, monster1, map, permeability);
		monster1.loadImage();
	}

	public static Sprite getMonster1() {
		return monster1;
	}

	public static void setMonster1(Sprite monster1) {
		Monster1.monster1 = monster1;
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
	public void magic(BoardFrame bf) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	}

}
