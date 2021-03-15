
public class TestAppartamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Appartamento a1 = new Appartamento("Annachiara Crea", 100, 5, 2);
		Appartamento a2 = new Appartamento("Antonio D'Antoni", 50, 5, 3);
		Appartamento a3 = new Appartamento("Gelsomina Di Gelso", 20, 0, 1);
		
		System.out.println("Primo appartamento: ");
		a1.visualizza();
		System.out.println();
		
		System.out.println("Secondo appartamento: ");
		a2.visualizza();
		System.out.println();
		
		System.out.println("Terzo appartamento: ");
		a3.visualizza();
		System.out.println();
		
		a2.setProprietario("Franco Dei Franchi");
		a3.setInquilini(0);
		
		System.out.println("Primo appartamento: ");
		a1.visualizza();
		System.out.println();
		
		System.out.println("Secondo appartamento: ");
		a2.visualizza();
		System.out.println();
		
		System.out.println("Terzo appartamento: ");
		a3.visualizza();
		System.out.println();

		
	}

}
