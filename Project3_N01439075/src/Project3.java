import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* 
 * Author:    Kirra Fisher 
 * Course:    COP3503 
 * Project #: 3 
 * Title  :   Objects and Classes
 * Due Date:  07/22/2022  
 * 
 * Creates work orders for employees to handle customers.
 */

/**
 * project 3 class. Holds main method to execute print statements from data
 * processing in FileHandler
 */
public class Project3 {

	public static String employeeFileName = "employee_data.csv";
	public static String ticketFileName = "ticket_data.csv";
	public static String workOrderfileName = "workorder_data.csv";
	public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	public static ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
	public static ArrayList<WorkOrder> workOrderList = new ArrayList<WorkOrder>();

	public static void main(String[] args) {

		// reading out from main and logger
		
		System.out.println("Project 3 Work Order Generator");
		System.out.println();
		
		FileHandler fileHandler = new FileHandler();

		System.out.println("Loading Employee Data");

		fileHandler.logger("Loading Employee Data");
		fileHandler.readEmployeeData(employeeFileName);

		System.out.println("Loading Ticket Data");
		fileHandler.logger("Loading Ticket Data");

		fileHandler.readTicketData(ticketFileName);

		System.out.println("Creating Work Orders");
		fileHandler.logger("Creating Work Orders");
		createWorkorders();

		System.out.println("Writing Work Order Data to File");
		fileHandler.logger("Writing Work Order Data to File");

		fileHandler.writeData(workOrderfileName);

		fileHandler.logger("Work Orders Created. Program Exiting");

	}

	/**
	 * Creates work orders from file handler data.
	 * @return none
	 */
	public static void createWorkorders() {

		// there is 100 employees each one of them gets some where around 10 tickets to handle 
		// so for each employee assign ticket id's
		
		//get the number of employees
		int numOfEmployees = employeeList.size();
		int numOfTickets = ticketList.size();
		int numOfJobsPerEmp = (int) Math.round((double)numOfTickets/ numOfEmployees);
		
		//loop to handle each Ticket
		int ticketCount = 0;
		int employeeIndex = 0;

		for(Ticket aTicket : ticketList) {
			ticketCount++;
			
			//creates a timestamp
			SimpleDateFormat dnt = new SimpleDateFormat("MM/dd/yy HH:mm:ss:");
	        Date date = new Date();
	        WorkOrder anOrder = new WorkOrder(employeeList.get(employeeIndex), aTicket, dnt.format(date));
	        workOrderList.add(anOrder);
	        if (ticketCount % numOfJobsPerEmp == 0) {
	        	employeeIndex++;
	        }
		}
	}

}
