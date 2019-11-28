
//package prodcon;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Producer {
    
    private static Customer readCustomer(String acc_no,String fn,String ln,String email, double amnt){                 
       Customer  c = new  Customer(acc_no, fn, ln, email, amnt);
       return c;
    }
    
    public static void main(String args[]) throws FileNotFoundException, RemoteException, MalformedURLException{
        
       Customer cust;
       List<Customer> producerList = new ArrayList<>();
       BufferedReader reader= new BufferedReader(new FileReader("Customer.txt"));
       Bank producer_stub = null;
       /*
       System.setProperty("java.security.policy","file:D:\\RMIDilwar\test.policy");
       if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
       */
        String remoteHostName = "localhost";
        int remotePort = 8888;
        String connectLocation = "rmi://" + remoteHostName + ":" + remotePort+ "/RMIServer";
                
       try{
           //producer_stub = (Bank) Naming.lookup("rmi://192.168.43.13:1099/RMIServer");
           producer_stub = (Bank) Naming.lookup(connectLocation);
           System.out.println("Connected to RMI server");
           
           String line = null;
           try{
		while ((line=reader.readLine())!=null) {
                    String[] data = line.split("-"); 
                    cust=readCustomer(data[0],data[1],data[2],data[3],Double.valueOf(data[4])); 
                    producerList.add(cust);
                    producer_stub.putCustomers(cust);
                    System.out.println("-------------------Customer Data Produced------------------");
                    System.out.println(cust.toString());
                    System.out.println("Customer list size="+producerList.size());
                    Thread.sleep(2500);
                }
		reader.close();
           }catch(Exception e){
               System.out.println(e.getMessage());
           }
           
       }catch(Exception e){
           System.out.println(e.getMessage());
       }

    }
 
}
