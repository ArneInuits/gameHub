
public class Speed extends Settings { 
	private int val;
	public Speed(){
		val = 5;
	}
	
	public void setSpeed(int i) {
		super.setValue(i);
		if (i<11 && i>0) {
			val = i;
		}
	}
}
