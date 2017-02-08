package com.challengemate.model;

public class User {

	private Long id;
	private String name;

	public User() {
	}

	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String s = "id:" + id + ", name: " + name;
		return s;
	}
}