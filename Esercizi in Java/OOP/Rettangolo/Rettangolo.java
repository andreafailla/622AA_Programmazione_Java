
public class Rettangolo {
	private double area;
	private double perimetro;

	public Rettangolo(double b, double h) {
		area = b * h;
		perimetro = (b + h) * 2;
	}

	public double getArea() {
		return area;
	}

	public double getPerimetro() {
		return perimetro;
	}

	public void ridimensiona(double nb, double nh) {
		area = nb * nh;
		perimetro = (nb + nh) * 2;
	}
}