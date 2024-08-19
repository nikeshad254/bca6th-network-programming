package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) {
        System.out.println("Nikesh - Lab 25: RMI Add Numbers");
        try {
            RemoteInterface stub = (RemoteInterface) Naming.lookup("rmi://localhost/remote");
            System.out.println("Sum of 2+3: "+ stub.addNum(10, 20));

        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
