import java.util.Scanner;

public class Asporta {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String s = input.nextLine();
		int n = input.nextInt();
		int m = input.nextInt();
		
		if (0<=n && n<m && m<s.length()) {
			String risultato = s.substring(0, n) + s.substring(m, s.length());
			System.out.println(risultato);
		}
		else
			System.out.println("ERRORE!!!");

	}

}
