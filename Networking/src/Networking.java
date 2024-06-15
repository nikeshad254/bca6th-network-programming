import java.io.IOException;
import java.net.*;
import java.util.Enumeration;

public class Networking {
    public static void main(String[] args){
        System.out.println("Working");
        try {
            // get by name
            InetAddress inetAddressHostName = InetAddress.getByName("www.google.com");
            System.out.println("Host Name: " +inetAddressHostName.getHostName());
            System.out.println("Canonical Host Name: " +inetAddressHostName.getCanonicalHostName());

            // getting host name
            InetAddress inetAddressIp = InetAddress.getByName("107.23.216.196");
            System.out.println( "Getting Host Name: "+inetAddressIp.getHostName());

            // get all by name
            InetAddress[] inetAddressList = InetAddress.getAllByName("www.google.com");
            for (int i = 0; i < inetAddressList.length; i++) {
                System.out.println( "Address "+ i + " : "+ inetAddressList[i]);
            }

            // get local host
            InetAddress inetAddressLocal =  InetAddress.getLocalHost();
            System.out.println("Local Address: "+inetAddressLocal);

            // get by address in byte form
            byte[] addressByte = {107, 23, (byte)216, (byte)196};
            InetAddress inetAddressByAddress = InetAddress.getByAddress(addressByte);
            System.out.println("Get by address: " +inetAddressByAddress.getHostName());

            // get by address in byte and host
            InetAddress inetAddressByAddressAndHost = InetAddress.getByAddress("google.com",addressByte);
            System.out.println("Get by address and host: " +inetAddressByAddressAndHost.getHostAddress());


            // getting host name
            InetAddress inetAddressType = InetAddress.getByName("224.0.1.7");
            System.out.println( "Any Local address: "+ inetAddressType.isAnyLocalAddress());
            System.out.println( "Any Loop Back address: "+ inetAddressType.isLoopbackAddress());    // 127.0.0.1
            System.out.println("Link Local Address: " + inetAddressType.isLinkLocalAddress());
            System.out.println("Multi Cast Address: " + inetAddressType.isMulticastAddress());      //224.0.1.7
            System.out.println("MC Global: " + inetAddressType.isMCGlobal());   //224.0.1.7
            System.out.println("MC Node Local: " + inetAddressType.isMCNodeLocal());
            System.out.println("MC Link Local: " + inetAddressType.isMCLinkLocal());
            System.out.println("MC Site Local: " + inetAddressType.isMCSiteLocal());
            System.out.println("MC Org Local: " + inetAddressType.isMCOrgLocal());

            // is Reachable?
            System.out.println("Is Reachable: "+ inetAddressHostName.isReachable(600));

            // object methods
            InetAddress inetAddressEqual1 = InetAddress.getByName("107.23.216.196");
            InetAddress inetAddressEqual2 = InetAddress.getByName("107.23.216.196");
            System.out.println("Is Equals: "+ inetAddressEqual1.equals(inetAddressEqual2));
            System.out.println("To String: "+ inetAddressEqual1.toString());
            System.out.println("To hash code: "+ inetAddressEqual1.hashCode());

            // inet v4 address
            InetAddress inet4Address = Inet4Address.getByName("www.google.com");
            System.out.println("Inet v4 address: "+ inet4Address);

            // inet v6 address
            InetAddress inet6Address = Inet6Address.getByName("www.google.com");
            System.out.println("Inet v6 address: "+ inet6Address);

            // network interface
            NetworkInterface networkInterface = NetworkInterface.getByName("ethernet_0");
            System.out.println("network Interface: "+ networkInterface);

            // network interface by inetaddress
            NetworkInterface networkInterface1 = NetworkInterface.getByInetAddress(inet4Address);
            System.out.println("network interface By InetAddress: "+ networkInterface1);

            // returns connected physical devices list
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            int count = 1;
            while(networkInterfaces.hasMoreElements()){
                System.out.println("your networkInterface "+count+": "+ networkInterfaces.nextElement());
                count++;
            }

            NetworkInterface eth0 = NetworkInterface.getByName("ethernet_0");
            Enumeration<InetAddress> address = eth0.getInetAddresses();
            while (address.hasMoreElements()){
                System.out.println("enum Address: "+ address.nextElement());
            }

            System.out.println("network interface Get Name: "+ eth0.getName());
            System.out.println("network interface Get display Name: "+ eth0.getDisplayName());

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
