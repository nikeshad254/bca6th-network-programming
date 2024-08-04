import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeServer {
    public static void main(String[] args) {
        int port = 80; // Server port

        System.out.println("Nikesh - Lab 19: Server Application with Socket Options\n");
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            // Set server socket options
            serverSocket.setSoTimeout(60000); // Set timeout to 60 seconds
            serverSocket.setReuseAddress(true);

            System.out.println("Server is listening on port " + port);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    // Serve text data: current date and time
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    out.println("Current Date and Time: " + currentDateTime);

                    // Serve binary data: a simple message in bytes
                    DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
                    byte[] binaryMessage = "Binary Data: Hello Client!".getBytes();
                    dataOut.write(binaryMessage);

                    // Close client connection
                    out.close();
                    dataOut.close();
                    socket.close();
                } catch (SocketTimeoutException e) {
                    System.out.println("Socket timed out!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
