package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import model.LorannModel;
import view.LorannView;

/**
 * <h1>Class Main</h1>
 *
 * @author group2
 * @version 1.0
 */
public abstract class Main {

    /** The Constant startX. */
    private static final int startX = 10;

    /** The Constant startY. */
    private static final int startY = 6;
    
	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws SQLException 
	 * @throws IOException 
	 */
	public static void main(final String[] args) throws IOException, SQLException {
		
		
		System.out.println("Enter level (1-5) : ");

	    try{
	        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	        String levelString = bufferRead.readLine();
	        int level = Integer.parseInt(levelString);
	        
	        if(level > 0 && level < 6) {
	        	final LorannModel model = new LorannModel(level, startX, startY);
	        	final LorannView view = new LorannView(model.getMap(), model.getLorann());
	        } else {
	        	System.out.println("Invalid number."); 
	        }
	    }
	    catch(IOException e)
	    {
	        e.printStackTrace();
	    }
	}
}