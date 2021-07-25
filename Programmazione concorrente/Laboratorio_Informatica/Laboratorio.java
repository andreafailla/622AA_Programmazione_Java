// Andrea Failla, 2021
// Laboratorio di Programmazione in Java

package Laboratorio_Informatica;

public class Laboratorio {

	// numero di posti liberi
	public int postiLiberi;
	// true quando il pc col software per i tesisti e' occupato, false altrimenti
	public boolean PCtesi;

	// costruttore
	public Laboratorio() {
		PCtesi = false;
		postiLiberi = 20;
	}

	
	
	// metodo per entrare
	public synchronized void entra() {

		Utente u = (Utente) Thread.currentThread();

		// se e' un professore...
		if (u.ruolo.equals("Professore")) {
			// verifica che tutti i posti sono liberi, altrimenti va in wait
			while (postiLiberi != 20) {
				System.out.println("Il prof. " + u.getName() + " non puo' entrare");
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// quando esce dal ciclo occupa tutti i posti
			postiLiberi = 0;
			PCtesi = true;
			u.inLab = true;
			System.out.println("Il laboratorio e' occupato dal prof." + u.getName());
			System.out.println("Posti liberi: " + postiLiberi);

			// questo wait permette di entrare in piu' di uno alla volta
			try {
				wait(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			
			
			// se e' uno studente...
		} else if (u.ruolo.equals("Studente")) {
			// verifica che ci sia almeno un posto libero, altrimenti va in wait
			while (postiLiberi == 0) {
				System.out.println("Lo studente " + u.getName() + " non puo' entrare");
				try {
					wait();
					System.out.println("Lo studente " + u.getName() + " riprova");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// quando esce dal ciclo occupa un posto
			postiLiberi--;
			u.inLab = true;
			System.out.println("Lo studente " + u.getName() + " entra");
			System.out.println("Posti liberi: " + postiLiberi);

			// ai tesisti è fatta la cortesia di lasciare il loro posto libero fin quando possibile,
			// tuttavia, se uno studente non trova altro posto, lo occupa comunque
			if (postiLiberi == 1 && !PCtesi) {
				PCtesi = true;
				u.occupaPCtesi = true;
				System.out.println("PC dei tesisti occupato abusivamente!!!");
			}

			// questo wait permette di entrare in più di uno alla volta
			try {
				wait(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			
			
			// se e' un tesista...
		} else if (u.ruolo.equals("Tesista")) {

			// se il PCtesi e' occupato, non puo' entrare
			while (PCtesi) {
				System.out.println("Il tesista " + u.getName() + " non puo' entrare");
				try {
					wait();
					System.out.println("Il tesista " + u.getName() + " riprova");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// quando esce dal ciclo occupa il posto
			postiLiberi--;
			PCtesi = true;
			u.inLab = true;
			System.out.println("Il tesista " + u.getName() + " entra e occupa il PC dei tesisti");
			System.out.println("Posti liberi: " + postiLiberi);
		}
		// questo wait permette di entrare in più di uno alla volta
		try {
			wait(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// metodo per uscire
	public synchronized void esce() {

		Utente u = (Utente) Thread.currentThread();
		
		// se e' un professore, libera tutti i posti
		if (u.ruolo.equals("Professore")) {
			postiLiberi = 20;
			PCtesi = false;
			u.inLab = false;
			System.out.println("Il prof " + u.getName() + " se ne va.");
		}
		// se e' uno studente, libera un posto
		else if (u.ruolo.equals("Studente")) {
			postiLiberi++;
			u.inLab = false;
			System.out.println("Lo studente " + u.getName() + " se ne va.");
			// se occupava il pc dei tesisti, lo libera
			if (u.occupaPCtesi == true) {
				PCtesi = false;
				u.occupaPCtesi = false;
				System.out.println("PC dei tesisti libero!");
			}
		} 

		// se e' un tesista, libera il pc
		else if (u.ruolo.equals("Tesista")) {
			postiLiberi++;
			PCtesi = false;
			u.inLab = false;
			System.out.println("Il tesista " + u.getName() + " se ne va.");
		}

		// risveglia i thread
		notifyAll();

		// aspetta prima di finire l'esecuzione (e dunque ripartire col ciclo run)
		try {
			wait(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
