package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import mobile.IMobile;

public class LorannModel implements IModel{
	
	private IMap map;
	
	private IMobile lorann;
	
	public LorannModel(final int level, final int lorannX, final int lorannY) throws IOException, SQLException{
		this.setMap(new Map(level));
	}

	@Override
	public Example getLevelById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

}
