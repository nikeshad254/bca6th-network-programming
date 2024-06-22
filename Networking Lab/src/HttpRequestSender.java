import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Lab 16: Sending HTTP Requests with Different Methods
 * Develop functionality to send HTTP GET, POST, TRACE, and OPTION requests using HttpURLConnection.
 */
public class HttpRequestSender {

    public static HttpURLConnection sendGetRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        return connection;
    }

    public static HttpURLConnection sendPostRequest(String urlString, String payload) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = payload.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        return connection;
    }

    public static HttpURLConnection sendTraceRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("TRACE");
        return connection;
    }

    public static HttpURLConnection sendOptionsRequest(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("OPTIONS");
        return connection;
    }

    public static void main(String[] args) {

        System.out.println("Nikesh - Lab 16: Sending HTTP Requests with Different Methods\n");
        try {
            String getUrl = "http://example.com";
            String postUrl = "http://example.com";
            String postPayload = "{\"key\":\"value\"}";

            HttpURLConnection getResponse = sendGetRequest(getUrl);
            HttpURLConnection postResponse = sendPostRequest(postUrl, postPayload);
            HttpURLConnection traceResponse = sendTraceRequest(getUrl);
            HttpURLConnection optionsResponse = sendOptionsRequest(getUrl);

            System.out.println("GET Request Response Code: " + getResponse.getResponseCode());
            System.out.println("POST Request Response Code: " + postResponse.getResponseCode());
            System.out.println("TRACE Request Response Code: " + traceResponse.getResponseCode());
            System.out.println("OPTIONS Request Response Code: " + optionsResponse.getResponseCode());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
