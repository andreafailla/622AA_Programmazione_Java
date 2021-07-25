package coop;
import java.util.Scanner;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.lang.Math;


// contiene le direttive per il tipo Socio Gestore

public class Gestore extends Finanziatore implements Serializable {

	private String password; // password richiesta per effettuare spese a carico della cooperativa

	// costruttore
	public Gestore(String nome, String password) {
		super(nome);
		this.quota = UsaCooperativa.QUOTA_GESTORE;
		this.saldato = false;
		this.password = password;
	}

	// consente di far spese per conto della cooperativa, previa verifica della password
	public void spendi() {

		try {
			Scanner input = new Scanner(System.in);

			// chiama il metodo privato login e chiede un intero in input
			// Se e il login va a buon fine...

			if (login()) {
				System.out.println("Inserire importo da spendere.\nATTENZIONE: in caso di importi negativi, sarà comunque considerato il valore positivo!");

				int importo = Math.abs(input.nextInt());

				// se l'importo è disponibile, lo spende, altrimenti stampa un messaggio d'errore
				if (importo <= UsaCooperativa.capitale) {
					UsaCooperativa.capitale -= importo;
					System.out.println("Il gestore " + getNome() + " ha speso " + importo + " euro della cooperativa.");
					System.out.println("Il capitale ammonta a " + UsaCooperativa.capitale + " euro.");
					UsaCooperativa.aggiornaStorico(this.getNome(), importo, false);
				}
				else {
					System.out.println("Impossibile effettuare il pagamento:\nCapitale insufficente.");
				}
			}
		} catch (InputMismatchException e) {System.out.println("Errore di input!");  UsaCooperativa.termina();}

	}

	// effettua login (verifica password)
	private boolean login() {
		try {
			int tentativi = 3; // numero massimo di errori al login
			Scanner input = new Scanner(System.in);

			// cicla fino a quando ci sono tentativi disponibili
			while (tentativi > 0) {
				System.out.println("Inserire la password:");
				String pw = input.nextLine();
				// se la password corrisponde, chiude lo stream e restituisce true
				if (pw.equals(this.password)) {
					System.out.println("Password accettata");
					return true;
					// altrimenti diminuisce i tentativi disponibili
				} else {
					tentativi--;
					System.out.println("Password errata! " + tentativi + " rimanenti.");
				}
			} 
			// esauriti i tentativi, esce dal ciclo e restituisce false
			System.out.println("Tentativi esauriti. Impossibile effettuare il login");
			return false;
		}  catch (InputMismatchException e) {System.out.println("Errore di input!");  UsaCooperativa.termina();}
		return false; // altrimenti Eclipse si arrabbia >:-(
	}

}