import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Lab 12: URL Connection Details
 * Write a Java program that establishes a URLConnection to "https://www.example.com".
 * Print out details such as URL, protocol, and content length.
 */
public class URLConnectionDetails {

    public static void main(String[] args) throws IOException {
        System.out.println("Nikesh - Lab 12: URL Connection Details\n");

        String urlString = "https://www.example.com";
        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();

        System.out.println("URL: "+ urlConnection.getURL());
        System.out.println("Content Length: "+ urlConnection.getContentLength());
        System.out.println("Protocol: "+ url.getProtocol());

    }
}
