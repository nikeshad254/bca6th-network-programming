import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Lab 3: Network Address Type Classifier
 * Write a program to find the type of address for the given input name or address
 * provided by the user.
 */
public class NetworkAddressClassifier {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Nikesh - Lab 3: Network Address Type Classifier");

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter an address or name: ");
        String input = scanner.nextLine();

        // getting host name
        InetAddress inetAddressType = InetAddress.getByName(input);
        String addressType = "";

        if(inetAddressType.isAnyLocalAddress()) addressType += " Any Local";
        if(inetAddressType.isLoopbackAddress()) addressType += " , LoopBack";
        if(inetAddressType.isLinkLocalAddress()) addressType += " , Link Local";
        if(inetAddressType.isMulticastAddress()) addressType += " , MultiCast";
        if(inetAddressType.isMCGlobal()) addressType += " , MC Global";
        if(inetAddressType.isMCNodeLocal()) addressType += " , MC Node";
        if(inetAddressType.isMCLinkLocal()) addressType += " , MC Link Local";
        if(inetAddressType.isMCSiteLocal()) addressType += " , MC Site Local";
        if(inetAddressType.isMCOrgLocal()) addressType += " , MC Org Local";

        System.out.println("\nAddressTypes: "+ addressType);
    }
}
