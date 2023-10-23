package airlinesreservationsystem;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.io.*;

public class Airlinesreservation {
	
 	PassengerDetails pd = new PassengerDetails();
	int seats ;												//to store all the seats in a particular flight
	int classtype;											//to store the class type like Economy Class or Business Class
	double price;											//to store the price of selected seat/seats
	int selseat; 											//to store the seat/seats the user choose
	String date,status;										//to store the type of class given by the user
	int fname;												//to store the flight name
	String source;											//to store the source location
	String des;												//to store the destination location
	ArrayList<Integer> seatconfirmed = new ArrayList<>();   //To store the seat/seats the user gives as input
	Scanner sc = new Scanner(System.in);
	
	//TreeMap to store different flight name with flight number and flight name
	TreeMap<Integer, String> flight = new TreeMap<Integer,String>();			
	
	//TreeMap to store different flight class like Economy Class and Business Class
	TreeMap<Integer, String> indigo = new TreeMap<Integer,String>(); 
	TreeMap<Integer, String> airindia = new TreeMap<Integer,String>();
	TreeMap<Integer, String> spicejet = new TreeMap<Integer,String>();
	TreeMap<Integer, String> gofirst = new TreeMap<Integer,String>();
	TreeMap<Integer, String> emirates = new TreeMap<Integer,String>();
	
	/*flightdetail() method does operations like flight name selection, seats selection, class type selection, source and destination locations and date*/
	
