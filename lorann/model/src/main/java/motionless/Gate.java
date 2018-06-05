package motionless;

import model.Permeability;

import model.Sprite;

/**
 * <h1>Gate Class</h1>
 *
 * @author group2
 * @version 1.0
 */

public class Gate extends MotionlessElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('g', "gate_closed.png");

	/**
	 * Instantiates a new gate.
	 */
	public Gate() {
		super(SPRITE, Permeability.MONSTER);
	}

}
