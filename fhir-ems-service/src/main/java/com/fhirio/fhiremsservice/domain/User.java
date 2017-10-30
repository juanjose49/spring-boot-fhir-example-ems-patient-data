package com.fhirio.fhiremsservice.domain;

/**
 * The User class corresponds to a specific user of 
 * the application that may be emergency personnel or 
 * call center personnel.
 *
 */
public class User {
	/**
	 * The UUID that corresponds to a specific user.
	 */
	private Integer userUuid;
	
	/**
	 * The username that corresponds to a specific user.
	 */
	private String userName;
	
	/**
	 * The password that corresponds to a specific user. This should only
	 * ever be populated during the creation of a new user.
	 */
	private String password;

	
	/**
	 * The user's first name.
	 */
	private String firstName;
	
	/**
	 * The user's last name.
	 */
	private String lastName;
	
	/**
	 * The UUID that corresponds to the organization that 
	 * the user belongs to.
	 */
	private Integer organizationUuid;
	
	private Organization organization;
	
	
	public User(){}
	
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
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}
