package com.brightcoding.app.ws.shared.dto;



import com.brightcoding.app.ws.entities.CondidatEntity;

public class AddressDto {
private long id;
	
	
	private String addressId;
	private String city;
	private String country="aceje";
	private String street;
	private String postal;
	private String type;
	private CondidatEntity user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUser(ResourceDto resourceDto) {
		// TODO Auto-generated method stub
		
	}

	
	

}