package com.fhirio.fhiremsservice.domain;

import java.util.List;

public class Conditions {
	private List<Condition> conditions;

	public Conditions() {}

	public Conditions(List<Condition> conditions) {
		super();
		this.conditions = conditions;
	}
	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}
	
}
