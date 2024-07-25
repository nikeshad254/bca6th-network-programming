import java.io.IOException;
import java.net.*;

public class Chapter10 {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(0);
            datagramSocket.setSoTimeout(10000);


            DatagramPacket request = new DatagramPacket(new byte[1], 1, InetAddress.getByName("localhost"), 13);
            datagramSocket.send(request);

            byte[]  bytes = new byte[1024];
            DatagramPacket response = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(response);

            System.out.println(new String(response.getData()));

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
