import java.net.URI;
import java.net.URISyntaxException;

/**
 *  Lab 9: URI Analyzer
 *  Write Java code to extract parts of URI. Check either URI is opaque or not?
 *      If opaque, extract scheme, scheme specific part and fragment
 *      Else, extract authority, fragment, host, path, port, query .
 */
public class URIAnalyzer {

    public static void main(String[] args) throws URISyntaxException {
        System.out.println("Nikesh - Lab 9: URI Analyzer");
//        String urlString = "https://www.example.com/path/to/file?param1=value1#fragment"; // Replace with the actual URL
        String urlString = "mailto:user@example.com"; // Replace with the actual URL

        URI uri = new URI(urlString);
        System.out.println("Url: "+ urlString);
        if (uri.isOpaque()) {
            System.out.println("URI is opaque.");
            System.out.println("  Scheme: " + uri.getScheme());
            System.out.println("  Scheme Specific Part: " + uri.getSchemeSpecificPart());
            System.out.println("  Fragment: " + (uri.getFragment() != null ? uri.getFragment() : "Not provided"));
        } else {
            System.out.println("URI is no Opaque.");
            System.out.println("  Authority: " + uri.getAuthority());
            System.out.println("  Fragment: " + (uri.getFragment() != null ? uri.getFragment() : "Not provided"));
            System.out.println("  Host: " + uri.getHost());
            System.out.println("  Path: " + uri.getPath());
            System.out.println("  Port: " + uri.getPort());
            System.out.println("  Query: " + uri.getQuery());
        }
    }
}