	void flightdetail() {
		
		flight.put(1, "IndiGo");
		flight.put(2, "Air India");
		flight.put(3, "SpiceJet");
		flight.put(4, "Go First");
		flight.put(5, "Emirates Air");
		
		
		//Indigo
		indigo.put(1, "Economy Class");
		indigo.put(2, "Business Class");
		TreeMap<Integer,Integer> indigoeconomy = new TreeMap<>(); 
		TreeMap<Integer, Integer> indigobusiness = new TreeMap<>();
		for(int i=1; i<=50; i++) {
			indigoeconomy.put(i,i);
			}
		for(int i =1; i<=25; i++) {
			indigobusiness.put(i,i);
		}
		
		
		
		//AirIndia
		airindia.put(1, "Economy Class");
		airindia.put(2, "Business Class");
		TreeMap<Integer,Integer> airindiaeconomy = new TreeMap<>(); 
		TreeMap<Integer,Integer> airindiabusiness = new TreeMap<>();
		for(int i=1; i<=50; i++) {
			airindiaeconomy.put(i,i);
			}
		for(int i =1; i<=25; i++) {
			airindiabusiness.put(i,i);
		}
		
		
		
		//SpiceJet
		spicejet.put(1, "Economy Class");
		spicejet.put(2, "Business Class");
		TreeMap<Integer, Integer> spicejeteconomy = new TreeMap<>(); 
		TreeMap<Integer, Integer> spicejetbusiness = new TreeMap<>();
		for(int i=1; i<=50; i++) {
			spicejeteconomy.put(i,i);
			}
		for(int i =1; i<=25; i++) {
			spicejetbusiness.put(i,i);
		}
		
		
		
		//Gofirst
		gofirst.put(1, "Economy Class");
		gofirst.put(2, "Business Class");
		TreeMap<Integer, Integer> gofirsteconomy = new TreeMap<>(); 
		TreeMap<Integer, Integer> gofirstbusiness = new TreeMap<>();
		for(int i=1; i<=50; i++) {
			gofirsteconomy.put(i,i);
			}
		for(int i =1; i<=25; i++) {
			gofirstbusiness.put(i,i);
		}
		
		
		
		//Emirates
		emirates.put(1, "Economy Class");
		emirates.put(2, "Business Class");
		TreeMap<Integer, Integer> emirateseconomy = new TreeMap<>(); 
		TreeMap<Integer, Integer> emiratesbusiness = new TreeMap<>();
		for(int i=1; i<=50; i++) {
			emirateseconomy.put(i,i);
			}
		for(int i =1; i<=25; i++) {
			emiratesbusiness.put(i,i);
		}
		System.out.println("---------------------WELCOME TO AIRLINE BOOKING SYSTEM---------------------------");
		System.out.println("\nEnter the Flight you want to travel");
		
		for(Map.Entry m : flight.entrySet()) {
			System.out.println(m.getKey()+") "+m.getValue());
		}
		
		fname=sc.nextInt();
		while(!flight.containsKey(fname)) {
		System.out.println("Sorry we don't have that flight\nEnter the flight again ");
		fname = sc.nextInt();
		}
		System.out.print("Enter the date in (dd/mm/yyyy) format ->");
		date=sc.nextLine();
		while((!date.matches("\\d{2}/\\d{2}/\\d{4}"))) {
			System.out.println("Enter the date correctly");
			date=sc.nextLine();
		}
		
		System.out.println("Enter the source :");
		source = sc.nextLine();
		while((!source.matches("[a-zA-Z\s]+"))){
			System.out.println("Please enter the location correctly ");
			source = sc.nextLine();
		}
		
		System.out.println("Enter the destination :");
		des = sc.nextLine();
		while((!des.matches("[a-zA-Z\s]+"))){
			System.out.println("Please enter the location correctly ");
			des = sc.nextLine();
		}
		
		
		seats = pd.person();
		
		switch(fname) {
		
		case 1:
			while(true) {
				System.out.println("\nEnter the type of class :\n1)Economy Class \n2)Business class ");
				classtype=sc.nextInt();
				if(!indigo.containsKey(classtype)) {
					System.out.println("Please enter a valid class");
				}
				else{
					break;
				}
			}
			
			if(classtype==1) {
				for(int i =0; i<seats;i++) {
				
					for(Map.Entry m : indigoeconomy.entrySet() ) {
						System.out.print("|"+m.getKey());
					}
					System.out.println("\nEnter the seat you want to allocate :");
					selseat=sc.nextInt();
					while(true) {
					if(indigoeconomy.containsKey(selseat)) {
					seatconfirmed.add(selseat);
					indigoeconomy.remove(selseat);
					break;
					}
					else {
						System.out.println("The seat is not available");
						for(Map.Entry m : indigoeconomy.entrySet() ) {
							System.out.print("|"+m.getKey());
						}
						System.out.println("\nEnter the seat you want to allocate :");
						selseat=sc.nextInt();
					}	
				}
				}
				price = 1400*seats;
				this.bill();
				
			}
			else if(classtype==2) {
				for(int i =0; i<seats;i++) {
					
					for(Map.Entry m : indigobusiness.entrySet() ) {
						System.out.print("|"+m.getKey());
					}
					System.out.println("\nEnter the seat you want to allocate :");
					selseat=sc.nextInt();
					while(true) {
					if(indigobusiness.containsKey(selseat)) {
					seatconfirmed.add(selseat);
					indigobusiness.remove(selseat);
					break;
					}
					else {
						System.out.println("The seat is not available");
						for(Map.Entry m : indigobusiness.entrySet() ) {
							System.out.print("|"+m.getKey());
						}
						System.out.println("\nEnter the seat you want to allocate :");
						selseat=sc.nextInt();
					}
				}
				}	
				price = 4500*seats;
				this.bill();
				
			}
			else {
				System.out.println("Sorry we don't have any class of that type\n Please login again !");
			}
			break;
			
		case 2:
			while(true) {
				System.out.println("\nEnter the type of class :\n1)Economy Class \n2)Business class ");
				classtype=sc.nextInt();
				if(!airindia.containsKey(classtype)) {
					System.out.println("Please enter a valid class");
				}
				else{
					break;
				}
			}
			
			if(classtype==1) {
				for(int i =0; i<seats;i++) {
					
					for(Map.Entry m : airindiaeconomy.entrySet() ) {
						System.out.print("|"+m.getKey());
					}
					System.out.println("\nEnter the seat you want to allocate :");
					selseat=sc.nextInt();
					while(true) {
					if(airindiaeconomy.containsKey(selseat)) {
					seatconfirmed.add(selseat);
					airindiaeconomy.remove(selseat);
					break;
					}
					else {
						System.out.println("The seat is not available");
						for(Map.Entry m : airindiaeconomy.entrySet() ) {
							System.out.print("|"+m.getKey());
						}
						System.out.println("\nEnter the seat you want to allocate :");
						selseat=sc.nextInt();
						
					}	
				}
				}
				price = 2100*seats;
				this.bill();
			}
			else if(classtype==2) {
				for(int i =0; i<seats;i++) {
					
					for(Map.Entry m : airindiabusiness.entrySet() ) {
						System.out.print("|"+m.getKey());
					}
					System.out.println("\nEnter the seat you want to allocate :");
					selseat=sc.nextInt();
					while(true) {
					if(airindiabusiness.containsKey(selseat)) {
					seatconfirmed.add(selseat);
					airindiabusiness.remove(selseat);
					break;
					}
					else {
						System.out.println("The seat is not available");
						for(Map.Entry m : airindiabusiness.entrySet() ) {
							System.out.print("|"+m.getKey());
						}
						System.out.println("\nEnter the seat you want to allocate :");
						selseat=sc.nextInt();
					}
					}
				}
				price=4200*seats;
				this.bill();
			}
			else {
				System.out.println("Sorry we don't have any class of that type\nPlease login again");
			}
			break;
			
		case 3:
			while(true) {
				System.out.println("\nEnter the type of class :\n1)Economy Class \n2)Business class ");
				classtype=sc.nextInt();
				if(!indigo.containsKey(classtype)) {
					System.out.println("Please enter a valid class");
				}
				else{
					break;
				}
			}

			if(classtype==1) {
				for(int i =0; i<seats;i++) {
					
					for(Map.Entry m : spicejeteconomy.entrySet() ) {
						System.out.print("|"+m.getKey());
					}
					System.out.println("\nEnter the seat you want to allocate :");
					selseat=sc.nextInt();
					while(true) {
					if(spicejeteconomy.containsKey(selseat)) {
					seatconfirmed.add(selseat);
					spicejeteconomy.remove(selseat);
					break;
					}
					else {
						System.out.println("The seat is not available");
						for(Map.Entry m : spicejeteconomy.entrySet() ) {
							System.out.print("|"+m.getKey());
						}
						System.out.println("\nEnter the seat you want to allocate :");
						selseat=sc.nextInt();
					}
					}
				}
				price = 2400*seats;
				this.bill();
			}
			else if(classtype==2) {
				for(int i =0; i<seats;i++) {
					
					for(Map.Entry m : spicejetbusiness.entrySet() ) {
						System.out.print("|"+m.getKey());
					}
					System.out.println("\nEnter the seat you want to allocate :");
					selseat=sc.nextInt();
					while(true) {
					if(spicejetbusiness.containsKey(selseat)) {
					seatconfirmed.add(selseat);
					spicejetbusiness.remove(selseat);
					break;
					}
					else {
						System.out.println("The seat is not available");
						for(Map.Entry m : spicejetbusiness.entrySet() ) {
							System.out.print("|"+m.getKey());
						}
						System.out.println("\nEnter the seat you want to allocate :");
						selseat=sc.nextInt();
					}
					}
				}
				price = 5000*seats;
				this.bill();
			}
			else {
				System.out.println("Sorry we don't have any class of that type\nPlease login again !");
			}
			break;
			
		case 4:
			while(true) {
				System.out.println("\nEnter the type of class :\n1)Economy Class \n2)Business class ");
				classtype=sc.nextInt();
				if(!indigo.containsKey(classtype)) {
					System.out.println("Please enter a valid class");
				}
				else{
					break;
				}
			}
			
			if(classtype==1) {
				for(int i =0; i<seats;i++) {
					
					for(Map.Entry m : gofirsteconomy.entrySet() ) {
						System.out.print("|"+m.getKey());
					}
					System.out.println("\nEnter the seat you want to allocate :");
					selseat=sc.nextInt();
					while(true) {
					if(gofirsteconomy.containsKey(selseat)) {
					seatconfirmed.add(selseat);
					gofirsteconomy.remove(selseat);
					break;
					}
					else {
						System.out.println("The seat is not available");
						for(Map.Entry m : gofirsteconomy.entrySet() ) {
							System.out.print("|"+m.getKey());
						}
						System.out.println("\nEnter the seat you want to allocate :");
						selseat=sc.nextInt();
					}
					}
				}
			price = 1800*seats;
			this.bill();
			}
			else if(classtype==2) {
				for(int i =0; i<seats;i++) {
					
					for(Map.Entry m : gofirstbusiness.entrySet() ) {
						System.out.print("|"+m.getKey());
					}
					System.out.println("\nEnter the seat you want to allocate :");
					selseat=sc.nextInt();
					while(true) {
					if(gofirstbusiness.containsKey(selseat)) {
					
					seatconfirmed.add(selseat);
					gofirstbusiness.remove(selseat);
					break;
					}
					else {
						System.out.println("The seat is not available");
						for(Map.Entry m : gofirstbusiness.entrySet() ) {
							System.out.print("|"+m.getKey());
						}
						System.out.println("\nEnter the seat you want to allocate :");
						selseat=sc.nextInt();
					}
					}
				}
			price = 3200*seats;
			this.bill();
			}
			else {
				System.out.println("Sorry we don't have any class of that type\nPlease Login again !");
			}
			break;
			
		case 5:
			while(true) {
				System.out.println("\nEnter the type of class :\n1)Economy Class \n2)Business class ");
				classtype=sc.nextInt();
				if(!indigo.containsKey(classtype)) {
					System.out.println("Please enter a valid class");
				}
				else{
					break;
				}
			}
			if(classtype==1) {
				for(int i =0; i<seats;i++) {
					
					for(Map.Entry m : emirateseconomy.entrySet() ) {
						System.out.print("|"+m.getKey());
					}
					System.out.println("\nEnter the seat you want to allocate :");
					selseat=sc.nextInt();
					while(true) {
					if(emirateseconomy.containsKey(selseat)) {
					
					seatconfirmed.add(selseat);
					emirateseconomy.remove(selseat);
					break;
					}
					else {
						System.out.println("The seat is not available");
						for(Map.Entry m : emirateseconomy.entrySet() ) {
							System.out.print("|"+m.getKey());
						}
						System.out.println("\nEnter the seat you want to allocate :");
						selseat=sc.nextInt();
					}
					}
				}
				price = 4500*seats;
				this.bill();
			}
			else if(classtype==2) {
				for(int i =0; i<seats;i++) {
					
					for(Map.Entry m : emiratesbusiness.entrySet() ) {
						System.out.print("|"+m.getKey());
					}
					System.out.println("\nEnter the seat you want to allocate :");
					selseat=sc.nextInt();
					while(true) {
					if(emiratesbusiness.containsKey(selseat)) {
					
						seatconfirmed.add(selseat);
						emiratesbusiness.remove(selseat);
						break;
					}
					else {
						System.out.println("The seat is not available");
						for(Map.Entry m : emiratesbusiness.entrySet() ) {
							System.out.print("|"+m.getKey());
						}
						System.out.println("\nEnter the seat is not available :");
						selseat=sc.nextInt();
					}
					}
				}
				price = 12000*seats;
				this.bill();
			}
			else {
				System.out.println("Sorry we don't have any class of that type\nPlease Login again !");
			}
			break;
			default:
			{
				System.out.println("We don't have any flight of that type \n Please login again !");		
				break;
			}
		}
	}
	
