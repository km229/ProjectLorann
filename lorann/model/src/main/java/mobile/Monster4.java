package mobile;

import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;

public class Monster4 extends Mobile {
	
	private static Sprite monster4;

	public Monster4(int x, int y, Sprite sprite, IMap map, Permeability permeability) throws IOException {
		super(x, y, sprite, map, permeability);
		Monster4.setMonster4(sprite);
		monster4.loadImage();
	}

	public static Sprite getMonster4() {
		return monster4;
	}

	public static void setMonster4(Sprite monster1) {
		Monster4.monster4 = monster1;
	}

}
