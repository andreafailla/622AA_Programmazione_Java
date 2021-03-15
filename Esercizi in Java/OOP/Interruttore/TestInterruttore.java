import java.util.Scanner;

public class TestInterruttore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// crea una lampadina che si rompe dopo 5 click
		Lampadina l1 = new Lampadina(5);

		// crea un interruttore collegato a l1
		Interruttore s1 = new Interruttore(l1);

		// crea un secondo interruttore collegato a l1
		Interruttore s2 = new Interruttore(l1);

		Scanner input = new Scanner(System.in);

		String risposta;
		boolean stop = false;
		while (!stop) {
			System.out.println("[S]tato");
			System.out.println("[1]");
			System.out.println("[2]");
			System.out.println("[T]ermina");
			risposta = input.next();

			if (risposta.equals("1")) {
				s1.click();
				System.out.println("Click!");
				System.out.println("La lampadina è " + l1.getStato());
			} 
			else if (risposta.equals("2")) {
				s2.click();
				System.out.println("Click!");
				System.out.println("La lampadina è " + l1.getStato());
			} 
			else if (risposta.equals("T")) {
				stop = true;
				System.out.println("Terminato!");
			} else {
				System.out.println("Uso: inserire \"1\", \"2\" o \"T\"");
			}
			System.out.println();
		}
		input.close();

	}
}
