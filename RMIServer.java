//package prodcon;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class RMIServer{


    public static void main(String[] args)  {
        
      
      System.setProperty("java.rmi.server.hostname", "192.168.43.13");
      List<Customer> customers= new ArrayList<>();
      Registry registry;
      String s_name="RMIServer";
      String hostname = "192.168.43.13";
      int port= 9090;
      
 
       try { 
         // Instantiating the implementation class 
         String bindLocation = "rmi://" + hostname + ":" + port + "/"+s_name;
         Bank skeleton = new SharedBuffer(customers); 
         registry = LocateRegistry.createRegistry(port);
         System.out.println("Registry created");
         registry.rebind(s_name,skeleton); 
         System.out.println("Server ready"); 
         
         
      } catch (Exception e) { 
         System.out.println("Server exception: " + e.getMessage()); 
         
      } 
        

  }
}

    
    

