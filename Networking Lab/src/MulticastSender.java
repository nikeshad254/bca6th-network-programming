import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSender {
    public static void main(String[] args) throws Exception {
        // Multicast group address and port
        InetAddress group = InetAddress.getByName("224.0.0.1"); // Replace with your multicast address
        int port = 4447; // Replace with your multicast port

        try (MulticastSocket socket = new MulticastSocket()) {
            byte[] data = "Hello, multicast world!".getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, group, port);

            socket.send(packet);
            System.out.println("Sent multicast data");
        }
    }
}