package motionless;

/**
 * <h1>A factory to create MotionlessElements objects.</h1>
 *
 * @author group2
 * @version 1.0
 */

public class MotionlessElementFactory {

	/** The Constant crystalBall. */
	private static final CrystalBall crystalBall = new CrystalBall();

	/** The Constant gate. */
	private static final Gate gate = new Gate();

	/** The Constant bone. */
	private static final Bone bone = new Bone();

	/** The Constant horizontalBone. */
	private static final HorizontalBone horizontalBone = new HorizontalBone();

	/** The Constant verticalBone. */
	private static final VerticalBone verticalBone = new VerticalBone();

	/** The Constant purse. */
	private static final Purse purse = new Purse();
	
	private static final Ground ground = new Ground();

	/**
	 * The motionless elements is an array of all possible MotionlessElement.
	 */

	private static MotionlessElement[] motionlessElements = { crystalBall, gate, bone, horizontalBone, verticalBone, purse };
	
	   /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createCrystalBall() {
        return crystalBall;
    }
    
    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createGate() {
        return gate;
    }
    
    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createBone() {
        return bone;
    }
    
    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createHorizontalBone() {
        return horizontalBone;
    }
    
    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createVerticalBone() {
        return verticalBone;
    }
    
    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createPurse() {
        return purse;
    }
	
    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createGround() {
        return ground;
    }
    
    public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return ground;
    }
}
