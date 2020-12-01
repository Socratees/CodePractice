package others.design_pattern.proxy;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    @Override
    public String sayHello() {
        return "Server says, Hey";
    }

    public MyRemoteImpl() throws RemoteException{}

    public static void main(String[] args) {
        try{
            MyRemote service = new MyRemoteImpl();
            Naming. rebind("RemoteHello", service);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
