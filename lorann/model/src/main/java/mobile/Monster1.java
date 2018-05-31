package mobile;

import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;

public class Monster1 extends Mobile {
	
	private static Sprite monster1;

	public Monster1(int x, int y, Sprite sprite, IMap map, Permeability permeability) throws IOException {
		super(x, y, sprite, map, permeability);
		Monster1.setMonster1(sprite);
		monster1.loadImage();
	}

	public static Sprite getMonster1() {
		return monster1;
	}

	public static void setMonster1(Sprite monster1) {
		Monster1.monster1 = monster1;
	}

}
