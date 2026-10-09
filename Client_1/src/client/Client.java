/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package client;

import java.net.*;
import java.io.*;

/**
 *
 * @author lutzen.jacopo
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {//Porta e host dove voglio collegarmi
    
        int porta = 12345;
        String host = "10.205.0.21";
        System.out.println(InetAddress.getLocalHost().toString());
// Creazione socket
        try (Socket socket = new Socket(host, porta)) {
//Creazione reader per leggere il flusso in ingresso
// Dichiaro Oggetto Inputstream
            InputStream i = socket.getInputStream();
// Dichiaro uno InputStreamReader associato all'InputStream
            InputStreamReader is = new InputStreamReader(i);
// Dichiaro il BufferedReader di Lettura associato all' InputStreamReader
            BufferedReader br = new BufferedReader(is);
// Inizio lettura del testo in input (usando il buffered reader)
            String stringa;
            System.out.println("BufferedReader:");
            while ((stringa = br.readLine()) != null) {
                System.out.println(stringa);
            }
// ATTENZIONE: Il COdice che segue è una alternativa alla lettura
// senza il BufferedReader
//
// Lettura senza buffered reader
// stringa="";
// int carattere;
// while((carattere=is.read())!=-1){
// stringa+=(char)carattere;
// }
// System.out.println("Carattere per carattere: "+stringa+"\n");
            i.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Errore I/O: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}