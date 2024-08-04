import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.net.InetSocketAddress;

public class SimpleNonBlockingIOServer {
    public static void main(String[] args) {
        System.out.println("Nikesh - Lab 21: Simplified Non-blocking I/O\n");
        try {
            // Set up server socket channel and selector
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.bind(new InetSocketAddress(8080));
            serverChannel.configureBlocking(false);

            Selector selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                selector.select();

                for (var key : selector.selectedKeys()) {
                    if (key.isAcceptable()) {
                        SocketChannel clientChannel = serverChannel.accept();
                        clientChannel.configureBlocking(false);
                        clientChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        SocketChannel clientChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(256);
                        int bytesRead = clientChannel.read(buffer);
                        if (bytesRead > 0) {
                            buffer.flip();
                            clientChannel.write(buffer);
                        } else {
                            clientChannel.close();
                        }
                    }
                    selector.selectedKeys().remove(key);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
