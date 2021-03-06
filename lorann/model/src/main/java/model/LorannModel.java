package model;

import java.awt.Point;

import java.io.IOException;
import java.sql.SQLException;

import mobile.Lorann;
import mobile.Monster1;
import mobile.Monster2;
import mobile.Monster3;
import mobile.Monster4;

/**
 * <h1>LorannModel Class</h1>
 * 
 * @author group2
 * @version 1.0
 *
 */
public class LorannModel implements IModel {

	/** The map */
	private IMap map;

	/** The lorann */
	private IMobile lorann;

	/** The position */
	private Point position;

	private IMobile monster1;

	private IMobile monster2;

	private IMobile monster3;

	private IMobile monster4;

	/**
	 * @param level
	 *            The level
	 * @param lorannX
	 *            The position X of lorann
	 * @param lorannY
	 *            The position Y of lorann
	 * @throws IOException
	 * @throws SQLException
	 * @throws InterruptedException 
	 */
	public LorannModel(final int level, final int lorannX, final int lorannY) throws IOException, SQLException, InterruptedException {
		this.setMap(new Map(level));
		this.setMonsters(level);
		this.setLorann(new Lorann(lorannX, lorannY, this.getMap()));
		
	}

	/**
	 * @param level
	 *            The level
	 * @throws IOException
	 * @throws SQLException
	 * @throws InterruptedException 
	 */
	public LorannModel(final int level) throws IOException, SQLException, InterruptedException {
		this.setMap(new Map(level));
		this.setLorann(new Lorann(this.position.x, this.position.y, this.getMap()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IModel#getLevelById(int)
	 */
	@Override
	public void getLevelById(int id) throws SQLException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IModel#getLorann()
	 */
	public IMobile getLorann() {
		return this.lorann;
	}

	/**
	 * Sets lorann
	 * 
	 * @param lorann
	 */
	private void setLorann(Lorann lorann) {
		this.lorann = (IMobile) lorann;
	}

	/**
	 * Gets the map
	 * 
	 * @return map
	 */
	public IMap getMap() {
		return map;
	}

	/**
	 * Sets the map
	 * 
	 * @param map
	 */
	public void setMap(IMap map) {
		this.map = map;
	}

	public void setMonsters(final int level) throws IOException {
		
			
		switch (level) {
		case 1:
			this.monster1 = new Monster1(7, 5, map, Permeability.MONSTER);
			this.monster2 = new Monster2(3, 4, map, Permeability.MONSTER);
			this.monster3 = new Monster3(5, 8, map, Permeability.MONSTER);
			this.monster4 = new Monster4(5, 2, map, Permeability.MONSTER);
 
			break;
		case 2:
			this.monster1 = new Monster1(10, 4, map, Permeability.MONSTER);
			this.monster2 = new Monster2(10, 6, map, Permeability.MONSTER);
			this.monster3 = new Monster3(10, 8, map, Permeability.MONSTER);
			this.monster4 = new Monster4(10, 10, map, Permeability.MONSTER);

			break;
		case 3:
			this.monster1 = new Monster1(7, 6, map, Permeability.MONSTER);
			this.monster2 = new Monster2(7, 5, map, Permeability.MONSTER);
			this.monster3 = new Monster3(10, 2, map, Permeability.MONSTER);
			this.monster4 = new Monster4(17, 1, map, Permeability.MONSTER);
 
			
			break;
		case 4:
			this.monster1 = new Monster1(16, 1, map, Permeability.MONSTER);
			this.monster2 = new Monster2(12, 10, map, Permeability.MONSTER);
			this.monster3 = new Monster3(1, 3, map, Permeability.MONSTER);
			this.monster4 = new Monster4(12, 7, map, Permeability.MONSTER);

			break;
		case 5:
			this.monster1 = new Monster1(8, 4, map, Permeability.MONSTER);
			this.monster2 = new Monster2(4, 6, map, Permeability.MONSTER);
			this.monster3 = new Monster3(4, 4, map, Permeability.MONSTER);
			this.monster4 = new Monster4(15, 8, map, Permeability.MONSTER);

			break;
		default:
			break;
			
		}
	}
	

	public IMobile getMonster(int monster) {
		switch (monster) {
		case 1:
			return monster1;
		case 2:
			return monster2;
		case 3:
			return monster3;
		case 4:
			return monster4;
		default:
			return null;
		}
	}

	public void setMonster(int monster, IMobile Monster) {
		switch (monster) {
		case 1:
			this.monster1 = Monster;
			break;
		case 2:
			this.monster2 = Monster;
			break;
		case 3:
			this.monster3 = Monster;
			break;
		case 4:
			this.monster4 = Monster;
			break;
		}
	}




}
