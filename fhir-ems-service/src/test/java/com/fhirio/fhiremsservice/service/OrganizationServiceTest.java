package com.fhirio.fhiremsservice.service;

import org.junit.*;
import org.junit.runner.*;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fhirio.fhiremsservice.domain.Emergency;
import com.fhirio.fhiremsservice.domain.Organization;
import com.fhirio.fhiremsservice.domain.User;

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
		org.setPendingEmergencyIds(Arrays.asList(Integer.valueOf(1),Integer.valueOf(2)));
		org.setActiveEmergencyIds(Arrays.asList(Integer.valueOf(3)));
		org.setClosedEmergencyIds(Arrays.asList(Integer.valueOf(4),Integer.valueOf(5)));
		organizationMap.put(Integer.valueOf(1), org);
		this.organizationService.setOrganizationMap(organizationMap);
		
	}
	
	@Test
	public void testGetOrganization_organization_exists() {
		Organization org = this.organizationService.getOrganization(1);
		assertThat(org.getActiveEmergencyIds()).isEqualTo(Arrays.asList(3));
	}
	
	@Test
	public void testGetOrganization_organization_does_not_exist() {
		Organization org = this.organizationService.getOrganization(-1);
		assertThat(org).isNull();
	}
	
	@Test
	public void testSaveOrganization_organization_successfully_saves(){
		Organization org = new Organization();
		org.setPendingEmergencyIds(Arrays.asList(Integer.valueOf(1),Integer.valueOf(2)));
		org.setActiveEmergencyIds(Arrays.asList(Integer.valueOf(3)));
		org.setClosedEmergencyIds(Arrays.asList(Integer.valueOf(4),Integer.valueOf(5)));
		
		assertThat(org.getOrganizationUuid()).isNull();
		
		Organization savedOrg = this.organizationService.saveOrganization(org);
		assertThat(savedOrg.getOrganizationUuid()).isNotNull();
		assertThat(this.organizationService.getOrganization(savedOrg.getOrganizationUuid())).isNotNull();
	}

}
