package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RestaurantTable  implements Serializable{
	
	private static final long serialVersionUID = 3782778817871599217L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private int number;
	private boolean booked = false;
	
	public RestaurantTable(){};
	
	public RestaurantTable(int number){
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
		return this.id;
	}

	public void setId(int number) {
		this.id = id;
	}
	
	
	

}
