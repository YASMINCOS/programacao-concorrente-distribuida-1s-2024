package estudos_sockets.exercicio_udp_client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class Servidor {
    private static final int PORT = 9876;
    private static final int NUMBERS_COUNT = 1000;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            Random random = new Random();
            int sum = 0;

            // Receber a solicitação do cliente
            byte[] buffer = new byte[1024];
            DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(requestPacket);

            InetAddress clientAddress = requestPacket.getAddress();
            int clientPort = requestPacket.getPort();

            // Enviar 1000 números aleatórios
            for (int i = 0; i < NUMBERS_COUNT; i++) {
                int number = random.nextInt(100); // Número aleatório entre 0 e 99
                sum += number;

                byte[] numberBytes = String.valueOf(number).getBytes();
                DatagramPacket sendPacket = new DatagramPacket(numberBytes, numberBytes.length, clientAddress, clientPort);
                socket.send(sendPacket);
            }

            // Imprimir a soma dos números enviados
            System.out.println("Soma dos números enviados: " + sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
