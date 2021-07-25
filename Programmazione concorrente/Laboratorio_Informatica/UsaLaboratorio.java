// Andrea Failla, 2021
// Laboratorio di Programmazione in Java

package Laboratorio_Informatica;
import java.lang.Math;

public class UsaLaboratorio {
	
	// definire numero di utenti
public final static int UTENTI = 10;

	public static void main(String[] args){
		
		// crea un oggetto Laboratorio
		Laboratorio lab = new Laboratorio();
	
		// cicla e crea utenti
		for (int i = 0; i < UTENTI; i++) {
			Utente u = new Utente("Utente"+i, assegnaRuolo(), lab); 
			// lo start si trova nel costruttore
		}
	}
	
	// assegna casualmente un ruolo all'utente
	public static String assegnaRuolo() {
		// genera un intero casuale tra 0 e 2
		int num = (int) (Math.random() * 3);
		// restituisce il ruolo
		switch (num) {
		case 0:
			return "Professore";
		case 1:
			return "Tesista";
		case 2:
			return "Studente";
		}
		return null;

	}
}
