
//package prodcon;

import java.rmi.*;
interface Bank extends Remote{
	public  Customer getCustomers()throws RemoteException;
	public void putCustomers(Customer c)throws RemoteException;
        
}