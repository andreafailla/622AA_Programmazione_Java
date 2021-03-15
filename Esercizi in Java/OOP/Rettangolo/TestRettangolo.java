
public class TestRettangolo {

	public static void main(String[] args) {
		
		Rettangolo r1 = new Rettangolo(2, 4);
		Rettangolo r2 = new Rettangolo(1, 3);
		Rettangolo r3 = new Rettangolo(5, 7);

		System.out.println(r1.getArea() + r2.getArea() + r3.getArea());
		System.out.println(r1.getPerimetro() + r2.getPerimetro() + r3.getPerimetro());
		
		r1.ridimensiona(2, 2);
		
		System.out.println(r1.getArea() + r2.getArea() + r3.getArea());
		System.out.println(r1.getPerimetro() + r2.getPerimetro() + r3.getPerimetro());

	}
}