import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Lab 2: Exploring InetAddress Getters
 *  Illustrate the use of all the Getter methods using any suitable example.
 *  You can  choose any suitable InetAddress objects.
 */
public class InetAddressGetters {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("www.google.com");

        System.out.println("Nikesh - Lab 2: Exploring InetAddress Getters");

        System.out.println("\nAddress: "+ inetAddress.getAddress().toString());
        System.out.println("Host Address: "+ inetAddress.getHostAddress());
        System.out.println("Host Name: "+ inetAddress.getHostName());
        System.out.println("Canonical Host Name: "+ inetAddress.getCanonicalHostName());
        System.out.println("Local Host: "+ InetAddress.getLocalHost());
        System.out.println("GetByAddress: "+ InetAddress.getByAddress(new byte[]{13, (byte) 227, (byte) 138, (byte) 129}));
        System.out.println("GetByAddress (with host): "+ InetAddress.getByAddress("www.google.com",new byte[]{13, (byte) 227, (byte) 138, (byte) 129}));
        System.out.println("GetLoopBack: "+ InetAddress.getLoopbackAddress());
        System.out.println("GetAlByName: "+ InetAddress.getAllByName("www.google.com").toString());

    }
}
