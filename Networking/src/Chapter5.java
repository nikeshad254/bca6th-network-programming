import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class Chapter5 {
    public static void main(String[] args) {

        try {
            // Url Object
            URL url = new URL("http://www.google.com/");
//            URL url = new URL("https://go.qwiklabs.com/arcade");


            // Open Connection
            URLConnection urlConnection = url.openConnection();

            // allow user to send datas
            urlConnection.setAllowUserInteraction(true);

            // setting accept req property
            urlConnection.setRequestProperty("accept","text/html, image/jpeg, image/gif ");

            // Read Data
            InputStream inputStream = urlConnection.getInputStream();
            InputStream bufferedInputStream = new BufferedInputStream(inputStream);
            Reader reader = new InputStreamReader(bufferedInputStream);
            int c;
//            while((c = reader.read()) != -1){
//                System.out.print((char) c);
//            }

            System.out.println("Content Type: "+ urlConnection.getContentType());
            System.out.println("Content Length: "+ urlConnection.getContentLength());
            System.out.println("Content Encoding: "+ urlConnection.getContentEncoding());
            System.out.println("Content Access Date: "+ new Date(urlConnection.getDate()));
            System.out.println("Content Modified Date: "+ new Date(urlConnection.getLastModified()));
            System.out.println("Get specific part of header (content-type): "+ urlConnection.getHeaderField("content-type"));
            System.out.println("Get specific part of header (server): "+ urlConnection.getHeaderField("server"));
            System.out.println("Get specific part of header (connection): "+ urlConnection.getHeaderField("connection"));
            System.out.println("Header field key by index: "+ urlConnection.getHeaderFieldKey(1));
            System.out.println("Header field by index: "+ urlConnection.getHeaderField(1));
            System.out.println("Header Date (date): "+ new Date(urlConnection.getHeaderFieldDate("date", 0)));
            System.out.println("Header Field Length (content-length): "+ urlConnection.getHeaderFieldInt("content-length", -1));

            // URL Config
            //getURL
            System.out.println("URL is: "+ urlConnection.getURL());
            System.out.println("Is User Interaction Allowed?: "+ urlConnection.getAllowUserInteraction());
            System.out.println("Url connection can be read (getDoInput): "+ urlConnection.getDoInput());
            System.out.println("can send output back to server (getDoOutput): "+ urlConnection.getDoOutput());
            System.out.println("is modified: "+ urlConnection.getIfModifiedSince());
            System.out.println("is using caching: "+ urlConnection.getUseCaches());
            urlConnection.setConnectTimeout(30000);
            System.out.println("connect timeout: "+ urlConnection.getConnectTimeout());
            System.out.println("read timeout: "+ urlConnection.getReadTimeout());

            System.out.println("request property (accept): "+ urlConnection.getRequestProperty("accept"));
            System.out.println("Permission: "+ urlConnection.getPermission());

            URL url1 = new URL("https://www.google.com/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
            httpURLConnection.setChunkedStreamingMode(10);
            httpURLConnection.setRequestMethod("TRACE");
            System.out.println("Request Method: "+ httpURLConnection.getRequestMethod());

            System.out.println("Response Code: "+ httpURLConnection.getResponseCode());
            System.out.println("Response Message: "+ httpURLConnection.getResponseMessage());
            System.out.println("Is using proxy: "+ httpURLConnection.usingProxy());


            httpURLConnection.disconnect();


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
