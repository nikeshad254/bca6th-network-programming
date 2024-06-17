import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Lab 15: URLConnection Configuration
 * Implement methods to set timeouts, enable/disable caching, and configure user interaction for the URLConnection.
 */
public class URLConnectionConfiguration {
    public static void main(String[] args) {

        System.out.println("Nikesh - Lab 15: URLConnection Configuration");
        try {
            URL url = new URL("https://www.example.com");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setConnectTimeout(3000);
            urlConnection.setUseCaches(false);
            urlConnection.setAllowUserInteraction(true);

            System.out.println("Timeout: "+ urlConnection.getConnectTimeout());
            System.out.println("Cache: "+ urlConnection.getUseCaches());
            System.out.println("User Interaction: "+ urlConnection.getAllowUserInteraction());


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
