package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Observable;

import element.Element;
import element.IElement;
import motionless.MotionlessElementFactory;
import model.dao.*;

public class Map extends Observable implements IMap {

	/** The width. */
	private int width;

	/** The height. */
	private int height;

	/** The on the road. */
	private IElement[][] onTheMap;

	private LorannDAO dao = new LorannDAO();

	/**
	 * Instantiates a new road with the content of the file fileName.
	 *
	 * @param fileName
	 *            the file name where the map of the road is
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
	 * @param fileName
	 *            the file name
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
		line = buffer.readLine();
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
		while (y != (this.getHeight() - 1)) {
			for (int x = 0; x != (this.getWidth() -1); x++) {
				this.setOnTheMapXY(MotionlessElementFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
			}
			line = buffer.readLine();
			y++;
		}
		buffer.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getWidth()
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getHeight()
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getOnTheRoadXY(int, int)
	 */
	@Override
	public final Element getOnTheMapXY(final int x, final int y) {
		return (Element) this.onTheMap[x][y];
	}

	/**
	 * Sets the on the road XY.
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#setMobileHasChanged()
	 */
	@Override
	public final void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this;
	}

}
