import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncodingExample {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("Nikesh - Lab 10: URL Encoding Punctuation and Google Search Query\n");

        String[] characters = {" ", "*", "%", "+", "\\", ":", "=", "&"};

        // Encoding each character
        for (String ch : characters) {
            String encoded = URLEncoder.encode(ch, "UTF-8");
            System.out.println("Character: " + ch + " Encoded: " + encoded);
        }

        // Google search query encoding
        String url = "https://www.google.com/search?client=firefox-b-d&q=encoding+in+UETF8";
        String encodedUrl = URLEncoder.encode(url, "UTF-8");

        System.out.println("\nOriginal URL: " + url);
        System.out.println("Encoded URL: " + encodedUrl);
    }
}
