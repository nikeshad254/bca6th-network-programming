import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Lab 4: Hostname Comparison and Hash Code Generation
 * Write a program to check either the two names  “www.ibiblio.org” and “helios.ibiblio.org” are same or not.
 * Also generate the hash code for the both and print the hash  code as a string.
 */
public class HostnameComparison {
    public static void main(String[] args)  {
        try{
            InetAddress address1 = InetAddress.getByName("www.ibiblio.org");
            InetAddress address2 = InetAddress.getByName("helios.ibiblio.org");

            System.out.println("IsEqual: "+ address1.equals(address2));
            System.out.println("Hash code 1: "+ address1.hashCode());
            System.out.println("Hash code 2: "+ address2.hashCode());
        }catch (UnknownHostException e){
            System.out.println(e.getMessage());
        }

    }
}
