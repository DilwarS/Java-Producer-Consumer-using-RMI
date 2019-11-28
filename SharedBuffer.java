
//package prodcon;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
public class SharedBuffer extends UnicastRemoteObject implements Bank {
    
    final static int MAX_SIZE=1;
    static List<Customer> cList;
    Customer c = null;

    public SharedBuffer(List custList) throws RemoteException{
        SharedBuffer.cList = custList;
    }
    
     @Override
    public synchronized void putCustomers(Customer c) throws RemoteException {
        try{
        while(cList.size()==MAX_SIZE){
            System.out.println("Producer is waiting....");
            wait();
        }
         cList.add(c);
         System.out.println("Customer Data Added by:"+Thread.currentThread().getName()+""+c.toString());
         System.out.println("\n-----------------------------");
         notify();
    }catch(Exception e){
            System.out.println(e.getMessage());
    }
    }
    @Override
    public synchronized Customer getCustomers(){ 
        notify();
        while(cList.isEmpty()){
            System.out.println("Consumer Waiting (empty queue)......");
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        } 
   
            c =  cList.get(0);  
            cList.remove(c);
            System.out.println("----------------------------------");
            System.out.println("Consumed by: "+Thread.currentThread().getName()+""+c.toString());
            System.out.println("Current Customer List size= "+cList.size());
            System.out.println("----------------------------------");        
            return c;
         
    }

   
}
