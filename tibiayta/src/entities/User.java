package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3156100650674463419L;
	@Id
	private String name;
	private String passoword;
	
	public User() {};
	
	public User(String name, String passoword) {
		this.name = name;
		this.passoword = passoword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassowrd() {
		return passoword;
	}

	public void setPassowrd(String passowrd) {
		this.passoword = passowrd;
	}
	
	
	
}
