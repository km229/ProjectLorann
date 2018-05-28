package element;

import javax.swing.ImageIcon;

import showboard.ISquare;

/**
 * <h1>Interface IElement</h1>
 *
 * @author group2
 * @version 1.0
 * @see ISquare
 */

public interface IElement extends ISquare{

    /**
     * Gets the sprite.
     *
     * @return sprite
     */
    Sprite getSprite();

    /**
     * Gets the permeability.
     *
     * @return permeability
     */
    Permeability getPermeability();

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.ISquare#getImage()
     */
    @Override
    ImageIcon getImage();

}
