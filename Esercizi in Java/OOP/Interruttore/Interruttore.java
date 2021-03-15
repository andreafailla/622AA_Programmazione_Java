
public class Interruttore {
	
	private Lampadina lamp;
	
	
	public Interruttore(Lampadina lamp) {
		this.lamp = lamp;
	}
	
	public void click() {
		lamp.click();
	}
	
	 
}
