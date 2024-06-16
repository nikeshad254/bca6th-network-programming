import java.net.URI;
import java.net.URISyntaxException;

/**
 * Lab 8: URL Equality Checker
 * Write Java code to check either http://www.ibiblio.org and  http://ibiblio.org are same or not?
 */

public class UrlEqualityChecker {
    public static void main(String[] args) throws URISyntaxException {
        System.out.println("Nikesh - Lab 8: URL Equality Checker\n");

        URI uri1 = new URI("http://www.ibiblio.org");
        URI uri2 = new URI("http://ibiblio.org");

        boolean areEqual = uri1.equals(uri2);

        System.out.println("Are URLs equal? " + areEqual);
    }
}
