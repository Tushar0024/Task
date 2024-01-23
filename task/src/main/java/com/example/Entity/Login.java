package com.example.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Login")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(nullable = false)
	private String Username;
	@Column(nullable = false)
	private String Password;
	@Column(nullable = false)
	private String EmailID;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	@Override
	public String toString() {
		return "Login [Id=" + Id + ", Username=" + Username + ", Password=" + Password + ", EmailID=" + EmailID + "]";
	}
	
	
}
