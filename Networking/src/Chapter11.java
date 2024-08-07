import java.io.IOException;
import java.net.*;

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

            // constructor
            SocketAddress address = new InetSocketAddress("192.168.254.32", 4000);
            MulticastSocket multicastSocket1 = new MulticastSocket(address);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
