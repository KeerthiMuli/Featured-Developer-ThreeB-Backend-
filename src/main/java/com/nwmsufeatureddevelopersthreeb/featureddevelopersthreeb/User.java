package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public")
public class User {
	@Column(name = "id")
	@Id 
	@SequenceGenerator(name = "user-seq",sequenceName = "users_id_seq",allocationSize = 1)
	@GeneratedValue( strategy = GenerationType.SEQUENCE,generator = "user-seq")
	private  long id;
	@Column(name = "username")
	private @NotBlank String username;
	@Column(name = "password")
	private @NotBlank String password;
	@Column(name = "loggedin")
	private @NotBlank boolean loggedIn;
    

	public User() {
	}

	public User(@NotBlank String username, @NotBlank String password, String resetToken) {
		this.username = username;
		this.password = password;
		this.loggedIn = false;
		
	}

	public long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof User))
			return false;
		User user = (User) o;
		return Objects.equals(username, user.username) && Objects.equals(password, user.password);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, password, loggedIn);
	}

	@Override
	public String toString() {
		return ( "id=" + id + ", username=" + username +", password=" + password +
				 ", loggedIn=" + loggedIn);
	}
}
