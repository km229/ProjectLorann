package mobile;

public class Behaviour1 implements IBehaviour {

	private char ID = '1';
	
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
		
		imageName = "monster_1.png";

		return imageName;
	}

	
}
