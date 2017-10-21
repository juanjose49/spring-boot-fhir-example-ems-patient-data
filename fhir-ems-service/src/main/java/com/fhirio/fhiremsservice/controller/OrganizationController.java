package com.fhirio.fhiremsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fhirio.fhiremsservice.domain.Organization;
import com.fhirio.fhiremsservice.service.OrganizationService;

@RestController()
@RequestMapping("/api/organization")
@CrossOrigin(origins = "*")
public class OrganizationController {
	@Autowired
	private OrganizationService organizationService;
	
	/**
	 * E.g. curl -X GET http://localhost:8080/api/organization/1
	 * @param organizationUuid
	 * @return
	 */
	@RequestMapping(value = "/{organizationUuid}", method = RequestMethod.GET)
	public ResponseEntity<Organization> getOrganization(
			@RequestParam(value="verbose", required=false, defaultValue="false") Boolean isVerbose,
			@PathVariable Integer organizationUuid) {
		Organization organization = null;
		if(isVerbose){
			organization = organizationService.getVerboseOrganiation(organizationUuid);
		}else{
			organization = organizationService.getOrganization(organizationUuid);
		}
		if(organization !=null){
			return new ResponseEntity<Organization>(organization, HttpStatus.OK);
		}else{
			return new ResponseEntity<Organization>(organization, HttpStatus.NOT_FOUND);
		}
	}
	
}