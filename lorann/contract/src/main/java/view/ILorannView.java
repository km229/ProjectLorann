package view;

import java.awt.event.KeyEvent;
import showboard.BoardFrame;

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
     * Display message.
     *
     * @param message
     *            the message
     */
	void keyReleased(KeyEvent keyEvent);
	
    /**
     * Display message.
     *
     * @param message
     *            the message
     */
	void keyTyped(KeyEvent keyEvent);

    /**
     * Return our boardframe.
     *
     * @return boardframe
     *            the boardframe
     */
	BoardFrame getBoardFrame();
}
