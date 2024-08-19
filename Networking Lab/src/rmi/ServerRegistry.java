package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerRegistry {
    public static void main(String[] args) {
        System.out.println("Nikesh - Lab 25: RMI Add Numbers");
        try {
            LocateRegistry.createRegistry(1099);
            RemoteImpl obj = new RemoteImpl();
            Naming.bind("remote", obj);
        } catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
            throw new RuntimeException(e);
        }

    }
}
