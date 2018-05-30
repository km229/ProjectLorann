package mobile;

public class Behaviour3 implements IBehaviour{

	private char ID = '3';
	
	public char getID() {
		return ID;
	}
	
	@Override
	public int moveCommand() {
		// TODO Auto-generated method stub
		
		return 0;
	}
	
	public String getImage() {
		
		String imageName = null;
		
		imageName = "monster_2.png";

		return imageName;
	}
	
}
