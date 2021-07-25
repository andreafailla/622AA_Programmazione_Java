package coop;
import java.io.Serializable;
 

// contiene le direttive per il tipo Socio ordinario e le sue sottoclassi (Finanziatore e Gestore)

public class Socio implements Serializable {
 
	private String nome; // nome socio
	protected boolean saldato; // true se il socio ha pagato la quota associativa, false altrimenti
	protected int quota; // la quota associativa
 
	// costruttore
	public Socio(String nome) {
		this.nome = nome;
		this.saldato = false;
		this.quota = UsaCooperativa.QUOTA_ORDINARIO;
 
	}
 
	// paga la quota associativa
	public void paga() {
		UsaCooperativa.capitale += this.quota; // incrementa il capitale di una somma pari alla quota associativa
		this.saldato = true;
		UsaCooperativa.aggiornaStorico(this.getNome(), this.getQuota(), true); // aggiorna lo storico
		System.out.println("Pagato. Il capitale della cooperativa è pari a " + UsaCooperativa.capitale + " euro.");
	}
 
	// restituisce il nome
	public String getNome() {
		return this.nome;
	}
 
	// restituisce true se il socio ha pagato la quota associativa, false altrimenti
	public boolean getSaldato() {
		return this.saldato;
	}
 
	// restituisce la quota associativa
	public int getQuota() {
		return this.quota;
	}
 
	// quando cambia l'anno, il socio deve pagare nuovamente la quota associativa
	public void cambiaAnno() {
		this.saldato = false;
	}
}