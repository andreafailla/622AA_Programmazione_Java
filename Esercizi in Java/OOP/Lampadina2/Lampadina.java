
public class Lampadina {
	
	private String stato;
	private int contaClick;
	private int maxClick;
	private static boolean corrente = false;
	
	
	public Lampadina(int c) {
		maxClick = c;
		contaClick = 0;
		stato = "Spenta";
	}
	
	public String getStato() {
		return stato;
	}
	
	public void click() {
		if (corrente) {
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
		} else {
			System.out.println("Non c'è corrente!!!");
		}
	}
		
	public void setCorrente() {
		if (corrente) {
			corrente = false;
		} else {
			corrente = true;
		}
	}
	
	public boolean getCorrente() {
		return corrente;
	}
}
