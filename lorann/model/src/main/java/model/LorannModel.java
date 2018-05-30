package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import mobile.Lorann;

public class LorannModel implements IModel{
	
	private IMap map;
	
	private IMobile lorann;
	
	public LorannModel(final int level, final int lorannX, final int lorannY) throws IOException, SQLException{
		this.setMap(new Map(level));
		this.setLorann(new Lorann(lorannX, lorannY, this.getMap()));
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
    private void setLorann(Lorann lorann) {
        this.lorann = (IMobile) lorann;
    }
	
	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

}
