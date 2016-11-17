package edu.sjsu.cmpe275.lab2.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;


@Embeddable 

public class Address {
	@Column(name="STREET")
	String street;
	@Column(name="CITY")
    String city;
	@Column(name="STATE")
    String state;
	@Column(name="ZIP_CODE")
    String zip;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	} 

}
