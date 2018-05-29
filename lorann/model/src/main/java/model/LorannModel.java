package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import mobile.IMobile;

public class LorannModel implements IModel{
	
	private IMap map;
	
	private IMobile lorann;
	
	public LorannModel(final String filename, final int lorannX, final int lorannY) throws IOException{
		this.setMap(new Map(filename));
	}

	@Override
	public Example getExampleById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Example getExampleByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Example> getAllExamples() throws SQLException {
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
