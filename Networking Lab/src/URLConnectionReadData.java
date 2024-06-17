import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Lab 13: URL Connection Read Data
 * Extend the previous program to read data (text/html) from the server and display it.
 */
public class URLConnectionReadData {
    public static void main(String[] args) throws IOException {
        System.out.println("Nikesh - Lab 13: URL Connection Read Data\n");

        String urlString = "https://www.example.com";
        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
