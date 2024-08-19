import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

    public static void main(String[] args) {
        System.out.println("Nikesh - Lab 22: UDP Client Example");
        try {
            DatagramSocket socket = new DatagramSocket(13);
            socket.setSoTimeout(10000);

            InetAddress host = InetAddress.getByName("localhost");
            DatagramPacket request = new DatagramPacket(new byte[1024], 1024, host, 8080);

            byte[] data = new byte[1024];
            DatagramPacket response = new DatagramPacket(data, data.length);

            socket.send(request);
            socket.receive(response);

            String dateTime = new String(response.getData(), 0, response.getLength(), "US-ASCII");
            System.out.println(dateTime);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
