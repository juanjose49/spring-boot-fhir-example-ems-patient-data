package com.fhirio.fhiremsservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fhirio.fhiremsservice.domain.Organization;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrganizationServiceTest {
	@Autowired
	private OrganizationService organizationService;
	
	@Before
	public void setup(){
		//setup mock organizationMap
		Map<Integer, Organization> organizationMap = new HashMap<>();
		Organization org = new Organization();
		org.setOrganizationUuid(Integer.valueOf(1));
		org.setEmergencyUuids(Arrays.asList(1,2,3,4,5));
		organizationMap.put(Integer.valueOf(1), org);
		this.organizationService.setOrganizationMap(organizationMap);
		
	}
	
	@Test
	public void testGetOrganization_organization_exists() {
		Organization org = this.organizationService.getOrganization(1);
		assertThat(org.getEmergencyUuids()).isEqualTo(Arrays.asList(1,2,3,4,5));
	}
	
	@Test
	public void testGetOrganization_organization_does_not_exist() {
		Organization org = this.organizationService.getOrganization(-1);
		assertThat(org).isNull();
	}
	
	@Test
	public void testSaveOrganization_organization_successfully_saves(){
		Organization org = new Organization();
		
		assertThat(org.getOrganizationUuid()).isNull();
		
		Organization savedOrg = this.organizationService.saveOrganization(org);
		assertThat(savedOrg.getOrganizationUuid()).isNotNull();
		assertThat(this.organizationService.getOrganization(savedOrg.getOrganizationUuid())).isNotNull();
	}

}
