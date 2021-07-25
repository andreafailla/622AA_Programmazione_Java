// Andrea Failla, 2021
// Laboratorio di Programmazione in Java

package Bomba_Orologeria;

import java.net.*;
import java.io.*;


public class BombaServer {
	
	// il server mette a disposizione la porta 8080
	public final static int PORT = 8080;
	
	public static void main(String[] args) throws IOException {
		
		// crea socket server e client
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("Server avviato.\nSocket: " + serverSocket);
		Socket clientSocket = null;
		
		try {
			while (true) {
				// il server è in stato di attesa e accetta una richiesta del client
				clientSocket = serverSocket.accept();
				System.out.println("Connessione stabilita: " + clientSocket);
				
				// crea una bomba
				try {
					Bomba b = new Bomba(clientSocket);
					// lo start si trova nel costruttore
					System.out.println("Il server lancia una bomba!");
				}
				catch (IOException e) {
					clientSocket.close();
				}
			}
		}
		
		catch (IOException e) {
			System.err.println("Errore di I/O...");
		}
		
		// chiude socket
		clientSocket.close();
		serverSocket.close();
		System.out.println("Server chiuso...");
	}
}



