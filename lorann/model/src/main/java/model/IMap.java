package model;

import java.util.Observable;

import element.Element;

public interface IMap {

	void setMobileHasChanged();

	int getHeight();

	Element getOnTheMapXY(int x, int y);

	Observable getObservable();

	int getWidth();
	
	void setOnTheMapXY(final IElement element, final int x, final int y);
	
	void dieOntheMapXY(final int x, final int Y);

}
