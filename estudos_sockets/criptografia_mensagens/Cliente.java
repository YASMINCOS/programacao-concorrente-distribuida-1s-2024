package estudos_sockets.criptografia_mensagens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 55556;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado ao servidor " + SERVER_ADDRESS + " na porta " + PORT);
            System.out.print("Digite sua matrícula: ");
            String matricula = stdIn.readLine();

            out.println(matricula);
            String encryptedMessage = in.readLine();
            String decryptedMessage = CifraCesar.decrypt(encryptedMessage);

            System.out.println("Mensagem criptografada: " + encryptedMessage);
            System.out.println("Mensagem descriptografada: " + decryptedMessage);

        } catch (IOException e) {
            System.err.println("Erro de comunicação com o servidor: " + e.getMessage());
        }
    }
}

