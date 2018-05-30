package mobile;

import java.awt.Point;
import java.io.IOException;

import model.IMap;
import model.Permeability;
import model.Sprite;

public class Boss extends Mobile {
	
	static IBehaviour behaviour;

	
	public void setBehaviour(IBehaviour behaviour)
	{
		this.behaviour = behaviour;
	}

	public static IBehaviour getBehaviour()
	{
		return behaviour;
	}
	
	private static final Sprite spriteImageBoss = new Sprite(getBehaviour().getID(), getBehaviour().getImage());

	public Boss(int x, int y, Sprite sprite, IMap map, Permeability permeability, int lorannX, int lorannY) throws IOException {
		super(x, y, spriteImageBoss, map, Permeability.BLOCKING);
		spriteImageBoss.loadImage();
		int speed = 1;
		
		int diffX = lorannX - x;
		int diffY = lorannY - y;

		float angle = (float)Math.atan2(diffY, diffX);

		x += speed * Math.cos(angle);
		y += speed * Math.sin(angle);
		
		if(lorannX)
		
	}

	@Override
	public void moveUp() {
		super.moveUp();
	}

	@Override
	public void moveLeft() {
		super.moveLeft();
	}

	@Override
	public void moveDown() {
		super.moveDown();
	}

	@Override
	public void moveRight() {
		super.moveRight();
	}
	
	
	public void moveAround() {
		
		
	}
	

}