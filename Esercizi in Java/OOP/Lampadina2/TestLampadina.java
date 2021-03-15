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
			System.out.println("[P]ower");
			risposta = input.next();
			
			if (risposta.equals("S")) {
				System.out.println("La lampadina è " + l1.getStato());
			}
			
			else if (risposta.equals("C")) {
				System.out.println("Click!");
				l1.click();

			}
			
			else if (risposta.equals("P")) {
				l1.setCorrente();
				if (l1.getCorrente()) {
					System.out.println("La corrente è stata attivata!");
				} else {
					System.out.println("La corrente è stata disattivata!");
				}
			}
			
			else if (risposta.equals("T")) {
				stop = true;
				System.out.println("Terminato!");
			}
			
			else {
				System.out.println("Uso: inserire \"S\", \"P\", \"C\" o \"T\"");
			}
			System.out.println();
		}
		input.close();
	}

}
