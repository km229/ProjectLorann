package view;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.IOrderPerformer;
import controller.UserOrder;
import model.IMap;
import model.IMobile;
import showboard.BoardFrame;

/**
 * <h1>Class LorannView</h1>
 *
 * @author group2
 * @version 1.0
 */
public class LorannView implements Runnable, KeyListener, ILorannView {

	/** The Constant length. */
	private int squareSize = 80;
	
	private Rectangle closeView;

	/** The map. */
	private IMap map;

	/** Lorann. */
	private IMobile Lorann;

	/** The order performer. */
	private IOrderPerformer orderPerformer;

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
		this.setMap(map);
		this.setLorann(Lorann);
		this.getLorann().getSprite().loadImage();
		this.setCloseView(new Rectangle(0, this.getLorann().getY(), this.getMap().getWidth(), this.getMap().getHeight()));
		SwingUtilities.invokeLater(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public final void run() {
		final BoardFrame boardFrame = new BoardFrame("Lorann");
		boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
		boardFrame.setSize(this.map.getWidth() * squareSize, this.map.getHeight() * squareSize);
		boardFrame.setDisplayFrame(this.closeView);
		boardFrame.setHeightLooped(true);
        boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);
		boardFrame.setLocationRelativeTo(null);
		
		boardFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
			}
		}
		boardFrame.addPawn(this.getLorann());

		this.getMap().getObservable().addObserver(boardFrame.getObserver());

		boardFrame.setVisible(true);
	}

	/**
	 * Prints the road and the player's vehicle in the console.
	 *
	 * @param yStart
	 *            the y start
	 */
	public final void show(final int yStart) {
		int y = yStart % this.getMap().getHeight();
		for (int x = 0; x < this.getMap().getWidth(); x++) {
			if ((x == this.getLorann().getX()) && (y == yStart)) {
				System.out.print(this.getLorann().getSprite().getConsoleImage());
			} else {
				System.out.print(this.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage());
			}
			y = (y + 1) % this.getMap().getHeight();
			System.out.print("\n");
		}
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
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		default:
			userOrder = UserOrder.NOP;
			break;
		}
		return userOrder;
	}

	public final void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (final IOException exception) {
			exception.printStackTrace();
		}
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
		for (int x = 0; x < (this.getMap().getWidth() - 1); x++) {
			for (int y = 0; y < (this.getMap().getHeight() - 1); y++) {
				
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

	private void setLorann(final IMobile Lorann) {
		this.Lorann = Lorann;
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
	/*
	 * public final void setOrderPerformer(final IOrderPerformer orderPerformer)
	 * { this.orderPerformer = orderPerformer; }
	 */

	public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.exia.insanevehicles.view.IInsaneVehiclesView#displayMessage(java.lang.
	 * String)
	 */
	@Override
	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public void keyReleased(KeyEvent keyEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub

	}

	public int getSquareSize() {
		return squareSize;
	}

	public void setSquareSize(int squareSize) {
		this.squareSize = squareSize;
	}
	
	public Rectangle getCloseView() {
		return closeView;
	}

	public void setCloseView(Rectangle closeView) {
		this.closeView = closeView;
	}
}
