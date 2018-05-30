package mobile;

public class Behaviour2 implements IBehaviour{

	private char ID = '2';
	
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
