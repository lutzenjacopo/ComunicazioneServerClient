package server;

import java.net.*;
import java.io.*;

public class ThreadScrittura implements Runnable {

    private final BufferedReader tastiera;

    public ThreadScrittura() {
        this.tastiera = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        try {
            String messaggio;
            while ((messaggio = tastiera.readLine()) != null) {
                Server.inviaATutti("Server: " + messaggio);

                if ("fine".equalsIgnoreCase(messaggio)) {
                    break;
                }
            }
        } catch (IOException e) {
            System.err.println("Errore durante l'invio: " + e.getMessage());
        }
    }
}
