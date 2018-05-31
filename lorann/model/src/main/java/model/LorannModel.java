package model;

import java.awt.Point;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import mobile.Boss;
import mobile.Lorann;

public class LorannModel implements IModel {

	private IMap map;

	private IMobile lorann;

	private IMobile boss;

	private Point position;

	public LorannModel(final int level) throws IOException, SQLException {
		this.setSpawnXY(level);
		this.setMap(new Map(level));
		this.setLorann(new Lorann(position.x, position.y, this.getMap()));
	}

	@Override
	public void getLevelById(int id) throws SQLException {

	}

	public IMobile getLorann() {
		return this.lorann;
	}

	/**
	 * Sets the road.
	 *
	 * @param road
	 *            the road to set
	 */

	public IMobile getBoss() {
		return this.boss;
	}

	private void setLorann(Lorann lorann) {
		this.lorann = (IMobile) lorann;
	}

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

	private void setSpawnXY(int level) {

		if (level == 1) {

			this.position.setLocation(17, 5);

		} else if (level == 2) {

			this.position.setLocation(18, 1);

		} else if (level == 3) {

			this.position.setLocation(1, 1);

		} else if (level == 4) {

			this.position.setLocation(2, 2);

		} else if (level == 5) {

			this.position.setLocation(1, 6);

		}

	}

}
