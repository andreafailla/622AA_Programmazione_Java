// Andrea Failla, 2021
// Laboratorio di Programmazione in Java

package Laboratorio_Informatica;

public class Utente extends Thread {
	public String nome;
	public String ruolo;
	public Laboratorio lab;
	// true quando e' nel laboratorio, false altrimenti 
	public boolean inLab;
	// true se occupa il PC dei tesisti, false altrimenti
	public boolean occupaPCtesi;
	
	// costruttore
	public Utente(String nome, String ruolo, Laboratorio lab) { 
		super(nome);
		this.ruolo = ruolo;
		this.lab = lab;
		this.inLab = false;
		this.occupaPCtesi = false;
		start();
	}

	public void run() {
		while (true) {
			synchronized(lab) {
				
				// questo sleep per farli partire in momenti diversi
				try { 
					sleep((int)(Math.random() * 200));  
					System.out.println(this.getName() + " vuole entrare");
				} catch (InterruptedException e) {e.printStackTrace();}
				
				// prova a entrare
				lab.entra();

				// rimane dentro per un po'
				try { 
					sleep((int)(Math.random() * 200)); 
					
				} catch (InterruptedException e) {e.printStackTrace();}
				
			
				// esce
				lab.esce();
				
			}
		}
	}
}

