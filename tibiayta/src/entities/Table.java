package entities;

public class Table {
	
	private int Id;
	private int number;
	private boolean booked = false;
	
	public Table(){};
	
	public Table(int number){
		this.number = number;
	}

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getId() {
		return this.Id;
	}

	public void setId(int number) {
		this.Id = Id;
	}
	
	
	

}
