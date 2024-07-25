import java.io.IOException;
import java.net.*;
import java.util.Date;

public class Chapter10Server {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(13);

            DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 1024);

            datagramSocket.receive(datagramPacket);
            byte[] data = new Date().toString().getBytes();

            DatagramPacket response = new DatagramPacket (data, data.length, datagramPacket.getAddress(), datagramPacket.getPort());
            datagramSocket.send(response);

            DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1024], 1024, new InetSocketAddress(12));
            DatagramPacket datagramPacket3 = new DatagramPacket(new byte[1024], 0, 1024, new InetSocketAddress(12));


        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
