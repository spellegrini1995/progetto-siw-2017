package it.uniroma3.domain.model;


import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import it.uniroma3.domain.criptation.PwdCriptation;

@Entity
public class Administrator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	
	public Administrator() {
	}	

	public Administrator(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = this.encodePassword(password);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public boolean equals(Object obj) {
        Administrator administrator = (Administrator)obj;
        return this.getUsername().equals(administrator.getUsername());
    }

    public int hashCode() {
         return this.getUsername().hashCode();
    }

	public boolean checkPassword(String password) {
		String pwd = this.encodePassword(password);
		return this.password.equals(pwd);
	}
	
	private String encodePassword(String pwd){
		try {
			return PwdCriptation.getEncodedPassword(pwd);
		} catch (NoSuchAlgorithmException e) {
			return pwd;
		}
	}
}