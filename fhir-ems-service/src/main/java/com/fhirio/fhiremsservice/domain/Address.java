/**
 * Copyright 2017, FHIR I/O - OMSCS CS6440 - Fall 2017 Georgia Tech 
 */
package com.fhirio.fhiremsservice.domain;

/**
 * @author Team FHIR I/O
 *
 */
public class Address {
	
	public Address(){};
	
	public Address(String addressLine, String city, String state,
			String country, String zip) {
		super();
		this.addressLine = addressLine;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}
	/**
	 * Properties
	 */

	public String addressLine;
	public String city;
	public String state;
	public String country;
	public String zip;
	
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
}
