package model;

import java.io.IOException;
import showboard.BoardFrame;
import showboard.IPawn;

/**
 * <h1>Interface IMobile</h1>
 *
 * @author group2
 * @version 1.0
 * @see IPawn, IElement
 */

public interface IMobile extends IPawn, IElement {

    /**
     * Move up.
     */
    void moveUp();

    /**
     * Move left.
     */
    void moveLeft();

    /**
     * Move down.
     */
    void moveDown();

    /**
     * Move right.
     */
    void moveRight();

    /**
     * Do nothing.
     */
    void doNothing();

    /**
     * Gets the x.
     *
     * @return the x
     */
    @Override
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    int getY();

    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    Boolean isAlive();
    
    /**
     * Checks if the lorann has found the CrystalBall.
     *
     * @return the boolean
     */
    String victory();

	/**
	 * the power of Lorann.
	 * 
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	void magic(BoardFrame bf) throws IOException, InterruptedException;
	
    /**
     * Return our boardframe.
     *
     * @return the boardframe
     */
	IMobile getFb();
	
    /**
     * Checks if is alive.
     *
     * @return the alive
     */
	void monsterDestroyed();

	void isCrashed();

}
