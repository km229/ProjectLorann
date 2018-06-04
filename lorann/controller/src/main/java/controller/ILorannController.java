package controller;

import java.io.IOException;

/**
 * <h1>Interface ILorannController</h1>
 *
 * @author group2
 * @version 1.0
 */

public interface ILorannController {
	
	 /**
     * Play.
     *
     * @param level
     * @throws InterruptedException
     *             the interrupted exception
	 * @throws IOException 
     */
    void play(int level) throws InterruptedException, IOException;

    /**
     * Gets the order peformer.
     *
     * @return the order peformer
     */
    IOrderPerformer getOrderPeformer();

}
