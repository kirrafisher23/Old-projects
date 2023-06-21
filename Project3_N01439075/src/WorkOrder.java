/** 
 * WorkOrder class implements from DataHandler interface to provide the methods to get info from 
 * classes and FileHandler data 
 * it is an aggregation of  the Employee class 
 */ 
public class WorkOrder implements DataHandler {

	private Employee employee;
	private Ticket ticket;
	private String createdAt;
	
	// constructor for WorkOrder
	public WorkOrder(Employee employee,Ticket ticket,String createdAt) {
		
		this.setEmployee(employee);
		this.setTicket(ticket);
		this.setCreatedAt(createdAt);
		
	}

	// getters and setters for WorkOrder
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	/** 
     * Overrided from DataHandler interface used to retrieve data in both employee and ticket class 
     * @return String workout
     */

	@Override
	public String getInfo() {
		String workout = "";
		workout = employee.getInfo() + " " + ticket.getInfo() +" "+"Created At: "+ getCreatedAt();
		
		return workout;
	}

	/** 
     * Overrided from DataHandler interface used to retrieve data from file data in FileHandler workOrderList
     * @return String fileOut 
     */
	@Override
	public String getFileData() {
		String fileOut = "";
		fileOut = employee.getFileData()+"," + ticket.getFileData() +","+ getCreatedAt();
				
		return fileOut;
	}
	

}
