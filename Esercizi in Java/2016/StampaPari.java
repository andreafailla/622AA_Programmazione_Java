import java.util.Scanner;

public class StampaPari {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Inserisci una stringa");
		
		String s = input.nextLine();
		
		for (int i=0; i<s.length(); i+=2)
			System.out.print(s.charAt(i));
	}

}
