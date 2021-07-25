package coop;
import java.util.Scanner;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.lang.Math;

// contiene le direttive per il tipo Socio Finanziatore e la sua sottoclasse (Gestore)

public class Finanziatore extends Socio implements Serializable {
	
	// costruttore
	public Finanziatore(String nome) {
		super(nome);
		this.quota = UsaCooperativa.QUOTA_FINANZIATORE;
		this.saldato = false;
	}
	
	// consente di fare un versamento aggiuntivo dopo aver pagato la quota annuale
	public void versamentoAggiuntivo() {
		try {
			int importo; // conterrà l'importo da versare
			Scanner input = new Scanner(System.in);
			if (this.saldato) {
				System.out.println("Inserire l'importo da versare.\nATTENZIONE: in caso di importi negativi, sarà comunque considerato il valore positivo!");
				
				importo = Math.abs(input.nextInt());
				// aggiorna il capitale col valore assoluto dell'input (per evitare che si inseriscano valori negativi
				UsaCooperativa.capitale += importo;
				UsaCooperativa.aggiornaStorico(this.getNome(), importo, true);
				System.out.println("Il finanziatore " + getNome() + " ha fatto una donazione di " + importo + " euro.\nIl capitale della cooperativa è pari a " + UsaCooperativa.capitale + " euro.");
			}
			else {
				System.out.println("Impossibile effettuare il versamente:");
				System.out.println("Il finanziatore " + getNome() + " non ha ancora pagato la quota annuale.");
			}
		} catch (InputMismatchException e) {System.out.println("Errore di input!"); UsaCooperativa.termina();}
	}

}