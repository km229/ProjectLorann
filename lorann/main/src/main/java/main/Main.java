package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import controller.LorannController;
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
    private static int startX = 0;

    /** The Constant startY. */
    private static int startY = 0;
    
	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(final String[] args) throws IOException, SQLException, InterruptedException {
		
		System.out.println("Enter level (1-5) : ");

		try{
	    	
	        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	        String levelString = bufferRead.readLine();
	        Boolean iswholeNumber = WholeNumber(levelString);
 
	        if(!iswholeNumber) {
	        	int level = Integer.parseInt(levelString);
	        
	        	if(level > 0 && level < 6) {
	        		Start(level);
	        		
	        	} else {
	        	
	        		Error();
	        	
	        	}
	        } else {
	        	
	        	Error();
	        	
	        }
	        
	        
		}
	    
		catch(IOException e)
		{
			e.printStackTrace();
		}
	
	}

	
	
	public static boolean WholeNumber(String string) {
		try {
			Integer.parseInt(string);
		} catch (NumberFormatException e){
			return true;
		}
 
		return false;
	}
	
	
	public static void Error() throws IOException, SQLException, InterruptedException {
		
		System.out.println("Invalid number."); 
		main(null);
		
	}
	
	public static void Start(int level) throws IOException, SQLException, InterruptedException {
		System.out.println("Game start!");		
		final LorannModel model = new LorannModel(level);
		final LorannView view = new LorannView(model.getMap(), model.getLorann());
		final LorannController controller = new LorannController(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());
        controller.play();
	}
	
}