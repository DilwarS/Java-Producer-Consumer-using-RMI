/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package prodcon;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

public class Consumer  {    
    public static void main(String args[]) throws RemoteException, InterruptedException{  
        System.setProperty("java.rmi.server.hostname", "192.168.43.13");
        //System.setProperty("java.security.policy","file:D:\\RMIDilwar\test.policy");
        try{
           Bank consumer_stub = (Bank) Naming.lookup("rmi://192.168.43.13:9090/RMIServer");
           System.out.println("Connected to RMI server");
           
            Customer readfromRMI;

           
                //for(int i=0;i<7;i++){
		while(true) {         
                readfromRMI= consumer_stub.getCustomers();
                System.out.println("---------------------------------");
                System.out.println("Data Read from RMI: "+readfromRMI.toString());
                Thread.sleep(3000);
                }
            
                //Customer readfromRMI= consumer_stub.getCustomers();
                //System.out.println("Data Read from RMI: "+readfromRMI.toString());
            
            //System.out.println("Data Read from RMI: "+readfromRMI.toString());
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
    }
    
}
