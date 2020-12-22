package com.app.ecom.order.model;

public class Address {
	
	private String id;
	private String email;
	private String  name;
	private String  pincode;
	private String  address;
	private String  landmark;
	private String  country;
	private String  phone;
	private String flatdetails; 
	@Override
	public String toString() {
		return "Address [id=" + id + ", email=" + email + ", name=" + name + ", pincode=" + pincode + ", address="
				+ address + ", landmark=" + landmark + ", country=" + country + ", phone=" + phone + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFlatdetails() {
		return flatdetails;
	}
	public void setFlatdetails(String flatdetails) {
		this.flatdetails = flatdetails;
	}

	

}
