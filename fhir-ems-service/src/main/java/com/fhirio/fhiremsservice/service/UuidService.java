package com.fhirio.fhiremsservice.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UuidService {
	private static Set<Integer> uuidSet = new HashSet<>();
	public static Integer getUuid(){
		Integer uuid = null;
		while(uuid == null || uuidSet.contains(uuid)){
			uuid = UUID.randomUUID().toString().hashCode();
			if(uuid < 0){
				uuid = uuid * -1;
			}
		}
		return uuid;
	}
}
