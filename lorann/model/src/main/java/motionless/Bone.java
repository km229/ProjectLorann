package motionless;

import element.Permeability;
import element.Sprite;

/**
 * <h1>Bone Class</h1>
 *
 * @author group2
 * @version 1.0
 */

public class Bone extends MotionlessElement {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('o', "bone.png");

	/**
	 * Instantiates a new bone.
	 */
	public Bone() {
		super(SPRITE, Permeability.BLOCKING);
	}

}
