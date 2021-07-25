// Andrea Failla, 2021
// Laboratorio di Programmazione in Java

package Bomba_Orologeria;


import java.net.*;
import java.io.*;


public class Bomba extends Thread {
	
	private int miccia;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;

	// costruttore
	public Bomba(Socket socket) throws IOException {
		this.socket = socket;
		
		// crea stream di input e di output
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		
		// lancia thread
		start();
	}
	
	
	// override di run
	public void run() {
		
		// genera un valore miccia casuale | 2 <= miccia <= 10
		miccia = (int)((Math.random()*8)+2);
		int miccia = this.miccia;
		pw.println(miccia);
		
		try {
			while(true) {
				// legge la miccia (stringa), la converte in int e la riduce di uno
				miccia = Integer.parseInt(br.readLine())--;
				
				// rilancia la bomba al client
				pw.println(miccia);
				
				// se esplode nel server (0) o nel client (-1) esce da ciclo
				if (miccia == 0 || miccia == -1) {
					break;
				}
			}
		}
		
		catch (IOException e) {
			System.err.println("Errore di I/O...");
		}
		
		// chiude socket
		try {
			socket.close();
		}
		catch (IOException e) {
			System.err.println("Errore di I/O...");
		}
	}
}
