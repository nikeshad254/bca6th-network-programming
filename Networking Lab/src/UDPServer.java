import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

public class UDPServer {
    public static void main(String[] args) {
        System.out.println("Nikesh - Lab 23: UDP Server Example");
        try {
            DatagramSocket socket = new DatagramSocket(8080);
            DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
            socket.receive(request);

            String dayTime = new Date().toString();
            byte[] data = dayTime.getBytes("US-ASCII");
            DatagramPacket response = new DatagramPacket(data, data.length, request.getAddress(), request.getPort());
            socket.send(response);
            System.out.println("Date Time sent to client => " + dayTime);
            System.out.println("Clients address:port => "+ request.getAddress() + ":" + request.getPort());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
