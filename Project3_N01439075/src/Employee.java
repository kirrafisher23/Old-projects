/** 
 * Subclass from person. Holds extra variables specific to the employee class.
 */ 
public class Employee extends Person implements DataHandler {

	private String employeeID;
	private String clockedIn;
	private String hiredDate;
	
	// constructor for Employee
	public Employee(String firstName,String lastName,String address,String phoneNumber,String email,String employeeID,String clockedIn,String hiredDate) {
		
		super(firstName,lastName,address,phoneNumber,email);
		
		this.setEmployeeID(employeeID);
		this.setClockedIn(clockedIn);
		this.setHiredDate(hiredDate);
	}

	// getter and setters for Employee instance variables
	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getClockedIn() {
		return clockedIn;
	}

	public void setClockedIn(String clockedIn) {
		this.clockedIn = clockedIn;
	}

	public String getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(String hiredDate) {
		this.hiredDate = hiredDate;
	}

	/** 
     * Overrided from DataHandler interface used to retrieve data from employee class
     * @return String empout
     */
	
	@Override
	public String getInfo() {
		String empout = "";
		// reads out getInfo for employee 
		empout ="Employee Info: Employee Name: " +getLastName() + "," +getFirstName()+"	Employee ID: "+getEmployeeID()+"	Time Clocked In: "+getClockedIn();
		return empout;
	}
	
	/** 
     * Overrided from DataHandler interface used to retrieve data from file data in FileHandler particularly from the employeeList
     * @return String fileOut
     */

	@Override
	public String getFileData() {
		String fileOut = "";
		// reads datafile info into CSV
		fileOut = getEmployeeID() + "," +getFirstName()+ ","+getLastName()+","+getClockedIn();
		return fileOut;
	}
	
	
	
	
}
