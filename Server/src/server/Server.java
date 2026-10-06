/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author lutzen.jacopo
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerSocket sSocket;
        Socket connessione;
        final int PORT = 12345; // (final significa che è 1 costante)
// stream per gestire il flusso in output
        OutputStream out;
        PrintWriter sOUT;
        try {
// Il Server risponde sulla porta 7777
            sSocket = new ServerSocket(PORT);
// Ciclo in attesa delle connesisoni
            while (true) {
                System.out.println("In attesa di connessioni...");
                connessione = sSocket.accept();
                System.out.println("Connessione stabilita.");
// Stampo l'Indirizzo IP di chi si è collegato
// Sfruttando l'Attributo della Connessione .getInetAddress()
                System.out.println(connessione.getInetAddress());
// Dichiaro l'OutputStream per l'Outuput dei DATI
                out = connessione.getOutputStream();
// Dichiarato il PrintWriter per Inviare i Dati
                sOUT = new PrintWriter(out);
//Invia l'informazione al client
                sOUT.println("ELDEGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
                sOUT.close();
                connessione.close();
                System.out.println("Connessione chiusa.");
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}