	/*bill() method calculate and generates the bill stores it in a .txt file*/
	
	void bill(){
		double bill=0;
		double dis=0;
		
		LocalTime time = LocalTime.now();
		LocalDate date = LocalDate.now();
		
		if(seats==1) {
			dis = 0;
		}
		else if(seats==2){
			dis = (0.2*price);
		}
		else if(seats==3) {
			dis = (0.35*price);
		}
		else if(seats>4) {
			dis = (0.5*price);
		}
		bill = price - dis;
		if(classtype==1) {
			status = "Economy Class";
		}
		else {
			status = "Business Class";
		}
		try {
		File file = new File("C:\\Users\\d1\\eclipse-workspace\\cohesion\\src\\airlinesreservationsystem\\Receipt\\Flight Ticket.txt");
		FileWriter write = new FileWriter(file);
		write.write("__________________________________________________________________________________________________________________\n");
		write.append("\n\t\t\tTicket Booking Successfull\n\n");
		write.append("\nFlight name :"+flight.get(fname));
		write.append("\nClass Type :"+status);
		for(Passenger val : pd.peron) {
			write.append("\n______________________________________________________________________________________________________________\n");
			write.append("Name :"+val.getName()+"\nID :"+val.getId()+"\nAge :"+val.getAges()+"\nContact No :"+val.getPhones());
			write.append("\n______________________________________________________________________________________________________________\n");
		}
		write.append("Tickets numbers are :"+seatconfirmed);
		write.append("\nDate of Journey :"+date);
		write.append("\n"+source+"\t------>\t\t"+des);
		write.append("\n\nOriginal price -> "+price );
		write.append("\nDiscount -> "+dis);
		write.append("\nPrice after Discount -> "+bill);
		write.append("\nCurrent Date : "+date+"\tCurrent Time : "+time);
		write.close();
		System.out.println("Ticket generated Successfully !");
		
		}
		catch(IOException e) {
			System.out.println("Sorry println slip can't be created");
		}
		sc.nextLine();
		Billprint print = new Billprint();
		print.print();
	}
}
	