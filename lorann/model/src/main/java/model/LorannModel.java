package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import mobile.Boss;
import mobile.Lorann;

public class LorannModel implements IModel{
	
	private IMap map;
	
	private IMobile lorann;
	
	private IMobile boss;
	
	public LorannModel(final int level) throws IOException, SQLException{
		this.setSpawnXY(level);
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
		// TODO Auto-generated method stub
		
	}

}
