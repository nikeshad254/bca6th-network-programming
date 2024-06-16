import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * Lab 7: URL Splitter with User Input
 * Write Java code to accept a URL as user input and split the  URL into pieces.
 * Trace the output using any three random URLs.
 */
public class URLSplitter {

    public static void main(String[] args) throws URISyntaxException {
        System.out.println("Nikesh - Lab 7: URL Splitter with User Input\n");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a URL: ");
        String urlString = scanner.nextLine();

        URI uri = new URI(urlString);
        System.out.println("  Scheme: " + uri.getScheme());
        System.out.println("  Authority: " + uri.getAuthority());
        System.out.println("  User Info: " + (uri.getUserInfo() != null ? uri.getUserInfo() : "Not provided"));
        System.out.println("  Path: " + uri.getPath());
        System.out.println("  Query: " + (uri.getQuery() != null ? uri.getQuery() : "Not provided"));
        System.out.println("  Fragment: " + (uri.getFragment() != null ? uri.getFragment() : "Not provided"));
    }
}
