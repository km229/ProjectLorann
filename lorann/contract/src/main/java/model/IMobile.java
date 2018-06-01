package model;

import java.awt.Point;
import java.io.IOException;

import showboard.IPawn;

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
     * Checks if the lorann crashed in a monster.
     *
     * @return the boolean
     */
    void isCrashed();
    
    /**
     * Checks if the lorann has found the CrystalBall.
     *
     * @return the boolean
     */
    String victory();

	/**
	 * @throws IOException
	 */
	void magic() throws IOException;

}
