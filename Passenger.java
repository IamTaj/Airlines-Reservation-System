package airlinesreservationsystem;
import java.util.ArrayList;

public class Passenger {
	private String name ;
	private String id;
	private int ages;
	private String phones;
	
	public Passenger(String name, String id, int ages, String num) {
		super();
		this.name = name;
		this.id = id;
		this.ages = ages;
		this.phones = num;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAges() {
		return ages;
	}

	public void setAges(int ages) {
		this.ages = ages;
	}

	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
		this.phones = phones;
	}

}
