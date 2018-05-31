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
	
	private static final Sprite spriteImageBoss = new Sprite('1', "monster_1.png");

	public Boss(IMap map) throws IOException {
		super(spriteImageBoss, map, Permeability.BLOCKING);
		spriteImageBoss.loadImage();
	}

	@Override
	public void moveUp() {
		super.moveUp();
		this.setSprite(spriteImageBoss);
	}

	@Override
	public void moveLeft() {
		super.moveLeft();
		this.setSprite(spriteImageBoss);
	}

	@Override
	public void moveDown() {
		super.moveDown();
		this.setSprite(spriteImageBoss);
	}

	@Override
	public void moveRight() {
		super.moveRight();
		this.setSprite(spriteImageBoss);
	}

	@Override
	public void doNothing() {
	
	
	}
	

}