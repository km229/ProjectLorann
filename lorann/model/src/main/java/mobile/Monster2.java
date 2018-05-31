package mobile;

import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;

public class Monster2 extends Mobile {
	
	private static Sprite monster2;

	public Monster2(int x, int y, Sprite sprite, IMap map, Permeability permeability) throws IOException {
		super(x, y, sprite, map, permeability);
		Monster2.setMonster2(sprite);
		monster2.loadImage();
	}

	public static Sprite getMonster2() {
		return monster2;
	}

	public static void setMonster2(Sprite monster2) {
		Monster2.monster2 = monster2;
	}

}
