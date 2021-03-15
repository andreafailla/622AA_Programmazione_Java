import java.util.Scanner;

public class Centesimi {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		System.out.println(divisione(n));
	}
	
	private static double divisione(int numero) {
		return ((double) numero)/100;
	}
}
