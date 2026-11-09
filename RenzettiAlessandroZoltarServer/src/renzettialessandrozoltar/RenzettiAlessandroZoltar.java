package renzettialessandrozoltar;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RenzettiAlessandroZoltar {

    public static void main(String[] args) {
        int porta = 5555;

        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Server Zoltar avviato... In attesa di client sulla porta " + porta + "...");
            
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Nuova connessione accettata da: " + socket.getRemoteSocketAddress());
                
                // Avvia un thread isolato per gestire le domande di questo specifico client
                new Thread(new ThreadGestoreServer(socket)).start();
            }

        } catch (IOException e) {
            System.err.println("Errore del ServerSocket: " + e.getMessage());
        }
    }
}
