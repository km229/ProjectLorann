package controller;

import java.io.IOException;

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
