package renzettialessandrozoltar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadGestoreServer implements Runnable {

    private Socket clientSocket;
    private GestoreDomande gestoreDomande;

    public ThreadGestoreServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.gestoreDomande = new GestoreDomande();
    }

    @Override
    public void run() {
        try (DataInputStream in = new DataInputStream(clientSocket.getInputStream()); DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {

            while (true) {
                gestoreDomande.tipo = in.readUTF();
                String domanda = in.readUTF();

                System.out.println("Richiesta da " + clientSocket.getInetAddress() + " | Personalità: " + gestoreDomande.tipo + " | Domanda: " + domanda);

                // Genera e invia la risposta
                String risposta = gestoreDomande.getRisposta(domanda);
                out.writeUTF(risposta);
                out.flush();
            }
        } catch (IOException e) {
            System.out.println("Un client si è disconnesso.");
        }
    }
}
