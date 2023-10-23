package airlinesreservationsystem;

import java.io.*;
import java.util.*;

public class Billprint {
	void print() {
		Scanner sc = new Scanner(System.in);
	try {
		System.out.println("\n\nEnter 1 to print the ticket or any other key to exit");
		String print = sc.nextLine();
		if(print.matches("1")) {
		File file = new File("C:\\Users\\d1\\eclipse-workspace\\cohesion\\src\\airlinesreservationsystem\\Receipt\\Flight Ticket.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String read;
		while((read = br.readLine()) != null)
			System.out.println(read);
	}
	}
	catch(Exception e) {
		System.out.println("\n\nThere was an error in printing the ticket\nPlease check the file path");
		
	}
	}


}
