package edu.neu.csye6200.models;

public class Teacher {
	private String name;
	private String phone;
	private String email;
	private int Catagory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCatagory() {
		return Catagory;
	}

	public void setCatagory(int catagory) {
		Catagory = catagory;
	}
}
