package controller;

import java.io.IOException;
import java.util.Random;

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

				}
				if(this.getModel().getMonster(z).getX() == this.getModel().getLorann().getFb().getX()
						&& this.getModel().getMonster(z).getY() == this.getModel().getLorann().getFb().getY()){
					this.getModel().getMonster(z).monsterDestroyed();
				}
			}
		}

		if (this.getModel().getLorann().victory() == "VICTORY") {
			this.getView().displayMessage(this.getModel().getLorann().victory());
		} else {
			this.getView().displayMessage(this.getModel().getLorann().victory());
		}
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
