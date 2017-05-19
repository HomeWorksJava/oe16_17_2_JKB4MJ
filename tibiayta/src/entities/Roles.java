package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6688685043196361243L;
	
	private int roleId;
	@Id
	private String userName;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return userName;
	}
	public void setUserId(String userName) {
		this.userName = userName;
	}
	
	

}
