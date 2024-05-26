package estudos_sockets.exercicio_string_invert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {
        String serverAddress = "localhost"; // Endereço do servidor
        int port = 55555; // Porta do servidor

        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado ao servidor " + serverAddress + " na porta " + port);
            String userInput;

            System.out.print("Digite uma string para inverter (ou 'exit' para sair): ");
            while ((userInput = stdIn.readLine()) != null) {
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }

                out.println(userInput);
                System.out.println("String invertida: " + in.readLine());
                System.out.print("Digite outra string para inverter (ou 'exit' para sair): ");
            }

        } catch (IOException e) {
            System.err.println("Erro de comunicação com o servidor: " + e.getMessage());
        }
    }
}

