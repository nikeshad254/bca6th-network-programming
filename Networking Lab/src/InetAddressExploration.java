import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Lab 1: [IP Lookups and InetAddress Creation]
 * •	Initialize an object of InetAddress class using:
 * •	    -> Hostname
 * •	    -> IP address
 * •	    -> Get and display all the IP address of the name “www.orielly.com”
 * •	Initialize an InetAddress object using the Local address of your machine.
 * •	Use the IP address 13.227.138.129 to define an InetAddress object and display the contents stored by the object.
 * •	Define an InetAddress object using the hostname “www.xyz.com” and IP address  202.25.1.152
 */

public class InetAddressExploration {
    public static void main(String[] args) {
        try {

            System.out.println("Nikesh - Lab 1: IP Lookups and InetAddress Creation");
            // 1. Initialize using hostname
            InetAddress byHostname = InetAddress.getByName("www.oreilly.com");
            System.out.println("Hostname: " + byHostname.getHostName());
            System.out.println("IP Address (byHostname): " + byHostname.getHostAddress());

            // 2. Get all IP addresses for a hostname (may return multiple)
            InetAddress[] allAddresses = InetAddress.getAllByName("www.oreilly.com");
            System.out.println("All IP Addresses for www.oreilly.com: ");
            for (InetAddress address : allAddresses) {
                System.out.print(address.getHostAddress() + " , ");
            }

            // 3. Initialize using local machine address
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Local address: "+ localAddress);

            // 4. Initialize using specific IP address
            InetAddress byIpAddress = InetAddress.getByAddress(new byte[]{13, (byte) 227, (byte) 138, (byte) 129});
            System.out.println("By Ip Address : " + byIpAddress);

            // 5. Initialize using hostname and IP address
            InetAddress objUsingHostNameAndIp = InetAddress.getByAddress("www.xyz.com", new byte[]{(byte) 202, 25, 1, (byte) 152});
            System.out.println("Obj using hostname and ip: "+ objUsingHostNameAndIp);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }

    }
}
