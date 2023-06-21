import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * FileHandler class handles the files.
 * Reads and formats employee and ticket data csv's 
 * Writes both log.txt and workorder.csv
 * 
 */

public class FileHandler {
	// logger is only used in logger method
	private Scanner scan;
	private BufferedWriter writer;
	private File loggerFile; 

	// constructor
	public FileHandler() {
		scan = new Scanner(System.in);
		loggerFile = new File("log.txt");
		try {
			writer = new BufferedWriter(new FileWriter(loggerFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes data to CSV and log.txt
	 * 
	 * @param workOrderFileName this should go with the workOrderList ArrayList
	 * @return none
	 */

	public void writeData(String workOrderFileName) {
		// creating file 
		File workOrderFile = new File(workOrderFileName);
		try {
			// writing to file
			BufferedWriter wrkOrderWriter = new BufferedWriter(new FileWriter(workOrderFile));

			wrkOrderWriter.write(
					"employee_id,employee_first_name,employee_last_name,clocked_in,customer_id,customer_first_name,customer_last_name,ticket_id,ticket_createdAt,workorder_createdAt\n");
			// loops though work order array list 
			for (WorkOrder anOrder : Project3.workOrderList) {
				// writing to work order csv file
				String csvLine = anOrder.getFileData();

				// writing to log.txt format
				String logLine = anOrder.getInfo();
				
				// calling and printing 
				logger(logLine);
				wrkOrderWriter.write(csvLine + "\n");

			}
			// closes buffered writer 
			wrkOrderWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Reads employee data
	 * 
	 * @param employeeFileName this should go with the employeeList ArrayList
	 * @return none
	 */

	public void readEmployeeData(String employeeFileName) {
		// creates file to read employee 
		File file = new File(employeeFileName);
		Scanner employeeReader;
		String junk;
		try {
			employeeReader = new Scanner(file);
			if (employeeReader.hasNext()) {
				junk = employeeReader.nextLine(); // eliminates first line of csv!!!
			}
			while (employeeReader.hasNext()) {
				String aLine = employeeReader.nextLine();
				String[] fields = aLine.split(",");
		// my fields is all out of sort due to my super class containing first name as the first vari and whats presented in the csv for employee 
				Employee anEmployee = new Employee(fields[1], fields[2], fields[4], fields[5], fields[3], fields[0],
						fields[6], fields[7]);
				// adds to the array list set in main 
				Project3.employeeList.add(anEmployee);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Reads ticket data
	 * 
	 * @param ticketFileName this should go with the ticketList ArrayList
	 * @return none
	 */

	public void readTicketData(String ticketFileName) {
		File file = new File(ticketFileName);
		Scanner ticketReader;
		String junk;
		try {
			ticketReader = new Scanner(file);
			if (ticketReader.hasNext()) {
				junk = ticketReader.nextLine(); // eliminates first line
			}
			while (ticketReader.hasNext()) {
				String aLine = ticketReader.nextLine();
				String[] fields = aLine.split(",");
				// same issue that I declared in employee but you have to make customer for ticket to run
				Customer aCustomer = new Customer(fields[1], fields[2], fields[4], fields[5], fields[3], fields[0],
						fields[6]);
				// creating ticket 
				Ticket aTicket = new Ticket(aCustomer, fields[8], fields[7]);
				// adding to array list for ticket set in main 
				Project3.ticketList.add(aTicket);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * logs information to log.txt but only adds the date and time feature 
	 * 
	 * @param log the string
	 * @return none
	 */
	public void logger(String log) {
		
		// only 
		try {
			SimpleDateFormat dnt = new SimpleDateFormat("MM/dd/yy HH:mm:ss:");
			Date date = new Date();
			writer.write(dnt.format(date) + " " + log + "\n");
			// flushes stream
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
