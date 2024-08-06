import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Chapter11 {
    public static void main(String[] args) {
        try {
            MulticastSocket multicastSocket = new MulticastSocket(4000);

            InetAddress inetAddress = InetAddress.getByName("224.2.2.1");

            multicastSocket.joinGroup(inetAddress);

            DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);
            multicastSocket.receive(datagramPacket);

            multicastSocket.leaveGroup(inetAddress);
            multicastSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
