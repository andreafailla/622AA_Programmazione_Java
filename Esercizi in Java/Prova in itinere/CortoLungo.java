import java.util.Scanner;

public class CortoLungo {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci due stringhe");
		String str = input.nextLine();
		String str2 = input.nextLine();
		System.out.println(confronta(str, str2));
		input.close();

	}

	private static String confronta(String str, String str2) {
		if (str.length() < str2.length()) {
			return (str + " più corto di " + str2);
		} else if (str.length() > str2.length()) {
			return (str + " più lungo di " + str2);
		} else {
			return (str + " lungo uguale a " + str2);
		}
	}

}
