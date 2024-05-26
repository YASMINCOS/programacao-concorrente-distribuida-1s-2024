package estudos_sockets.exercicio_string_invert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        int port = 55555; // Porta do servidor

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor iniciado na porta " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        String reversedString = new StringBuilder(inputLine).reverse().toString();
                        out.println(reversedString);
                    }

                } catch (IOException e) {
                    System.err.println("Erro de comunicação com o cliente: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Não foi possível iniciar o servidor: " + e.getMessage());
        }
    }
}
