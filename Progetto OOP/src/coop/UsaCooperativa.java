package coop;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.StringIndexOutOfBoundsException;
import java.util.Scanner;

// contiene il main e i metodi lanciabili dal menù

public class UsaCooperativa {

	public static final int QUOTA_ORDINARIO = 500; // quota annuale socio ordinario
	public static final int QUOTA_FINANZIATORE = 1000; // idem per finanziatore
	public static final int QUOTA_GESTORE = 2000; // idem per gestore

	public static int anno = 2021; // anno corrente
	public static int capitale = 50000; // capitale della cooperativa

	public static ArrayList<Socio> soci = new ArrayList<Socio>(); // lista dei soci
	public static ArrayList<String> storico = new ArrayList<String>(); // contiene lo storico delle operazioni

	public static boolean flag; // servirà più avanti per gestire dei controlli
	public static boolean primoAvvio = true; // serve per visualizzare un menù emendato al primo avvio

	public static void main(String[] args) {

		try {

			// oggetto Scanner per input dell'utente
			Scanner input = new Scanner(System.in);

			// al primo avvio viene lanciato un menù ridotto
			while (primoAvvio) {
				System.out.println("Benvenuto!");
				System.out.println("[1] Aggiungi socio");
				System.out.println("[0] Salva/Carica");
				System.out.println("[X] Termina\n\n");

				char scelta = input.nextLine().charAt(0); // memorizza la scelta dell'utente

				switch (scelta) {

				// Aggiunge un nuovo socio
				case '1':
					primoAvvio = false;
					nuovoSocio();	
					break;
				// salva o carica da file
				case '0':
					primoAvvio = false;
					salvaCarica();
					break;
				// termina il programma, chiedendo prima se si vuole salvare
				case 'X':
					termina();
				}
			}
			
			// dopo il primo avvio, viene lanciato il menù completo
			while (true) {
				// interfaccia testuale
				System.out.println("\n\n\nCosa vuoi fare?\n***");
				System.out.println("[1] Aggiungi socio");
				System.out.println("[2] Rimuovi socio");
				System.out.println("[3] Visualizza elenco soci");
				System.out.println("[4] Visualizza elenco debitori");
				System.out.println("[5] Paga quota");
				System.out.println("[6] Effettua versamento aggiuntivo");
				System.out.println("[7] Effettua spesa");
				System.out.println("[8] Cambia Anno");
				System.out.println("[9] Visualizza storico movimenti");
				System.out.println("[0] Salva/Carica");
				System.out.println("[X] Termina\n\n");

				char scelta = input.nextLine().charAt(0); // memorizza la scelta dell'utente

				switch (scelta) {
				// crea nuovo socio
				case '1':
					nuovoSocio();	
					break;
				// rimuove un socio
				case '2':
					rimuoviSocio();
					break;
				// cicla l'ArrayList e stampa elenco soci & tipo socio
				case '3':
					elencoSoci();
					break;
				// stampa elenco debitori & debito totale
				case '4':
					elencoDebitori();
					break;
				// permette di saldare il debito di un socio
				case '5':
					saldaDebito();
					break;
				// effettua versamento aggiuntivo
				case '6':
					effettuaVersamento();
					break;
				// effettua spesa per conto della cooperativa
				case '7':
					effettuaSpesa();
					break;
				// aumenta anno corrente di 1, setta boolean saldato a false per tutti i soci.
				case '8':
					passaggioDiAnno();
					break;
				// stampa lo storico dei movimenti
				case '9':
					stampaMovimenti();
					break;
				// salva o carica da file
				case '0':
					salvaCarica();
					break;
				// termina il programma, chiedendo prima se si vuole salvare
				case 'X':
					termina();
					break;
				// se l'input non è catturato da un case, stampa un messaggio d'errore	
				default: 
					System.out.println("Scelta non valida...");
					System.out.println("*");
				}

			}

		}	
		catch (InputMismatchException e){System.out.println("Errore di input!"); termina();}
		
		catch (StringIndexOutOfBoundsException e){System.out.println("Si è verificato un errore!"); termina();}

	}

