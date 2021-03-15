import java.util.Scanner;

public class SommaMille {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int somma = 0;
		int cont = 0;
		
		do {
			int n = input.nextInt();
			somma+=n;
			cont++;
		} while (somma!=1000 && cont<10);
		
		if (somma==1000) System.out.println("Ottenuto 1000");
		else System.out.println("Tentativi esauriti");
	}

}
