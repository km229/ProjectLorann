package mobile;

import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;

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
	public String victory() {
		return null;
	}

	@Override
	public void magic() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
