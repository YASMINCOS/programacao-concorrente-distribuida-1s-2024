package estudos_sockets.exercicio_udp_client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 9876;
    private static final int NUMBERS_COUNT = 1000;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);

            // Enviar solicitação ao servidor
            byte[] requestBytes = "REQUEST".getBytes();
            DatagramPacket requestPacket = new DatagramPacket(requestBytes, requestBytes.length, serverAddress, SERVER_PORT);
            socket.send(requestPacket);

            int sum = 0;
            int count = 0;

            // Receber 1000 números aleatórios do servidor
            byte[] buffer = new byte[1024];
            for (int i = 0; i < NUMBERS_COUNT; i++) {
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivePacket);

                String numberStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
                int number = Integer.parseInt(numberStr);
                sum += number;
                count++;
            }

            // Imprimir a soma dos números recebidos e a quantidade de números
            System.out.println("Soma dos números recebidos: " + sum);
            System.out.println("Quantidade de números recebidos: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
