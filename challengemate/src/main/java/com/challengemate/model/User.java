package com.challengemate.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String fbuserid;
	private Long mobile;
	private String email;
	private LocalDate dateOfBirth;
	private String name;
	private String profilePic;
	private LocalDateTime dateTime;

	public User() {
	}

	public User(Long id, String fbuserid, Long mobile, String email, LocalDate dateOfBirth, String name,
			String profilePic, LocalDateTime dateTime) {
		super();
		this.id = id;
		this.fbuserid = fbuserid;
		this.mobile = mobile;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.name = name;
		this.profilePic = profilePic;
		this.dateTime = dateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFbuserid() {
		return fbuserid;
	}

	public void setFbuserid(String fbuserid) {
		this.fbuserid = fbuserid;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/*public String toString() {
	String s = "id:" + id + ", name: " + name;
	return s;
	}*/
}