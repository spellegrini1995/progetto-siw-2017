package it.uniroma3.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String nickname;
	@Column(nullable = false)
	private String password;
	
	public Administrator() {
	}	

	public Administrator(String firstName, String lastName, String nickname, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.password = password;
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

	public String getNickname() {
		return this.nickname;
	}
	
	public void setNickname(String nick) {
		this.nickname = nick;
	}
	
	public boolean equals(Object obj) {
        Administrator administrator = (Administrator)obj;
        return this.getNickname().equals(administrator.getNickname());
    }

    public int hashCode() {
         return this.getNickname().hashCode();
    }

	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
}