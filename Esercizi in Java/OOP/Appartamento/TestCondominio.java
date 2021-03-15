import java.util.Scanner;

public class TestCondominio {

	public static void main(String[] args) {
		
		int [] quack = {50, 22, 37};
		Condominio papero = new Condominio (4, 3, quack);
		
		boolean stop = false;
		Scanner input = new Scanner(System.in);
		
		while(!stop) {
			System.out.println("Buongiorno a te! Cosa vuoi fare?");
			System.out.println("[S]pese condominiali.");
			System.out.println("[V]isualizza condominio");
			System.out.println("[M]odifica proprietario");
			System.out.println("[K]araoke");
			System.out.println("[L]essie");
			
			switch(input.nextLine().toUpperCase().charAt(0)) {
				case 'S': 
					papero.speseCondominiali();
					break;
				case 'V':
					papero.Visualizza();
					break;
				case 'K':
					System.out.println("Canta anche tu!");
					System.out.println("");
					System.out.println("Vorrei darti la mia forza per vederti parlare");
					System.out.println("Non di ciò che ti succede ma parlare di te");
					System.out.println("Anche un granello di sabbia che si è perso nel mare può tornare roccia come puoi farlo te");
					System.out.println("");
					System.out.println("Avete ascoltato: Parlami, di T. Fazioli - L. Zammarano, (c) 2021 Ed. Wfk Empire - Roma");
					break;
				case 'M':
					System.out.println("A che piano si trova l'appartamento di cui vuoi cambiare il proprietario?");
					int p = input.nextInt();
					System.out.println("Che numero è?");
					int ap = input.nextInt();
					System.out.println("Inserisci nuovo nome:");
					input.nextLine();
					String n = input.nextLine();
					papero.theSetter(p,  ap, n);
					break;
				case 'L':
					stop = false;
				}
			
			
			
			}
			

			
			
		input.close();
		}

}