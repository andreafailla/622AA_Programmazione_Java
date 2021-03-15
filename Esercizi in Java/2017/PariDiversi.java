
public class PariDiversi {

	public static void main(String[] args) {

		int[] numeri = {8, 12, 11, 5, 4, 9, -1, 5, -8, 6};
		
		boolean trovato = false;

		for (int i=0; i<9; i++) {
			for (int j=i+1; j<10; j++) {
				if (numeri[i]%2==0 && numeri[i]==numeri[j])
					trovato = true;
			}
		}

		/* SOLUZIONE ALTERNATIVA (interrompe i cicli)
		int i=0;
		while (i<9 && !trovato) {
			int j=i+1;
			while (j<10 && !trovato) {
				if (numeri[i]%2==0 && numeri[i]==numeri[j])
					trovato = true;
				j++;
			}
			i++;
		}
		*/	  
		
		if (!trovato) System.out.println("I pari sono tutti diversi");
	}

}
