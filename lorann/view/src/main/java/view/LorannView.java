package view;

import java.awt.Dimension;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import mobile.IMobile;
import model.IMap;
import showboard.BoardFrame;


/**
 * <h1>Class LorannView</h1>
 *
 * @author group2
 * @version 1.0
 */
public class LorannView implements Runnable, KeyListener, ILorannView {


	 /** The Constant height. */
    private static final int height = 200;

    /** The Constant length. */
    private static final int length = 120;

    /** The map. */
    private IMap            map;

    /** Lorann. */
    private IMobile          Lorann;

    /** The view. */
    private int              view;
    
    /** The order performer. */
    private IOrderPerformer  orderPerformer;

    /**
     * Instantiates a new insane vehicles View.
     *
     * @param map
     *            the map
     * @param Lorann
     *            the Lorann
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public LorannView(final IMap map, final IMobile Lorann) throws IOException {
    	this.setView(mapView);
        this.setMap(map);
        this.setLorann(Lorann);
        this.getLorann().getSprite().loadImage();
    }

  
    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public final void run() {
    	 final BoardFrame boardFrame = new BoardFrame("Lorann");
         boardFrame.setSize(height, length);
         boardFrame.setHeightLooped(true);
         boardFrame.addKeyListener(this);
         boardFrame.setFocusable(true);
         boardFrame.setFocusTraversalKeysEnabled(false);
         boardFrame.addPawn(this.getLorann());
         this.getMap().getObservable().addObserver(boardFrame.getObserver());
         this.followLorann();
         boardFrame.setVisible(true);
     }
    
    

    /**
     * Key code to user order.
     *
     * @param keyCode
     *            the key code
     * @return the user order
     */
    private static UserOrder keyCodeToUserOrder(final int keyCode) {
        UserOrder userOrder;
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                userOrder = UserOrder.RIGHT;
                break;
            case KeyEvent.VK_LEFT:
                userOrder = UserOrder.LEFT;
                break;
            default:
                userOrder = UserOrder.NOP;
                break;
        }
        return userOrder;
    }
    
	@Override
	public void keyPressed(final KeyEvent keyEvent) {
        
    }


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void followLorann() {
		// TODO Auto-generated method stub
		
	}
	  /**
     * Gets the map.
     *
     * @return the map
     */
    private IMap getMap() {
        return this.map;
    }
    /**
     * Sets the map.
     *
     * @param map
     *            the new map
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void setMap(final IMap map) throws IOException {
        this.map = map;
        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
            }
        }
    }
    /**
     * Gets Lorann.
     *
     * @return Lorann
     */
    private IMobile getLorann() {
        return this.Lorann;
    }
    /**
     * Gets the view.
     *
     * @return the view
     */
    private int getView() {
        return this.view;
    }
    /**
     * Sets the view.
     *
     * @param view
     *            the new view
     */
    private void setView(final int view) {
        this.view = view;
    }
    /**
     * Gets the order performer.
     *
     * @return the order performer
     */
    private IOrderPerformer getOrderPerformer() {
        return this.orderPerformer;
    }
    /**
     * Sets the order performer.
     *
     * @param orderPerformer
     *            the new order performer
     */
    public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }


	@Override
	public void displayMessage(String message) {
		// TODO Auto-generated method stub
		
	}

}
