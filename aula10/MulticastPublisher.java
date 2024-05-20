package aula10;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class MulticastPublisher extends Thread {

    private DatagramSocket socket;
    private InetAddress group;
    private byte[] buf;

    public static void main(String args[]) {
        (new MulticastPublisher()).start();
    }

    public void run() {
        try {
            String multicastMessage = "Hello world!";
            socket = new DatagramSocket();
            group = InetAddress.getByName("230.0.0.0");
            buf = multicastMessage.getBytes();
            DatagramPacket packet
                    = new DatagramPacket(buf, buf.length, group, 4446);
            socket.send(packet);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
