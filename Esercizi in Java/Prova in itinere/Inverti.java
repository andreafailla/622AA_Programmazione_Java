import java.util.Scanner;

public class Inverti {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci una stringa");
		String str = input.nextLine();
		boolean spazio = false;
		String primaparola;

		for (int i = 0; i < str.length() && !spazio; i++) {
			if (str.charAt(i) == ' ') {
				primaparola = str.substring(0, i); // spazio escluso

				str = str.substring(i + 1) + ' ' + primaparola;
				spazio = true;
			}
		}
		input.close();
		System.out.println(str);

	}
}
