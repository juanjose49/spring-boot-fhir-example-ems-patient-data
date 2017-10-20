package com.fhirio.fhiremsservice.domain;

public class User {
	private Integer userUuid;
	private String userName;
	private String firstName;
	private String lastName;
	private Integer organizationUuid;
	
	public User(Integer userUuid, String userName, String firstName, String lastName, Integer organizationUuid) {
		super();
		this.userUuid = userUuid;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.organizationUuid = organizationUuid;
	}
	
	public Integer getUserUuid() {
		return userUuid;
	}
	public void setUserUuid(Integer userUuid) {
		this.userUuid = userUuid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public Integer getOrganizationUuid() {
		return organizationUuid;
	}
	public void setOrganizationUuid(Integer organizationUuid) {
		this.organizationUuid = organizationUuid;
	}

}
