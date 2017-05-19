package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation implements Serializable{
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String name;
	private int tableNumber;
	@Temporal(TemporalType.TIMESTAMP)
	private Date reservedFrom;
	@Temporal(TemporalType.TIMESTAMP)
	private Date reservedTo;
	
	private static final long serialVersionUID = 5074210327963212964L;
	
	public Reservation() {};
	
	public Reservation(String name, int tableNumber,Date reservedFrom, Date reservedTo){
		this.name=name;
		this.tableNumber = tableNumber;
		this.reservedFrom = reservedFrom;
		this.reservedTo= reservedTo;
	}
	
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Date getReservedFrom() {
		return reservedFrom;
	}

	public void setReservedFrom(Date reservedFrom) {
		this.reservedFrom = reservedFrom;
	}

	public Date getReservedTo() {
		return reservedTo;
	}

	public void setReservedTo(Date reservedTo) {
		this.reservedTo = reservedTo;
	}

}
