package estudos_sockets.criptografia_mensagens;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Servidor {

    private static final int PORT = 55556;
    private static final Map<String, String> MESSAGES = new HashMap<>();

    static {
        MESSAGES.put("20210001", "Hello World");
        MESSAGES.put("20210002", "Java Programming");
        MESSAGES.put("20210003", "Socket Communication");
        MESSAGES.put("20210004", "Encrypted Message");
        MESSAGES.put("20210005", "Network Security");
    }

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor iniciado na porta " + PORT);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                    String matricula = in.readLine();
                    System.out.println("Matrícula recebida: " + matricula);

                    String message = MESSAGES.getOrDefault(matricula, "Matricula não encontrada");
                    String encryptedMessage = CifraCesar.encrypt(message);
                    out.println(encryptedMessage);

                } catch (IOException e) {
                    System.err.println("Erro de comunicação com o cliente: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.err.println("Não foi possível iniciar o servidor: " + e.getMessage());
        }
    }
}
