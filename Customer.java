
//package prodcon;
import java.io.Serializable;
public class Customer implements Serializable{
        
	private String acc_no;
	private String firstname,lastname,email;
	private double amount;

    public Customer(String acc_no, String firstname, String lastname, String email, double amount) {
        this.acc_no = acc_no;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.amount = amount;
    }
          

	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String accNo) {
		acc_no = accNo;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

    @Override
    public String toString() {
        return "\nCustomer:" + "\nAcc_no: " + acc_no + "\nFirst Name: " + firstname + "\nLast Name: " + lastname + "\nemail: " + email + "\nAmount: " + amount;
    }
        
	
}
