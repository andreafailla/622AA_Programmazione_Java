import java.util.Scanner;

public class TestLampadina {

	public static void main(String[] args) {
		
		int maxclick;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Scegliere il numero massimo (intero) di click");
		maxclick = input.nextInt();
		
		Lampadina l1 = new Lampadina(maxclick);
		
		String risposta;
		boolean stop = false;
		while (!stop) {
			System.out.println("[S]tato");
			System.out.println("[C]lick");
			System.out.println("[T]ermina");
			risposta = input.next();
			
			if (risposta.equals("S")) {
				System.out.println("La lampadina è " + l1.getStato());
			}
			else if (risposta.equals("C")) {
				l1.click();
				System.out.println("Click!");
			}
			else if (risposta.equals("T")) {
				stop = true;
				System.out.println("Terminato!");
			}
			else {
				System.out.println("Uso: inserire \"S\", \"C\" o \"T\"");
			}
			System.out.println();
		}
		input.close();
	}

}
