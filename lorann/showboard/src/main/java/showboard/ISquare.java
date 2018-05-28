package showboard;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * <h1>The Interface ISquare.</h1>
 * <p>
 * A class can implement the ISquare interface when it wants to be show on a IBoard.
 * </p>
 *
 * @author Anne-Emilie DIET
 * @version 1.1
 * @see Image
 */
public interface ISquare {

    /**
     * Gets the image.
     *
     * @return the image
     */
    ImageIcon getImage();
}
