package airlinesreservationsystem;

import java.util.ArrayList;
import java.util.*;
public class PassengerDetails {
	  
	ArrayList<Passenger> peron;
	public int person() {
		 
		peron = new ArrayList<>();
		 Scanner sc = new Scanner(System.in);
		 
		 int seats = 0;
		 String name;
		 String id;
		 int age =0;
		 String num;
		 
		 do {
				try {
				System.out.println("Enter the number of persons :");
				seats = sc.nextInt();
				if(seats>0) {
					break;
				}
				}
			catch(Exception e) {
				System.out.println("Enter the number of person in numeric only");
				sc.nextLine();
			}
			}while(true);
		 
		 sc.nextLine();
		 for(int i=1; i<=seats; i++) { 
			System.out.println("Enter name of Passenger "+i+" :");
			name = sc.nextLine();
			while((!name.matches("[a-zA-Z\s]+"))) {
				System.out.println("Enter the name is alphabet only");
				name=sc.nextLine();
			}
			
			System.out.println("Enter id of Passenger "+i+" :");
			id = sc.nextLine();
			while((!id.matches("[a-zA-Z0-9]+"))) {
				System.out.println("Enter the id in alphanumeric only");
				id=sc.nextLine();
			}
			
			do {
				try {
				System.out.println("Enter age of Passenger "+i+" :");
				age = sc.nextInt();
				if(age>0) {
					break;
				}
				}
			catch(Exception e) {
				System.out.println("Enter the age in numeric only");
				sc.nextLine();
			}
			}while(true);
			sc.nextLine();
			
			System.out.println("Enter contact no of Passenger "+i+" :");
			num = sc.nextLine();
			while((!num.matches("[0-9]{10}+"))) {
				System.out.println("Please enter the phone number in digits only and phone number should be 10 digits");
					num = sc.nextLine();
				}
			
			Passenger p = new Passenger(name, id, age, num);
			peron.add(p);
		 }
		return seats;
	}
}
