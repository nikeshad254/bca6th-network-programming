import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

// Lab 6: Basic File Downloader
public class FileDownloader {

    public static void main(String[] args) throws IOException {
        String fileURL = "https://i.ibb.co/8MZD1kb/photo-6301055527240711847-y.jpg";
        String saveFilePath = "downloadedImage.jpg";

        try {

            InputStream in = new URL(fileURL).openStream();
            FileOutputStream out = new FileOutputStream(saveFilePath);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }

            in.close();
            out.close();
            System.out.println("File downloaded to " + saveFilePath);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