	// consente di aggiungere un nuovo socio
	private static void nuovoSocio() {
		String nome = null; // memorizza il nome che l'utente intende cercare quando si scorre l'ArrayList
							// null per poterlo passare al metodo assegnaRuolo senza problemi
		Scanner input = new Scanner(System.in);

		System.out.println("Inserire nome utente");
		// se l'array è già popolato...
		if (!soci.isEmpty()) {
			flag = false;
			// questo ciclo evita che si inserisca un nome già assegnato a un altro utente
			while (!flag) {
				nome = input.nextLine();
				for (Socio socio : soci) {
					// se il nome esiste, esce dal for e ricomincia un nuovo ciclo nel while
					if (nome.equals(socio.getNome())) {
						System.out.println("Il nome esiste già. Inserirne un altro.");
						break;
					}
					// se ha ciclato l'intero arraylist e non ha trovato nulla, esce dal for e 
					// setta flag a true per uscire dal while
					if (soci.indexOf(socio) == soci.size()-1 && !nome.equals(socio.getNome())) {
						flag = true;
						break;
					}
				}
				
			}
		// se l'array è vuoto, procede all'inserimento del primo socio	
		} else {
			nome = input.nextLine();
		}
		
		assegnaRuolo(nome);
	
	}
	
	// definisce il tipo di socio
	private static void assegnaRuolo(String nome) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Selezionare tipo di socio:");
		System.out.println("[1] Socio ordinario");
		System.out.println("[2] Socio finanziatore");
		System.out.println("[3] Socio gestore");

