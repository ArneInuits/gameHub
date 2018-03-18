
public class Snake extends Game{
	private Settings speed;
	
	public Snake() {
		speed = new Speed();
	}
	
	public void setS(int setS) {
		speed.setValue(setS);
	}
}
