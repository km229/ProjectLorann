package mobile;

import java.awt.Point;
import java.io.IOException;

import element.Permeability;
import element.Sprite;
import model.IMap;

public class Boss extends Mobile {
	
	IBehaviour behaviour;


	public void setBehaviour(IBehaviour behaviour)
	{
		this.behaviour = behaviour;
	}

	public IBehaviour getBehaviour()
	{
		return behaviour;
	}

	public Boss(final int x, final int y, Sprite sprite, IMap map, Permeability permeability) throws IOException {
		super(x, y, sprite, map, Permeability.BLOCKING);
	}
	
	public void move()
	{

	}


}