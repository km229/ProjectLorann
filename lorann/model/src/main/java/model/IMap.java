package model;

import java.util.Observable;

import element.Element;
import element.IElement;

public interface IMap {

	void setMobileHasChanged();

	int getHeight();

	Element getOnTheMapXY(int x, int y);

	Observable getObservable();

	int getWidth();

}
