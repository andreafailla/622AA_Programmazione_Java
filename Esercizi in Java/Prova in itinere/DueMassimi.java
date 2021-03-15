
public class DueMassimi {

	public static void main(String[] args) {
		
		int[] arr = { 3, 2, 5, 11, 4, 9, 1, 8, 7, 10 };

		int massimo1 = arr[0];
		int massimo2 = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > massimo1) {
				massimo1 = arr[i];
			}
		}
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] > massimo2 && arr[j] != massimo1) {
				massimo2 = arr[j];
			}
		}
		int prodotto = massimo1 * massimo2;

		System.out.println(prodotto);
	}

}
