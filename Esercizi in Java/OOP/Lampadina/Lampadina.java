
public class Lampadina {
	
	private String stato;
	private int contaClick;
	private int maxClick;
	
	
	public Lampadina(int c) {
		maxClick = c;
		contaClick = 0;
		stato = "Spenta";
	}
	
	public String getStato() {
		return stato;
	}
	
	public void click() {
		contaClick++;
		if (contaClick < maxClick) {
			switch (stato) {
			case "Spenta":
				stato = "Accesa";
				break;
			case "Accesa":
				stato = "Spenta";
				break;
			}
		} 
		else if (contaClick == maxClick) {
			stato = "Rotta!!!";
		}
	}
}
