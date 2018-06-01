package model;

import java.awt.Point;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import mobile.Lorann;

/**
 * <h1>LorannModel Class</h1>
 * 
 * @author group2
 * @version 1.0
 *
 */
public class LorannModel implements IModel{
	
	/** The map */
	private IMap map;
	
	/** The lorann */
	private IMobile lorann;
	
	/** The position */
	private Point position;
	
	
	/**
	 * @param level
	 * 		The level
	 * @param lorannX
	 * 		The position X of lorann
	 * @param lorannY
	 * 		The position Y of lorann
	 * @throws IOException
	 * @throws SQLException
	 */
	public LorannModel(final int level, final int lorannX, final int lorannY) throws IOException, SQLException{
		this.setMap(new Map(level));
		this.setLorann(new Lorann(lorannX, lorannY, this.getMap()));
	}
	
	/**
	 * @param level
	 * 		The level
	 * @throws IOException
	 * @throws SQLException
	 */
	public LorannModel(final int level) throws IOException, SQLException{
		this.setMap(new Map(level));
		this.setLorann(new Lorann(this.position.x, this.position.y, this.getMap()));
	}

	/* (non-Javadoc)
	 * @see model.IModel#getLevelById(int)
	 */
	@Override
	public void getLevelById(int id) throws SQLException {

	}

    /* (non-Javadoc)
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


}
