// Andrea Failla, 2021
// Laboratorio di Programmazione in Java

package Bomba_Orologeria;

import java.net.*;
import java.io.*;

public class BombaClient {

		public static void main(String[] args) throws IOException {
			
			// dichiara IP, socket e variabili di lettoscrittura
			InetAddress address = InetAddress.getByName(null);
			Socket socket = null;
			BufferedReader br = null;
			PrintWriter pw = null; 
			

			try {
				// costruisce socket
				socket = new Socket(address, BombaServer.PORT); // porta del server
				
				System.out.println("Client Bomba: avviato \nSocket: " + socket);
				
				// crea stream di lettura
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	
				// crea stream di scrittura
				pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
				
				while (true) {
					
					// legge la miccia (stringa), la converte in int e la riduce di uno
					int miccia = Integer.parseInt(br.readLine())--;
					
					
					if (miccia > 0) {
						System.out.println("La bomba arriva al client. Esplode in " + miccia);
					}
					
					// se la miccia è a 0, la bomba esplode nel client
					else if (miccia == 0) {
						System.out.println("La bomba esplode nel client!! Vince il server!");						
						// avvisa il server, poi esce dal ciclo
						pw.println(miccia);
						break;
					}
					
					// se la miccia è a -1, la bomba è esplosa nel server
					else if (miccia == -1) {
						System.out.println("La bomba esplode nel server!! Vince il client!");
						// avvisa il server, poi esce dal ciclo
						pw.println(miccia);
						break;
					}
					
					// invia il valore della miccia al server
					pw.println(miccia);
				}
			}
	
			
			catch (UnknownHostException e) {
				System.err.println("Indirizzo sconosciuto: " + address);
			}
			catch (IOException e) {
				System.err.println("Errore di I/0...");
			}
			
			// chiude tutto
			br.close();
			pw.close();
			socket.close();
			System.out.println("Client chiuso...");
		}

	}
