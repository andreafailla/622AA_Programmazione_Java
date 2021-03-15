
public class EsattamenteUnaCoppia {

	public static void main(String[] args) {
		
		int[] valori = { 7, 3, 9, -1, 34, 9, 1, 4, 10, 22};
		
		int cont=0;
		
		for (int i=0; i<valori.length-1; i++)
			for (int j=i+1; j<valori.length; j++)
				if (valori[i]==valori[j]) cont++;
		
		if (cont==1)
			System.out.println("Esattamente una coppia");

	}

}
