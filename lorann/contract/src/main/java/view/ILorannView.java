package view;

import java.awt.event.KeyEvent;

/**
 * <h1>Interface ILorannView.</h1>
 *
 * @author group2
 * @version 1.0
 */
public interface ILorannView {

    /**
     * Display message.
     *
     * @param message
     *            the message
     */
    void displayMessage(String message);
    /**
     * Follow Lorann.
     */
    void followLorann();
	void keyReleased(KeyEvent keyEvent);
	void keyTyped(KeyEvent keyEvent);
}
