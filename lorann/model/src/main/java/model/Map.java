package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Observable;

import element.Element;
import motionless.MotionlessElementFactory;
import model.dao.*;

/**
 * <h1>IMap Class</h1>
 * 
 * @author group2
 * @version 1.0
 *
 */
public class Map extends Observable implements IMap {

	/** The width. */
	private int width;

	/** The height. */
	private int height;

	/** The on the map. */
	private IElement[][] onTheMap;

	/** The LorannDAO */
	private LorannDAO dao = new LorannDAO();

	/**
	 * Instantiates a new road with the content of the file fileName.
	 *
	 * @param level
	 *            the file level where the map of the map is
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws SQLException
	 */
	Map(final int level) throws IOException, SQLException {
		super();
		this.loadFile(level);
	}

	/**
	 * Loads file.
	 *
	 * @param level
	 *            the level
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws SQLException
	 */
	private void loadFile(final int level) throws IOException, SQLException {
		final BufferedReader buffer = new BufferedReader(new InputStreamReader(dao.getLevelById(level)));
		String line;
		int y = 0;
		line = buffer.readLine();
		this.setWidth(Integer.parseInt(line));
		line = buffer.readLine();
		this.setHeight(Integer.parseInt(line));
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
		line = buffer.readLine();
		while (y != ((this.getHeight()))) {
			for (int x = 0; x != (this.getWidth()); x++) {
				this.setOnTheMapXY(MotionlessElementFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);

				
			}
			System.out.println(line);
			line = buffer.readLine();
			y++;
		}
		System.out.println(line);
		buffer.close();
	}


	/* (non-Javadoc)
	 * @see model.IMap#getWidth()
	 */
	@Override
	public final int getWidth() {
		return this.width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width
	 *            the new width
	 */
	private void setWidth(final int width) {
		this.width = width;
	}

	
	/* (non-Javadoc)
	 * @see model.IMap#getHeight()
	 */
	@Override
	public final int getHeight() {
		return this.height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height
	 *            the new height
	 */
	private void setHeight(final int height) {
		this.height = height;
	}

	
	/* (non-Javadoc)
	 * @see model.IMap#getOnTheMapXY(int, int)
	 */
	@Override
	public final Element getOnTheMapXY(final int x, final int y) {
		return (Element) this.onTheMap[x][y];
	}

	/**
	 * Sets the on the map XY.
	 *
	 * @param element
	 *            the element
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 */
	public void setOnTheMapXY(final IElement element, final int x, final int y) {
		this.onTheMap[x][y] = element;
	}


	/* (non-Javadoc)
	 * @see model.IMap#setMobileHasChanged()
	 */
	@Override
	public final void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	/* (non-Javadoc)
	 * @see model.IMap#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this;
	}
	
	/* (non-Javadoc)
	 * @see model.IMap#dieOntheMapXY(int, int)
	 */
	public void dieOntheMapXY(final int x, final int y){
		this.onTheMap[x][y]=null;
	}

}
