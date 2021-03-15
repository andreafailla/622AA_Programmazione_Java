import java.util.Scanner;

public class StampaDispari {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Inserisci una stringa");
		
		String s = input.nextLine();
		
		for (int i=1; i<s.length(); i+=2)
			System.out.print(s.charAt(i));
	}

}
