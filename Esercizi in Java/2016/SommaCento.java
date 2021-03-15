import java.util.Scanner;

public class SommaCento {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		int somma = 0;
		int cont = 0;
		
		do {
			int n = input.nextInt();
			somma+=n;
			cont++;
		} while (somma!=100 && cont<10);
		
		if (somma==100) System.out.println("Ottenuto 100");
		else System.out.println("Tentativi esauriti");
	}
}
