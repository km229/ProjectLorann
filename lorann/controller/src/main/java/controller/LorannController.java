package controller;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

import model.IModel;
import view.ILorannView;

/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class LorannController implements ILorannController,IOrderPerformer {

    /** The view. */
    private final ILorannView  view;

    /** The model. */
    private final IModel model;

    private UserOrder            stackOrder;
    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public LorannController(final ILorannView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
    public void start() throws SQLException {

    }

    
    @Override
    public final void play() throws InterruptedException {
        while (this.getModel().getLorann().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getLorann().moveRight();
                    break;
                case LEFT:
                    this.getModel().getLorann().moveLeft();
                    break;
                case UP:
                    this.getModel().getLorann().moveUP();
                    break;
                case DOWN:
                    this.getModel().getLorann().moveDown();
                    break;
                case MAGIC:
                    this.getModel().getLorann().MagicFire(); // "Magicfire"  need rename 
                    break;
                case NOP:
                default:
                    this.getModel().getLorann().doNothing();
                    break;
            }
            this.clearStackOrder();
            if (this.getModel().getLorann().isAlive()) {
                this.getModel().getLorann().moveDown();
            }
            this.getView().followMyVehicle();
        }
        this.getView().displayMessage("GAME OVER");
    }
    
    /**
     * Gets the view.
     *
     * @return the view
     */
    public ILorannView getView() {
        return this.view;
    }
    
    @Override
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }
    
    private void setView(final ILorannController view) {
        this.view = view;
    }
    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
    
    private void setModel(final ILorannController model) {
        this.model = model;
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
    
    
	@Override
	public IOrderPerformer getOrderPeformer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
