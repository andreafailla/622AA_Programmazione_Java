import java.util.Scanner;

public class MediaMobile {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci fino a cinque numeri frazionari");
		double somma = 0.0;
		int counter = 0;

		for (int i = 0; i < 5 && somma < 50.0; i++) {
			double val = input.nextDouble();
			somma += val;
			counter++;
		}

		System.out.println(somma / counter);
		input.close();
	}

}
