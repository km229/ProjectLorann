package model;

import java.util.Observable;


import element.Element;

/**
 * <h1>IMap interface</h1>
 * 
 * @author group2
 * @version 1.0
 *
 */
public interface IMap {

	void setMobileHasChanged();

	/**
	 * @return the height
	 */
	int getHeight();

	/**
	 * @param x
	 * 		The position X.
	 * @param y
	 * 		The position Y.
	 * @return 	x and y.
	 */
	Element getOnTheMapXY(int x, int y);

	/**
	 * @return Observable.
	 */
	Observable getObservable();

	/**
	 * @return the width.
	 */
	int getWidth();
	
	/**
	 * @param element
	 * 		The element.
	 * @param x
	 * 		The position X.
	 * @param y
	 * 		The position Y.
	 */
	void setOnTheMapXY(final IElement element, final int x, final int y);

}
