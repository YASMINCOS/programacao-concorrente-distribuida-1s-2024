package estudos_sockets.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servidor {
    public static void main(String[] args) {
        String mensagem = "Hello world!";
        byte[] entrada = new byte[1000], saida = mensagem.getBytes();
        try {
            DatagramSocket socket = new DatagramSocket(12345);
            DatagramPacket dgEntrada = new DatagramPacket(entrada,
                    entrada.length);
            socket.receive(dgEntrada);
            System.out.println("Conexão com cliente " +
                    dgEntrada.getAddress().getHostAddress() + ":" +
                    dgEntrada.getPort());
            System.out.println("MENSAGEM: " + (new String(entrada)));
            DatagramPacket dgSaida = new DatagramPacket(saida,
                    saida.length, dgEntrada.getAddress(),
                    dgEntrada.getPort());
            socket.send(dgSaida);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
