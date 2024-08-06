import java.io.IOException;
import java.net.*;
import java.nio.channels.DatagramChannel;

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

            // With port and interface address
            DatagramSocket datagramSocket1 = new DatagramSocket(13, InetAddress.getByName("localhost"));
            // With socket address
            SocketAddress socketAddress = new InetSocketAddress(90);
            DatagramSocket datagramSocket2 = new DatagramSocket(socketAddress);
            datagramSocket2.close();

            DatagramSocket datagramSocket3 = new DatagramSocket();
            datagramSocket3.connect(InetAddress.getByName("localhost"), 80); // always have to send and recieve form this host and port
            System.out.println(datagramSocket3.getPort());
            System.out.println(datagramSocket3.getInetAddress());
            System.out.println(datagramSocket3.getRemoteSocketAddress());

            datagramSocket3.setSoTimeout(5000);
            System.out.println(datagramSocket3.getSoTimeout());

            datagramSocket3.setReceiveBufferSize(100);
            datagramSocket3.setSendBufferSize(100);
            datagramSocket3.setReuseAddress(true);
            datagramSocket3.setBroadcast(true);
            datagramSocket3.setTrafficClass(30); // 0 - 255


            // datagramSocket3.send(new DatagramPacket());
            // RECIEVE
            datagramSocket3.close();


            DatagramChannel datagramChannel = DatagramChannel.open();
            DatagramSocket datagramSocket4 = datagramChannel.socket();
            datagramSocket4.bind(new InetSocketAddress(0));

            DatagramPacket request1 = new DatagramPacket(new byte[1], 1, InetAddress.getByName("localhost"), 13);
            datagramSocket4.send(request1);

            DatagramPacket response1 = new DatagramPacket(new byte[1024], 1024);
            datagramSocket4.receive(response1);

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
