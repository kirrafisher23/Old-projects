/** 
 * Ticket class implements from DataHandler interface to provide the methods to get info from 
 * classes and FileHandler data
 * it is an aggregation of the Customer class
 */ 
public class Ticket implements DataHandler {

	private Customer customer;
	private String createdAt;
	private String ticketID;
	
	// ticket constructor 
	public Ticket(Customer customer,String createdAt,String ticketID) {
		
		this.setCustomer(customer);
		this.setCreatedAt(createdAt);
		this.setTicketID(ticketID); 
		
	}

	// getter and setters for ticket
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getTicketID() {
		return ticketID;
	}

	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}

	/** 
     * Overrided from DataHandler interface used to retrieve data in both ticket and customer class
     * @return String tickout
     */
	
	@Override
	public String getInfo() {
		String tickout = "";
		tickout = customer.getInfo() + " "+"Created At: " + getCreatedAt()+ " "+"Ticket Id: "+getTicketID();
		
		//customer.getInfo() + " " + getCreatedAt()+ " "+getTicketID();
		return tickout;
	}

	/** 
     * Overrided from DataHandler interface used to retrieve data in FileHandler 
     * to print Ticket and Customer file data.
     * @return String fileOut
     */
	
	@Override
	public String getFileData() {
		String fileOut = "";
		fileOut = customer.getFileData()+","+getTicketID()+","+getCreatedAt();
				
		return fileOut;
	}
}
