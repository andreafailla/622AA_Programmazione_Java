
public class Appartamento {

	private String proprietario;
	private int superficie, piano, inquilini;
	
	public Appartamento(String proprietario, int superficie, int piano, int inquilini) {
		this.proprietario = proprietario;
		this.superficie = superficie;
		this.piano = piano;
		this.inquilini = inquilini;
	}
	
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	
	public void setInquilini(int inquilini) {
		this.inquilini = inquilini;
	}
	
	public void visualizza() {
		System.out.println("Proprietario: " + proprietario);
		System.out.println("Superficie (mq): " + superficie);
		System.out.println("Piano: " + piano);
		System.out.println("Numero di inquilini: " + inquilini);
	}
	
	public String getProprietario() {
		return proprietario;
	}
	
	public int getSuperficie() {
		return superficie;
	}
	
	public int getPiano() {
		return piano;
	}
	
	public int getInquilini() {
		return inquilini;
	}
	
}
