import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Lab 14: URL Connection Headers
 * Modify the program to retrieve and display specific HTTP headers like Content-Type and Last-Modified.
 */
public class URLConnectionHeader {
    public static void main(String[] args) {
        System.out.println("Nikesh - Lab 14: URL Connection Headers\n");

        try {

            String urlString = "https://www.example.com";
            URL url = new URL(urlString);
            URLConnection urlConnection = url.openConnection();

            System.out.println("Content Type: "+ urlConnection.getHeaderField("content-type"));
            System.out.println("Last Modified: "+ urlConnection.getHeaderField("last-modified"));


        }catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
