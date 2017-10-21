package com.fhirio.fhiremsservice.domain;

/**
 * Represents the possible states of an emergency.
 */
public enum EmergencyState {
	/**
	 * The Emergency has not been picked up by emergency personnel.
	 */
	PENDING,
	
	/**
	 * The Emergency is actively being worked on.
	 */
	ACTIVE,
	
	/**
	 * The Emergency is no longer active. The patient is at the hospital.
	 */
	CLOSED
}
