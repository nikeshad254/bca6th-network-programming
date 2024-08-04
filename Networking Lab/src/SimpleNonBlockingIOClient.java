import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class SimpleNonBlockingIOClient {
    public static void main(String[] args) {
        System.out.println("Nikesh - Lab 21: Simplified Non-blocking I/O\n");
        try {
            SocketChannel clientChannel = SocketChannel.open();
            clientChannel.configureBlocking(false);
            clientChannel.connect(new InetSocketAddress("localhost", 8080));

            Selector selector = Selector.open();
            clientChannel.register(selector, SelectionKey.OP_CONNECT);

            while (true) {
                selector.select();

                for (var key : selector.selectedKeys()) {
                    if (key.isConnectable()) {
                        clientChannel.finishConnect();
                        clientChannel.register(selector, SelectionKey.OP_WRITE);
                        System.out.println("Connected to server");
                    } else if (key.isWritable()) {
                        ByteBuffer buffer = ByteBuffer.allocate(256);
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Enter message: ");
                        String message = scanner.nextLine();
                        buffer.put(message.getBytes());
                        buffer.flip();
                        clientChannel.write(buffer);
                        buffer.clear();
                        clientChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        ByteBuffer buffer = ByteBuffer.allocate(256);
                        int bytesRead = clientChannel.read(buffer);
                        if (bytesRead > 0) {
                            buffer.flip();
                            String response = new String(buffer.array(), 0, bytesRead);
                            System.out.println("Server response: " + response);
                            clientChannel.register(selector, SelectionKey.OP_WRITE);
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
