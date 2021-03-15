
public class Condominio {

	private int piano;
	private int appartamenti;
	private int [] superfici = new int[appartamenti];

	private Appartamento[] listaAppartamentiTot;

	public Condominio(int piano, int appartamenti, int[] superfici) {
		this.piano = piano;
		this.appartamenti = appartamenti;
		this.superfici = superfici;

		int totAp = piano * appartamenti;
		listaAppartamentiTot = new Appartamento[totAp];

		int c = 0;
		for (int j = 0; j < piano; j++) {
			for (int i = 0; i < superfici.length; i++) {
				listaAppartamentiTot[c] = new Appartamento("Nessuno", superfici[i], j, 0);
				c++;
			}

		}

	}

	public void theSetter(int Piano, int App, String nome) {

		int i = Piano * appartamenti + (App - 1);
		listaAppartamentiTot[i].setProprietario(nome);

	}

	public void Visualizza() {
		for (int k = 0; k < listaAppartamentiTot.length; k++) {
			listaAppartamentiTot[k].visualizza();
			System.out.println("");
		}
	}

	// calcoliamo le spese di ogni singolo condominio calcolando come: pi greco *
	// superficie * numero inquilini/3
	// perché tutti sanno che pi greco è la costante delle spese condominiali
	// infatti quando c'è da pagare fra inquilini si ARROTONDA sempre XD LOL ROTFL
	// LMAO!!! ASDONE
	// detto questo, stampiamo poi alla fine anche il totale delle spese
	// condominiali
	// motivo per cui c'è quel c contatore

	public void speseCondominiali() {
		double contatasse = 0.0;
		for (int k = 0; k < listaAppartamentiTot.length; k++) {
			Appartamento current = listaAppartamentiTot[k];
			int sup = current.getSuperficie();
			int inq = current.getInquilini();
			double tasseApp = (3.14 * sup * inq);
			
			for (int j = 0; j < piano; j++) {
				for (int i = 0; i < superfici.length; i++) {
					System.out.println("L'appartamento " + i + " al piano" + j + " ha spese che ammontano a: " + tasseApp + "€");
				}
				contatasse += tasseApp;
			}
			System.out.println("In totale il condominio ha da saldare: " + contatasse + "€");

		}

	}
}
