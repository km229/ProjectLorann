package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import mobile.IMobile;
import mobile.Lorann;

public class LorannModel implements IModel{
	
	private IMap map;
	
	private IMobile lorann;
	
	public LorannModel(final int level, final int lorannX, final int lorannY) throws IOException, SQLException{
		this.setMap(new Map(level));
		this.setLorann(new Lorann(lorannX, lorannY, this.getMap()));
	}

	@Override
	public Example getLevelById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

    public final IMobile getLorann() {
        return this.lorann;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the road to set
     */
    private void setLorann(final IMobile lorann) {
        this.lorann = lorann;
    }
	
	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

}
