import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

// Lab 5: Basic Web Page Downloader
public class WebPageDownloader {

    public static void main(String[] args) throws IOException {
        System.out.println("Nikesh - Lab 5: Basic Web Page Downloader\n");

        URL url = new URL("https://www.example.com");

        InputStream inputStream = url.openStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        System.out.println("Downloaded content:");
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
        reader.close();
        inputStream.close();
    }
}
