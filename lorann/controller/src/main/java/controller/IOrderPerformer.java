package controller;

import java.io.IOException;

/**
 * <h1>Interface IOrderElement</h1>
 *
 * @author group2
 * @version 1.0
 */

public interface IOrderPerformer {
	
	 /**
     * Order perform.
     *
     * @param userOrder
     *            the user order
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    void orderPerform(UserOrder userOrder) throws IOException;

	 /**
     * Method to start the game.
     *
     * @param level
     *            the level of the game
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     * @throws InterruptedException
     * 				the interrupted exception
     */
	void play(int level) throws InterruptedException, IOException;

}
