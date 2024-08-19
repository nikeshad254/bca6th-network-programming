import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    public static void main(String[] args) throws IOException {
        System.out.println("Nikesh - Lab 24: Multicast Receiver");
        // Multicast group address and port
        InetAddress group = InetAddress.getByName("224.0.0.1"); // Replace with your multicast address
        int port = 4447; // Replace with your multicast port

        try (MulticastSocket socket = new MulticastSocket(port)) {
            socket.joinGroup(group);

            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);

            System.out.println("Listening for multicast data...");

            while (true) {
                socket.receive(packet);
                String receivedData = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + receivedData);
            }
        }
    }
}