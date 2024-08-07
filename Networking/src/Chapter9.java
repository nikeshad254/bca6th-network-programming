import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class Chapter9 {
    public static void main(String[] args) {
        /*
        // Client example of non blocking IO
        SocketAddress socketAddress = new InetSocketAddress("www.google.com", 13);
        try {
            SocketChannel socketChannel = SocketChannel.open(socketAddress); // Blocking IO
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024); // only on bytebuffer
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


            // methods
            byteBuffer.clear(); // position = 0, limit = capacity
            byteBuffer.flip(); // limit = current position, position = 0
            byteBuffer.rewind(); // position = 0, limit = unchanged
            System.out.println("no of remaining: "+ byteBuffer.remaining()); // currentPos to limit
            System.out.println("is Remaining: "+ byteBuffer.hasRemaining()); // if currentPos to limit > 1


            // Buffer Allocation capacity
            CharBuffer charBuffer = CharBuffer.allocate(300);
            IntBuffer intBuffer = IntBuffer.allocate(200);
            DoubleBuffer doubleBuffer = DoubleBuffer.allocate(300);

            byte[] byteData = byteBuffer.array(); // Unsupported exception when using allocationDirect
            char[] charData = charBuffer.array();
            int[] intData = intBuffer.array();
            double[] doubleData = doubleBuffer.array();

            char[] texts = "Some Char.".toCharArray();
            CharBuffer charBuffer1 = CharBuffer.wrap(texts);

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

         */

        /*
        try{
            CharBuffer charBuffer = CharBuffer.allocate(10);
            charBuffer.put('a'); // to place data in the buffer
            charBuffer.put('b');

            System.out.println("postition: "+ charBuffer.position());
            System.out.println("buffer at position: "+ charBuffer.get(charBuffer.position()));

            charBuffer.flip();
            charBuffer.put('c');
            charBuffer.put('d');
            System.out.println("\nAfter Flipping:-");
            System.out.println("position: "+ charBuffer.position());
            System.out.println("buffer at position: "+ charBuffer.get(charBuffer.position() - 1 ));
            System.out.println("buffer at position: "+ charBuffer.get(0));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

         */

    try{
        byte[] bytes = "Some text here".getBytes();
        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
        byteBuffer.put(bytes, 0, 10);
        byte[] newBytes = new byte[bytes.length];
        byteBuffer.get(newBytes, 0, 10);
//        System.out.println((char) newBytes[0]);

        System.out.println(byteBuffer.getChar(0));
        byteBuffer.putChar('a');
        System.out.println(byteBuffer.getDouble());

        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
        doubleBuffer.put(10);

        // duplicating
        DoubleBuffer newDoubleBuffer = doubleBuffer.duplicate();
        System.out.println("Double buffer data: "+ newDoubleBuffer.get(0));
        System.out.println("Buff equals?: "+ doubleBuffer.equals(newDoubleBuffer));
        System.out.println("Buff HashCode?: "+ doubleBuffer.hashCode());
        System.out.println("Buff HashCode?: "+ newDoubleBuffer.hashCode());
        System.out.println("Buff String?: "+ newDoubleBuffer.toString());

        doubleBuffer.put(20);
        doubleBuffer.put(30);
        doubleBuffer.put(40);
        doubleBuffer.put(50);
        doubleBuffer.put(60);
        doubleBuffer.put(70);

        doubleBuffer.position(4);
        // slicing: slice from current pos to the limit
        DoubleBuffer sliceDoubleBuffer = doubleBuffer.slice();
        System.out.println(sliceDoubleBuffer.get(0));
        System.out.println(sliceDoubleBuffer.get(1));
        System.out.println(sliceDoubleBuffer.get(2));
        System.out.println(sliceDoubleBuffer.get(3));


    }catch(Exception e){
        System.out.println("Error: "+ e.getMessage());
        e.printStackTrace();
    }

    }
}