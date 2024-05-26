package estudos_sockets.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class Cliente {
    public static void main(String[] args) {
        byte[] saida = "OK".getBytes(), entrada = new byte[1000];
        try {
            DatagramSocket socket = new DatagramSocket();
            socket.setSoTimeout(3000);
            DatagramPacket dgSaida = new DatagramPacket(saida,
                    saida.length,
                    InetAddress.getByName("localhost"), 12345);
            DatagramPacket dgEntrada = new DatagramPacket(entrada,
                    entrada.length);
            socket.send(dgSaida);
            socket.receive(dgEntrada);
            System.out.println("MENSAGEM: " + (new String(entrada)));
            socket.close();
        } catch (SocketTimeoutException e) {
            System.out.println("Fim do tempo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}