package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRole implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1312454481056805118L;

	@Id
	private int id;
	
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		id = id;
	}
	
	
}
