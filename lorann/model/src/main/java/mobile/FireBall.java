package mobile;

import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;

public class FireBall extends Mobile {
	
	private static Sprite fireball;


	public FireBall(int x, int y, Sprite sprite, IMap map, Permeability permeability) throws IOException {
		super(x + 1, y + 1, sprite, map, permeability);
		FireBall.setFireball(sprite);
		fireball.loadImage();
	}

	public static Sprite getFireball() {
		return fireball;
	}

	public static void setFireball(Sprite monster1) {
		FireBall.fireball = monster1;
	}

	@Override
	public Boolean victory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void magic() {
		// TODO Auto-generated method stub
		
	}

	

}