		int scelta = input.nextLine().charAt(0);
		// L'utente definisce il tipo di socio
		switch (scelta) {
		case '1':
			Socio s = new Socio(nome);
			soci.add(s);
			System.out.println(s.getNome() + " registrato come socio ordinario. Premi un pulsante per continuare.");
			break;

		case '2':
			Finanziatore s1 = new Finanziatore(nome);
			soci.add(s1);
			System.out.println(s1.getNome() + " registrato come socio finanziatore.");
			break;

		case '3': // nel caso di un gestore, si imposta una password
			flag = false;
			while (!flag) {
				System.out.println("Inserire password");
				String pw = input.nextLine();
				System.out.println("La password inserita è " + pw + "\nVa bene?[S/N]");
				char conferma = input.nextLine().toUpperCase().charAt(0);
				while (true) {
					if (conferma == 'S') {
						flag = true;
						Gestore s2 = new Gestore(nome, pw);
						soci.add(s2);
						System.out.println(s2.getNome() + " registrato come socio gestore.");
						break;
					} else if (conferma == 'N') {
						break;
					} else {
						System.out.println("Scelta errata");
						break;
					}
				}
				if (flag) {
					break;
				}
			}
			break; 
		default:
			System.out.println("Scelta non valida...");
		}
	}
	
	// consente di rimuovere un socio
	private static void rimuoviSocio() {
		String nome; // memorizza il nome che l'utente intende cercare quando si scorre l'ArrayList
		Scanner input = new Scanner(System.in);

		System.out.println("Inserire il nome del socio da rimuovere");
		nome = input.nextLine();
		
		int i = 0; // variabile che memorizza l'indice del socio da eliminare
		flag = false; // true se trova una corrispondenza (torna false ogni volta che entriamo nel case)
		for (Socio socio : soci) {
			// se il nome inserito corrisponde al nome di un utente...
			if (nome.equals(socio.getNome())) {
				flag = true;
				i = soci.indexOf(socio);
			}
		}
		//... lo rimuove
		if (flag) {
			soci.remove(i);
			System.out.println("Socio rimosso!");
		} else {
			System.out.println("Utente non trovato!");
		}
		System.out.println("*");

	}

	// stampa l'elenco dei soci 
	private static void elencoSoci() {
		// cicla l'arraylist e ne stampa gli elementi
		System.out.println("Elenco soci:");
		for (Socio socio : soci) {
			if (socio instanceof Gestore) {
				System.out.println(socio.getNome() + " – Gestore;");
			} else if (socio instanceof Finanziatore) {
				System.out.println(socio.getNome() + " – Finanziatore;");
			} else {
				System.out.println(socio.getNome() + " – Socio Ordinario;");
			}
		}
		System.out.println("*");		
	}

	// stampa l'elenco dei soci che ancora non hanno pagato la quota annuale
	private static void elencoDebitori() {
		int daRiscuotere = 0; // memorizza la quantità di denaro da riscuotere in quote associative per l'a.c.
		System.out.println("Elenco soci debitori:");
		flag = false; //boolean di controllo per vedere che non ci siano debitori
		
		for (Socio socio : soci) {
			if (!socio.getSaldato()) { // se il socio non ha saldato, controlla il tipo e stampa, contando il debito
				flag = true;
				if (socio instanceof Gestore) {
					System.out.println(socio.getNome() + " – Gestore;");
					daRiscuotere += QUOTA_GESTORE;
				} else if (socio instanceof Finanziatore) {
					System.out.println(socio.getNome() + " – Finanziatore;");
					daRiscuotere += QUOTA_FINANZIATORE;
				} else {
					System.out.println(socio.getNome() + " – Socio Ordinario;");
					daRiscuotere += QUOTA_ORDINARIO;
				}

			} 
			
		}
			//stampa se non ci sono debitori
		if (!flag) {
			System.out.println("Non ci sono soci debitori");
			flag = false;
		}
		System.out.println("La cooperativa deve ancora riscuotere " + daRiscuotere + " euro per l'anno " + anno); 
		System.out.println("*");		
	}

	// consente di pagare la quota annuale
	private static void saldaDebito() {
		String nome; // memorizza il nome che l'utente intende cercare quando si scorre l'ArrayList
		Scanner input = new Scanner(System.in);

		System.out.println("Inserire il nome del socio che intende pagare la quota associativa");
		nome = input.nextLine();
		// cerca il nome, se lo trova invoca il suo metodo paga()
		flag = false; // true quando trova una corrispondenza
		
		// cicla l'arraylist cercando una corrispondenza
		for (Socio socio : soci) {
			if (nome.equals(socio.getNome())) {
				flag = true;
				// controlla che non abbia già pagato
				if (socio.getSaldato()) {
					System.out.println(socio.getNome() + " ha già pagato!");
				} else {
					socio.paga();
				}
			} 
			// se non trova nulla, avvisa l'utente e torna al menù
		} if (!flag) {
			System.out.println("Nessun socio con questo nome.");
		}
		System.out.println("*");		
	}

	// consente di effettuare versamenti aggiuntivi (solo per i Soci Finanziatori e Gestori)
	private static void effettuaVersamento() {
		String nome; // memorizza il nome che l'utente intende cercare quando si scorre l'ArrayList
		Scanner input = new Scanner(System.in);

		System.out.println("Inserire il nome del socio che intende effettuare un versamento aggiuntivo:");
		nome = input.nextLine();
		// cerca nome, se lo trova ed è di un tipo valido chiama il metodo
		flag = false; // true se trova una corrispondenza
		for (Socio socio : soci) {
			if (nome.equals(socio.getNome())) {
				flag = true;
				if (socio instanceof Gestore) {
					((Gestore) socio).versamentoAggiuntivo();
				} else if (socio instanceof Finanziatore) {
					((Finanziatore) socio).versamentoAggiuntivo();
				} else { // se è un socio ordinario, non è autorizzato a versare
					System.out.println("L'utente non è autorizzato a fare versamenti aggiuntivi.");
				} 
			} 
		} if (!flag) {
			System.out.println("Nessun socio con questo nome.");
		}
		System.out.println("*");		
	}

	// consente di effettuare le spese (solo per i Soci Gestori)
	private static void effettuaSpesa() {
		String nome; // memorizza il nome che l'utente intende cercare quando si scorre l'ArrayList
		Scanner input = new Scanner(System.in);

		System.out.println("Quale gestore desidera spendere?");
		nome = input.nextLine();
		flag = false; // true se trova una corrispondenza
		// se trova il socio ed è un gestore, invoca il metodo spendi()
		for (Socio socio : soci) {
			if (nome.equals(socio.getNome())) {
				flag = true;
				if (socio instanceof Gestore) {
					((Gestore) socio).spendi();
				} else {
					System.out.println("Il socio non dispone dei privilegi necessari!");
				}
			} 
		}
		// se non trova una corrispondenza, avvisa l'utente
		if (!flag) {
			System.out.println("Nessun socio con questo nome.");
		}
		System.out.println("*");		
	}

	// effettua controlli necessari per il passaggio di anno
	private static void passaggioDiAnno() {
		Scanner input = new Scanner(System.in);
		
		boolean nonPagato = false; // serve a controllare che tutti i soci abbiano saldato
		// se almeno un socio non ha saldato, nonPagato è settato a true
		for (Socio socio : soci) {
			if (!socio.getSaldato()) {
				nonPagato = true;
			}
		}
		
		// se almeno un socio non ha pagato, si chiede all'utente di confermare il cambio di anno
		if (nonPagato) {
			System.out.println("Almeno un socio deve ancora saldare. Sicuro di voler effettuare il passaggio di anno? [S] o [N].");
			char c = input.nextLine().toUpperCase().charAt(0);
			while (c != 'S' && c != 'N') {
				System.out.println("Errore. Inserire [S] o [N].");
				c = input.nextLine().toUpperCase().charAt(0);
			}
			// se conferma, chiama il metodo resettaSaldato()
			if (c == 'S') {
				anno++;resettaSaldato();
				System.out.println("Aggiornamento anno corrente.\nIl nuovo anno è " + anno + ".");
			} else if (c == 'N') {
				return;
			}

		} else {
			// se tutti hanno pagato, chiama il metodo resettaSaldato()
			anno++;resettaSaldato();
			System.out.println("Aggiornamento anno corrente.\nIl nuovo anno è " + anno + ".");
		}

		System.out.println("*");		
	}
	
	// setta le variabili saldato a false per tutti gli utenti
	private static void resettaSaldato() {
		for (Socio socio : soci) {
			socio.cambiaAnno();
		}
		System.out.println("Da questo momento, tutti i soci devono pagare nuovamente la quota annuale");
	}

	// stampa lo storico dei movimenti 
	private static void stampaMovimenti() {
		// se lo storico è vuoto, avvisa l'utente
		if (soci.isEmpty()) {
			System.out.println("Lo storico dei movimenti è vuoto!");
		// altrimenti, ne stampa le voci
		} else {
		System.out.println("Segue lo storico dei movimenti:");
			for (String voce : storico) {
				System.out.println(voce);
			}
		}
	}
	
	// gestisce la scelta dell'utente circa salvataggio & caricamento
	private static void salvaCarica() {

		Scanner input = new Scanner(System.in);

		System.out.println("[S]alva o [C]arica");
		char c = input.nextLine().toUpperCase().charAt(0);
		while (c != 'S' && c != 'C') {
			System.out.println("Errore. [S]alva o [C]arica");
			c = input.nextLine().toUpperCase().charAt(0);
		}
		if (c == 'S') {
			salva();
		} else {
			carica();
		}
		System.out.println("*");		
	}

	// salva lo stato del programma & lo storico delle transazioni
	private static void salva() {
		try{
			FileOutputStream out = new FileOutputStream("savestate.ser"); 
			ObjectOutputStream s = new ObjectOutputStream(out);
			s.writeObject(soci); // salva lista soci
			s.writeObject(anno); // salva anno corrente
			s.writeObject(capitale); // salva capitale accumulato
			out.close();
			s.close();

			FileOutputStream out1 = new FileOutputStream("storico.ser"); 
			ObjectOutputStream s1 = new ObjectOutputStream(out1);
			s1.writeObject(storico);
			System.out.println("Salvataggio riuscito!");
			out1.close();
			s1.close();
		} 
		catch(IOException e){ 
			System.out.println("Salvataggio non riuscito, il programma termina qui.\n" + e);
		} 
	}

	// carica da file 
	private static void carica() {

		try {
			FileInputStream in = new FileInputStream("savestate.ser");
			ObjectInputStream s = new ObjectInputStream(in);
			soci = (ArrayList<Socio>) s.readObject();
			anno = (Integer) s.readObject();
			capitale = (Integer) s.readObject();
			in.close();
			s.close();


			FileInputStream in1 = new FileInputStream("storico.ser");
			ObjectInputStream s1 = new ObjectInputStream(in1);
			storico = (ArrayList<String>) s1.readObject();
			System.out.println("Caricamento riuscito.");
			in1.close();
			s1.close();

		}
		catch (FileNotFoundException e) {System.out.println("File non trovato! Il programma termina qui.\n" + e);}
		catch (ClassNotFoundException e) {e.printStackTrace();} 
		catch (IOException e) {e.printStackTrace();}

	}
	
	// termina il programma, chiedendo prima se si vuole salvarne lo stato
	static void termina() {
		Scanner input = new Scanner(System.in);
		flag = false; // true se l'utente sceglie di salvare

		while (!flag) {
			char conferma; 
			while (true) {
				System.out.println("Il programma sta per terminare. Vuoi salvare? [S/N]");
				conferma = input.nextLine().toUpperCase().charAt(0);
				if (conferma == 'S') {
					flag = true;
					salva();
					System.out.println("In chiusura...");
					System.exit(0); // termina il programma
				} else if (conferma == 'N') {
					System.out.println("In chiusura...");
					System.exit(0); // termina il programma
				} else {
					System.out.println("Scelta errata");
					break;
				}
			}
		}
	}

	// aggiorna lo storico delle transazioni
	// questo metodo è invocato dai metodi interni agli oggetti
	public static void aggiornaStorico(String socio, int quota, boolean versamento) {
		/* prende in input il nome del socio, la quota versata/spesa e un booleano
		boolean versamento è true se l'operazione è un versamento (pagamento quota o versamento aggiuntivo)
		false se è una spesa per conto della cooperativa */

		String nuovo;


		if (versamento) {
			nuovo = "Anno: " + anno + ". " + socio + " ha versato " + Integer.toString(quota) + " euro alla cooperativa.";
		} else {
			nuovo = "Anno: " + anno + ". " + socio + " ha speso " + Integer.toString(quota) + " euro per conto della cooperativa.";
		}
		
		storico.add(nuovo);
		
	}
}
