package motionless;

import model.Permeability;
import model.Sprite;

/**
 * <h1>Ground Class</h1>
 *
 * @author group2
 * @version 1.0
 */

public class Ground extends MotionlessElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite(' ', "ground.png");

	/**
	 * Instantiates a new ground.
	 */
	public Ground() {
		super(SPRITE, Permeability.PENETRABLE);
	}

}
