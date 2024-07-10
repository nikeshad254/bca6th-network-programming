import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class Chapter9 {
    public static void main(String[] args) {

        // Client example of non blocking IO
        SocketAddress socketAddress = new InetSocketAddress("www.google.com", 13);
        try {
            SocketChannel socketChannel = SocketChannel.open(socketAddress); // Blocking IO
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024); // Buffer size set
             int socketRead = socketChannel.read(byteBuffer);
            WritableByteChannel output = Channels.newChannel(System.out);
            byteBuffer.flip();
            output.write(byteBuffer);
            byteBuffer.clear();

            System.out.println("Buffer Position: "+ byteBuffer.position());
            byteBuffer.position(25);

            System.out.println("Buffer Capacity: "+ byteBuffer.capacity());

            byteBuffer.limit(50);
            System.out.println("Buffer Limit: "+ byteBuffer.limit());

            System.out.println("Buffer Mark: "+ byteBuffer.mark());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Server example of Non Blocking IO
        ServerSocketChannel serverChannel = null;
        try {
            ServerSocket ss = serverChannel.socket();
            ss.bind(new InetSocketAddress(19));

            SocketChannel clientChannel = serverChannel.accept();
            clientChannel.configureBlocking(false);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}