package mobile;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.lang.model.element.ElementKind;
import javax.swing.plaf.synth.SynthSeparatorUI;

import model.IMap;
import model.Permeability;
import model.Sprite;
import motionless.Ground;
import showboard.BoardFrame;
import view.ILorannView;

public class FireBall extends Mobile {
	
	private static IMap map;
	
	private static Sprite fireball1;

	
	public FireBall(int x, int y, Sprite sprite, IMap map, Permeability permeability) throws IOException, InterruptedException {
		super(x, y, sprite, map, permeability);
		setMap(map);
		FireBall.setFireball(sprite);
	}

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		FireBall.map = map;
	}

	public static Sprite getFireball() {
		return fireball1;
	}

	public static void setFireball(Sprite fb) {
		FireBall.fireball1 = fb;
	}

	@Override
	public String victory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void magic(BoardFrame bf) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void moveUp() {
		super.moveUp();
	}
	
	/* (non-Javadoc)
	 * @see mobile.Mobile#moveLeft()
	 */
	@Override
	public void moveLeft() {
		super.moveLeft();
	}

	/* (non-Javadoc)
	 * @see mobile.Mobile#moveDown()
	 */
	@Override
	public void moveDown() {
		super.moveDown();
	}

	/* (non-Javadoc)
	 * @see mobile.Mobile#moveRight()
	 */
	@Override
	public void moveRight() {
		super.moveRight();
	}
	
}
