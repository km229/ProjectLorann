package mobile;

import java.awt.Point;

import element.Element;
import model.IMap;
import model.IMobile;
import model.Permeability;
import model.Sprite;
import showboard.IBoard;

public abstract class Mobile extends Element implements IMobile {

	/**
	 * The x.
	 */
	private Point position;

	/** The alive. */
	private Boolean alive = true;

	/** The road. */
	private IMap map;

	/** The board. */
	private IBoard board;

	/**
	 * Instantiates a new mobile.
	 *
	 * @param sprite
	 *            the sprite
	 * @param road
	 *            the road
	 * @param permeability
	 *            the permeability
	 */
	Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map);
		this.position = new Point();
	}

	/**
	 * Instantiates a new mobile.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param sprite
	 *            the sprite
	 * @param road
	 *            the road
	 * @param permeability
	 *            the permeability
	 */
	Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
		this(sprite, map, permeability);
		this.setX(x);
		this.setY(y);
	}

	@Override
	public void moveUp() {	
		if(this.getY() != 0) {
			if(this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1).getPermeability() == Permeability.PENETRABLE) {
				this.setY(this.getY() - 1);
				this.setHasMoved();
			}
		}
	}

	@Override
	public void moveLeft() {
		if(this.getX() != 0) {
			if(this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.PENETRABLE) {	
				this.setX(this.getX() - 1);
				this.setHasMoved();
			}
		}
	}

	@Override
	public void moveDown() {
		if(this.getY() != this.getMap().getHeight()) {
			if(this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1).getPermeability() == Permeability.PENETRABLE) {
				this.setY(this.getY() + 1);
				this.setHasMoved();
			}
		}
	}

	@Override
	public void moveRight() {
		if(this.getX() != this.getMap().getWidth()) {
			if(this.getMap().getOnTheMapXY(this.getX()+ 1, this.getY()).getPermeability() == Permeability.PENETRABLE) {
				this.setX(this.getX() + 1);
				this.setHasMoved();
			}
		}
	}

	@Override
	public void doNothing() {
		this.setHasMoved();
	}

	protected void setY(int y) {
		this.getPosition().y = y;
		if (this.isCrashed()) {
			this.die();
		}
	}

	protected void setX(int x) {
		this.getPosition().x = x;
		if (this.isCrashed()) {
			this.die();
		}
	}

	public final int getY() {
		
		return this.getPosition().y;
	}

	public final int getX() {
		return this.getPosition().x;
	}

	protected void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

	public Boolean isAlive() {
		return alive;
	}

	public void die() {
		this.alive = false;
		this.setHasMoved();
	}

	public Boolean isCrashed() {
		return false;
		// TODO Auto-generated method stub
		//return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
	}

    public Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
    public void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Gets the board.
     *
     * @return the board
     */
    protected IBoard getBoard() {
        return this.board;
    }
	
}
