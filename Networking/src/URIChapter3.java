import java.io.UnsupportedEncodingException;
import java.net.*;

public class URIChapter3 {
    public static void main(String[] args) {
        try {
            URI uri1 = new URI("http://www.xml.com/pub/a/2003/09/17/stax.html#id=_hbc");
            System.out.println("URI: " + uri1);

            URI absolute = new URI("http", "//www.google.com", null);
            System.out.println("Absolute: "+ absolute);

            URI relative = new URI(null, "/abc/def", "today");
            System.out.println("Relative: " + relative);

            // checking if uri1 is absolute or opaque
            if(uri1.isAbsolute()){
                System.out.println("uri1 is absolute");
            } else if (uri1.isOpaque()) {
                System.out.println("uri1 is opaque");
            }else{
                System.out.println("uri1 is relative");
            }

            System.out.println("\nAuthority: "+ uri1.getAuthority());
            System.out.println("Fragment: "+ uri1.getFragment());
            System.out.println("Host: "+ uri1.getHost());
            System.out.println("Path: "+ uri1.getPath());
            System.out.println("Port: "+ uri1.getPort());
            System.out.println("Query: "+ uri1.getQuery());
            System.out.println("User Info: "+ uri1.getUserInfo());
            System.out.println("Scheme: "+ uri1.getScheme());
            System.out.println("Specific Part: "+ uri1.getSchemeSpecificPart());

            // Resolving URIS
            URI resolvedToRelative = absolute.resolve(relative);
            System.out.println("Resolved a to r: "+ resolvedToRelative);

            URI resolvedToAbsolute = relative.relativize(absolute);
            System.out.println("Resolved r to a: "+ resolvedToAbsolute);

            // Encoding Decoding
            String encoding = URLEncoder.encode("This is Encoded * + Text", "UTF-8");
            System.out.println("\nEncoding: "+ encoding);

            String decoding = URLDecoder.decode(encoding);
            System.out.println("Decoding: "+ decoding);

            // Proxy Server
                // 1. System properties
            System.setProperty("http.proxyHost", "192.168.245.254");
            System.setProperty("http.proxyPort", "9000");

                // 2. Proxy Class
            SocketAddress socketAddress = new InetSocketAddress("Proxt.example.com", 80);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, socketAddress);
            System.out.println("Proxy: "+ proxy);


            // Password Auth
            PasswordAuthentication passwordAuthentication = new PasswordAuthentication("abc", new char[]{'a', 'b', 'c'});
            System.out.println("password: "+ passwordAuthentication.getPassword());
            System.out.println("username: "+ passwordAuthentication.getUserName());;

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
