package mobile;

import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;

public class Monster3 extends Mobile {
	
	private static Sprite monster3;

	public Monster3(int x, int y, Sprite sprite, IMap map, Permeability permeability) throws IOException {
		super(x, y, sprite, map, permeability);
		Monster3.setMonster3(sprite);
		monster3.loadImage();
	}

	public static Sprite getMonster3() {
		return monster3;
	}

	public static void setMonster3(Sprite monster1) {
		Monster3.monster3 = monster1;
	}

}
