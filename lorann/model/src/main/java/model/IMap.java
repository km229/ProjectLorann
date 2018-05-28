package model;

import element.Element;

public interface IMap {

	void setMobileHasChanged();

	int getHeight();

	Element getOnTheMapXY(int x, int y);

}
