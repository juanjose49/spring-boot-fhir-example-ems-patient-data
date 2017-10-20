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
import com.fhirio.fhiremsservice.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmergencyServiceTest {
	@Autowired
	private EmergencyService emergencyService;
	@Before
	public void setup(){
		Map<Integer, Emergency> emergencyMap = new HashMap<>();

		Emergency emergency = new Emergency(Integer.valueOf(1),"Student Fainted in Class","1122 Fowler St. 30309",Arrays.asList(1,2));
		emergencyMap.put(Integer.valueOf(1), emergency);
		
		emergency = new Emergency(Integer.valueOf(2),"Car Accident on I85","I85 between exits 89 and 91",Arrays.asList(3,4));
		emergencyMap.put(Integer.valueOf(2), emergency);
		
		emergency = new Emergency(Integer.valueOf(3),"Man had Heart Attack in Restaurant","Subway on Georgia Tech Campus",Arrays.asList(5,6));
		emergencyMap.put(Integer.valueOf(3), emergency);
		
		emergency = new Emergency(Integer.valueOf(4),"Dog bit Man in Neighborhood","2022 Happy Hills 30456",Arrays.asList(7,8));
		emergencyMap.put(Integer.valueOf(4), emergency);
		
		emergency = new Emergency(Integer.valueOf(5),"Alcohol Poisoning at PIKE Fraternity","3212 Notso Happy Hills 30213",Arrays.asList(9,10));
		emergencyMap.put(Integer.valueOf(5), emergency);
		this.emergencyService.setEmergencyMap(emergencyMap);
	}
	
	@Test
	public void testGetEmergency_emergency_uuid_is_valid() {
		Emergency emergency = this.emergencyService.getEmergency(3);
		assertThat(emergency.getEmergencyTitle()).isEqualTo("Man had Heart Attack in Restaurant");
	}
	
	@Test
	public void testGetEmergency_emergency_uuid_is_not_valid() {
		Emergency emergency = this.emergencyService.getEmergency(-1);
		assertThat(emergency).isNull();
	}

}
