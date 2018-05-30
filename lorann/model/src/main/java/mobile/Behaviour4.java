package mobile;

public class Behaviour4 implements IBehaviour{

	private char ID = '4';
	
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
		
		imageName = "monster_4.png";

		return imageName;
	}
	
}
