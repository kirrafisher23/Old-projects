/** 
 * Subclass to person. Customer has specific variables that differentiate from employee.
 */ 
public class Customer extends Person implements DataHandler {

	private String customerID;
	private String accountNumber;
	
	// constructor for Customer 
	public Customer(String firstName,String lastName,String address,String phoneNumber,String email,String customerID,String accountNumber) {
		
		super(firstName,lastName,address,phoneNumber,email);
		
		this.setCustomerID(customerID);
		this.setAccountNumber(accountNumber);
		
	}

	// getter and setter for Customer 
	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/** 
     * Overrided from DataHandler interface used to retrieve data in customer class
     * @return String custout
     */
	@Override
	public String getInfo() {
		String custout = "";
		custout = " Customer Info: Customer Name:" + getLastName() + "," + getFirstName() +"	Customer ID: "+getCustomerID()+"	Account Number: "+getAccountNumber();
	
		return custout;
	}
	
	/** 
     * Overrided from DataHandler interface used to retrieve data in FileHandler 
     * @return String fileOut
     */

	@Override
	public String getFileData() {
		String fileOut = "";
		fileOut = getCustomerID() + "," + getFirstName() + ","+getLastName();
		return fileOut;
	}
	
}
