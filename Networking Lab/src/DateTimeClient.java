import java.io.*;
import java.net.*;

public class DateTimeClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server address
        int port = 80; // Server port

        System.out.println("Nikesh - Lab 18: Client Application with Socket Options\n");
        try {
            // Connect to the server using socket constructor
            Socket socket = new Socket(serverAddress, port);

            // Set socket options
            socket.setTcpNoDelay(true);
            socket.setSoTimeout(5000); // Set timeout to 5 seconds

            // Retrieve and display socket information
            System.out.println("Connected to server at " + socket.getInetAddress() + ":" + socket.getPort());
            System.out.println("Local socket address: " + socket.getLocalSocketAddress());
            System.out.println("TCP_NODELAY: " + socket.getTcpNoDelay());
            System.out.println("SO_TIMEOUT: " + socket.getSoTimeout());

            // Read text response from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = in.readLine();
            System.out.println("Server response (text): " + serverResponse);

            // Read binary response from server
            DataInputStream dataIn = new DataInputStream(socket.getInputStream());
            byte[] binaryData = new byte[1024];
            int bytesRead = dataIn.read(binaryData);
            String binaryResponse = new String(binaryData, 0, bytesRead);
            System.out.println("Server response (binary): " + binaryResponse);

            // Close connections
            in.close();
            dataIn.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
