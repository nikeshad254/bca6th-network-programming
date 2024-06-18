import java.io.*;
import java.net.*;

public class Chapter6 {
    public static void main(String[] args) {
        try {

            /*
                Create socket using socket Address
                Using no argument Constructor

            Socket socket = new Socket(); // socket = port + address
            SocketAddress socketAddress = new InetSocketAddress("time.nist.gov", 13);
            socket.connect(socketAddress);

             */

            Socket socket = new Socket("time.nist.gov", 13);


            /*
            SocketAddress socketAddress = new InetSocketAddress("myproxy.example.com", 1080);
            // Proxy Socket
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, socketAddress);
            Socket socket = new Socket(proxy);
            socket.connect(socketAddress);
             */

            System.out.println("Nist's address: "+socket.getRemoteSocketAddress());

            System.out.println("Inet address: "+socket.getInetAddress());
            System.out.println("Port: "+socket.getPort());
            System.out.println("Local port: "+socket.getLocalPort());
            System.out.println("Your Local Address: "+socket.getLocalAddress());

            if(socket.isConnected()){
                System.out.println(" Socket Connected ");
            }

//            socket.close();
            if(socket.isClosed()){
                System.out.println("Socket is Closed");
            }

            InputStream in = socket.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(in, "ASCII");

            String dateTime = "";
            int time;
            while((time = inputStreamReader.read()) != -1){
                dateTime += (char) time;
            }

            System.out.println(dateTime);

            // write to socket
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out, "UTF-8");
            writer.write("Write Something");
            writer.flush();

//            Socket socket1 = new Socket(InetAddress.getByName("www.google.com"), 90);

            // Socket Options
            socket.setTcpNoDelay(true); // have no delay
            socket.setSoLinger(true, 50); // if socket is closed what to do with datagram [true, time till data is send]
            socket.setSoTimeout(3600); // doesnt disconnect socket for certain time
            socket.setReceiveBufferSize(1000);
            socket.setSendBufferSize(1000);
            socket.setKeepAlive(true);
//            socket.sendUrgentData(10); // with below
            socket.setOOBInline(true); // send urgent data while other data is being transfer
            socket.setReuseAddress(true); // allow use of single port by multiple sockets
            socket.setTrafficClass(120); // performance based on services


            System.out.println("Tcp No Delay: "+ socket.getTcpNoDelay());
            System.out.println("So Linger: "+ socket.getSoLinger()); // max time: 65535 s
            System.out.println("So Timeout: "+ socket.getSoTimeout()); // 0 = infinite
            System.out.println("Receive Buffer size: "+ socket.getReceiveBufferSize());
            System.out.println("Send buffer size: "+ socket.getSendBufferSize());
            System.out.println("Get Keep Alive: "+ socket.getKeepAlive()); // 11 minutes
            System.out.println("OOB In Line: "+ socket.getOOBInline());
            System.out.println("Reuse Address: "+ socket.getReuseAddress());
            System.out.println("Traffic Class: "+ socket.getTrafficClass());



            socket.close();
            System.out.println("Is Connection Open: "+ socket.isConnected());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
