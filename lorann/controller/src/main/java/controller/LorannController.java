package controller;

import java.io.File;
import java.io.IOException;

import java.util.Random;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import model.IModel;
import model.Permeability;
import view.ILorannView;

/**
 * <h1>The Class ControllerFacade.</h1>
 *
 * @author group2
 * @version 1.0
 */
/**
 * @author group2
 * @version 1.0
 */
public class LorannController implements ILorannController, IOrderPerformer {

	/** The speed. */
	private static final int speed = 150;
	/** The view. */
	private ILorannView view;

	/** The model. */
	private IModel model;

	/** The stackOrder. */
	private UserOrder stackOrder;
	
	private File yourFile;
	
	private AudioInputStream stream = null;
	
	private AudioFormat format;
	
	private DataLine.Info info;
	
	private	Clip clip = null;
	
	private	Clip clip2 = null;
	
	private boolean victory = true;

	/**
	 * Instantiates a new LorannController.
	 *
	 * @param view
	 *            the view
	 * @param model
	 *            the model
	 */
	public LorannController(final ILorannView view, final IModel model) {
		this.view = view;
		this.model = model;
		this.clearStackOrder();
		yourFile = new File("../sprite/gamemusic.wav");
		musicGame();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ILorannController#play()
	 */
	@Override
	public final void play(int level) throws InterruptedException, IOException {
		int x, y, z = 1;
		switch (level) {
		case 1:
			y = 2;
			break;
		case 2:
			y = 4;
			break;
		case 3:
			y = 2;
			break;
		case 4:
			y = 3;
			break;
		case 5:
			y = 4;
			break;
		default:
			y = 0;
			break;
		}
		Random value = new Random();
		while (this.getModel().getLorann().isAlive()) {
			Thread.sleep(speed);
			switch (this.getStackOrder()) {
			case RIGHT:
				this.getModel().getLorann().moveRight();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveRight();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveLeft();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveUp();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveDown();
				break;
			case LEFT:
				this.getModel().getLorann().moveLeft();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveRight();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveLeft();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveUp();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveDown();
				break;
			case UP:
				this.getModel().getLorann().moveUp();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveRight();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveLeft();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveUp();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveDown();
				break;
			case DOWN:
				this.getModel().getLorann().moveDown();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveRight();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveLeft();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveUp();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveDown();
				break;

			case SPACE:
				this.getModel().getLorann().magic(this.getView().getBoardFrame()); // "Magic" need
				break;

			case NOP:
			default:
				this.getModel().getLorann().doNothing();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveRight();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveLeft();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveUp();
				x = value.nextInt(y) + 1;
				this.getModel().getMonster(x).moveDown();
				break;

			}
			this.clearStackOrder();
			for (z = 1; z <= y; z++) {
				if (this.getModel().getLorann().getX() == this.getModel().getMonster(z).getX()
						&& this.getModel().getLorann().getY() == this.getModel().getMonster(z).getY()
						&& this.getModel().getMonster(z).getPermeability() == Permeability.MONSTER) {
					this.getModel().getLorann().isCrashed();
					victory = false;
				}
					if(this.getModel().getMonster(z).getX() == this.getModel().getLorann().getFb().getX()
							&& this.getModel().getMonster(z).getY() == this.getModel().getLorann().getFb().getY()
							&& this.getModel().getMonster(z).getPermeability() == Permeability.MONSTER){
						this.getModel().getMonster(z).monsterDestroyed();
						yourFile = new File("../sprite/deathmonster.wav");
						music();
					}
				}

			}

		if(victory) {
			clip2.stop();
			yourFile = new File("../sprite/victory.wav");
			music();
		} else {
			clip2.stop();
			yourFile = new File("../sprite/gameover.wav");
			music();
		}
			this.getView().displayMessage(this.getModel().getLorann().victory());
		
	}
	
	
	private void musicGame() {
		// TODO Auto-generated method stub
		try {
			stream = AudioSystem.getAudioInputStream(yourFile);
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    format = stream.getFormat();
	    info = new DataLine.Info(Clip.class, format);
	    try {
			clip2 = (Clip) AudioSystem.getLine(info);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			clip2.open(stream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    clip2.start();
	}
	
	private void music() {
		// TODO Auto-generated method stub
		try {
			stream = AudioSystem.getAudioInputStream(yourFile);
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    format = stream.getFormat();
	    info = new DataLine.Info(Clip.class, format);
	    try {
			clip = (Clip) AudioSystem.getLine(info);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			clip.open(stream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    clip.start();
	}
	

	/**
	 * Gets the view.
	 *
	 * @return the view
	 */
	public ILorannView getView() {
		return this.view;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.IOrderPerformer#orderPerform(controller.UserOrder)
	 */
	@Override
	public final void orderPerform(final UserOrder userOrder) throws IOException {
		this.setStackOrder(userOrder);
	}


	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public IModel getModel() {
		return this.model;
	}

	/**
	 * Gets the stack order.
	 *
	 * @return the stack order
	 */
	private UserOrder getStackOrder() {
		return this.stackOrder;
	}

	/**
	 * Sets the stack order.
	 *
	 * @param stackOrder
	 *            the new stack order
	 */
	private void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	/**
	 * Clear stack order.
	 */
	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ILorannController#getOrderPeformer()
	 */
	@Override
	public IOrderPerformer getOrderPeformer() {
		return this;
	}

}
