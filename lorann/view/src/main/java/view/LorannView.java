package view;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.IOrderPerformer;
import controller.UserOrder;
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
	private int height = 20;

	/** The Constant length. */
	private int length = 12;

	/** The Constant View */
	private Rectangle view;

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
		this.setView(new Rectangle(0, this.getLorann().getY(), this.getMap().getWidth(), height));
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
		boardFrame.setDisplayFrame(this.view);
		boardFrame.setSize(this.view.width * height, this.view.height * length);
		boardFrame.setHeightLooped(true);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);

		for (int x = 0; x < this.getMap().getWidth(); x = x + 1) {
			for (int y = 0; y < this.getMap().getHeight(); y = y + 1) {
				boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
			}
		}
		boardFrame.addPawn(this.getLorann());

		this.getMap().getObservable().addObserver(boardFrame.getObserver());
		this.followLorann();

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */

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

	private void setLorann(final IMobile Lorann) {
		this.Lorann = Lorann;
	}

	/**
	 * Sets the view.
	 *
	 * @param rectangle
	 *            the new view
	 */
	private void setView(final Rectangle view) {
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

	public Rectangle getView() {
		return this.view;
	}
}
