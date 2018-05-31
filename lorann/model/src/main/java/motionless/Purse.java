package motionless;

import model.Permeability;
import model.Sprite;

/**
 * <h1>Purse Class</h1>
 *
 * @author group2
 * @version 1.0
 */

public class Purse extends MotionlessElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('p', "purse.png");

	/**
	 * Instantiates a new purse.
	 */
	public Purse() {
		super(SPRITE, Permeability.PURSE);
	}

}
