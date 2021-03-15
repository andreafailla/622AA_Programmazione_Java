import java.util.Scanner;

public class Ripeti {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String s = input.nextLine();
		int n = input.nextInt();
		
		if (n>=0)
			System.out.println(concatena(s,n));
	}

	private static String concatena(String str, int num) {
		String ris = "";
		for (int i=0; i<num; i++)
			ris += str;
	    return ris;
	}
}
