package com.fhirio.fhiremsservice.domain;

public class Token {
	private Integer token;

	public Token(){}
	
	public Token(Integer token) {
		super();
		this.token = token;
	}

	public Integer getToken() {
		return token;
	}

	public void setToken(Integer token) {
		this.token = token;
	}
	
}
