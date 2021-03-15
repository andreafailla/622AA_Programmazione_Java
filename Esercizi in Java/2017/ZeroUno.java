import java.util.Scanner;

public class ZeroUno {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int n;
		int conta0 = 0;
		int conta1 = 0;
		
		do {
			n = input.nextInt();
			if (n==0) conta0++;
			else if (n==1) conta1++;
		} while (n>=0);
		
		if (conta0>conta1)
			System.out.println("Vince 0");
		else if (conta1>conta0)
			System.out.println("Vince 1");
		else
			System.out.println("Pareggio");
	
	}

}
