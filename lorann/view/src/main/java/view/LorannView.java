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
import model.LorannModel;
import showboard.BoardFrame;

/**
 * <h1>Class LorannView</h1>
 *
 * @author group2
 * @version 1.0
 */
public class LorannView implements Runnable, KeyListener, ILorannView {

	/** The Constant squareSize. */
	private int squareSize = 80;
	
	/** The closeView.  */
	private Rectangle closeView;

	/** The map. */
	private IMap map;

	/** Lorann. */
	private IMobile Lorann;

	/** The order performer. */
	private IOrderPerformer orderPerformer;
	
	private IMobile monster1;
	
	private IMobile monster2;
	
	private IMobile monster3;
	
	private IMobile monster4;

	/**
	 * Instantiates a new insane vehicles View.
	 *
	 * @param map
	 *            the map
	 * @param Lorann
	 *            the Lorann
	 * @param model 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public LorannView(final IMap map, final IMobile Lorann, LorannModel model) throws IOException {
		this.setMap(map);
		this.setLorann(Lorann);
		this.getLorann().getSprite().loadImage();
		this.monster1 = model.getMonster(1);
		this.monster2 = model.getMonster(2);
		this.monster3 = model.getMonster(3);
		this.monster4 = model.getMonster(4);
		this.setCloseView(new Rectangle(0, 0, this.getMap().getWidth(), this.getMap().getHeight()));
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
		boardFrame.setHeightLooped(false);
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
		for(int i=1; i<5; i++){
			if(this.getMonster(i) != null){
				boardFrame.addPawn(this.getMonster(i));
			}
		}

		this.getMap().getObservable().addObserver(boardFrame.getObserver());

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
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		case KeyEvent.VK_SPACE:
			userOrder = UserOrder.SPACE;
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
	
	public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	
	/* (non-Javadoc)
	 * @see view.ILorannView#displayMessage(java.lang.String)
	 */
	@Override
	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent keyEvent) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent keyEvent) {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the squareSize
	 * 
	 * @return squareSize
	 */
	public int getSquareSize() {
		return squareSize;
	}

	/**
	 * Sets the squareSize
	 * 
	 * @param squareSize
	 */
	public void setSquareSize(int squareSize) {
		this.squareSize = squareSize;
	}
	
	/**
	 * Gets the closeView
	 * 
	 * @return closeView
	 */
	public Rectangle getCloseView() {
		return closeView;
	}

	/**
	 * Sets the closeView
	 * 
	 * @param closeView
	 */
	public void setCloseView(Rectangle closeView) {
		this.closeView = closeView;
	}
	
	public IMobile getMonster(int monster) {
		switch (monster) {
		case 1:
			return monster1;
		case 2:
			return monster2;
		case 3:
			return monster3;
		case 4:
			return monster4;
		default:
			return null;
		}
	}

	public void setMonster(int monster, IMobile Monster) {
		switch (monster) {
		case 1:
			this.monster1 = Monster;
			break;
		case 2:
			this.monster2 = Monster;
			break;
		case 3:
			this.monster3 = Monster;
			break;
		case 4:
			this.monster4 = Monster;
			break;
		}
	}
}
