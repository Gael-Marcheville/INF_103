package tp06;

public class EBox extends MBox{
	
	private boolean isUsed;
	
	public EBox(int xpos, int ypos) {
		super(xpos, ypos);
		isUsed = false;
	}
	
	public boolean getIsUsed() { //get si le chemin passe par la case
		return isUsed;
	}

	
	public void setIsUsed(boolean isUsedValue) { //set si le chemin passe par la case
		isUsed = isUsedValue;
	}
}
