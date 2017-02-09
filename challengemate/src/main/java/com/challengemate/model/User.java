package com.challengemate.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "fbuserid", nullable = false)
	private String fbuserid;

	@Column(name = "mobile")
	private Long mobile;

	@Column(name = "email")
	private String email;

	@Column(name = "dob")
	private String dateOfBirth;

	@Column(name = "name")
	private String name;

	@Column(name = "profilepic")
	private String profilePic;

	@Column(name = "datetime")
	private String dateTime;

	public User() {
	}

	public User(String fbuserid, Long mobile, String email, String dateOfBirth, String name, String profilePic,
			String dateTime) {
		super();
		this.fbuserid = fbuserid;
		this.mobile = mobile;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.name = name;
		this.profilePic = profilePic;
		this.dateTime = dateTime;
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

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
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

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		String s = "fbuserid:" + fbuserid + ", mobile: " + mobile + ", email: " + email + ", dateOfBirth: "
				+ dateOfBirth + ", name: " + name + ", profilePic: " + profilePic + ", dateTime: " + dateTime;
		return s;
	}
}