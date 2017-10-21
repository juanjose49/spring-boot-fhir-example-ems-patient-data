package com.fhirio.fhiremsservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fhirio.fhiremsservice.domain.Authentication;
import com.fhirio.fhiremsservice.domain.Token;
import com.fhirio.fhiremsservice.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationServiceTest {
	@Autowired
	private AuthenticationService authenticationService;
	@MockBean
	private UserService userService;
	
	@Before
	public void setup(){
		// Add mock data to AuthenticationService
		Map<Integer, Integer> authenticationMap = new HashMap<>();
		String userName = "emspersonnel";
		String password = "password";
		authenticationMap.put(Integer.valueOf((userName+password).hashCode()), Integer.valueOf(1));
		userName = "emscallcenter";
		password = "password2";
		authenticationMap.put(Integer.valueOf((userName+password).hashCode()), Integer.valueOf(2));
		authenticationService.setAuthenticationMap(authenticationMap);
		
		// Add mock data to UserService
		given(this.userService.getUser(Integer.valueOf(1))).willReturn(new User(1, "emspersonnel", "John", "Smith", 1));
		given(this.userService.getUser(Integer.valueOf(2))).willReturn(new User(2, "emscallcenter", "Jane", "Smith", 1));
	}
	
	@Test
	public void testAuthentication_user_is_valid() {
		Token token = authenticationService.authenticate(new Authentication("emspersonnel", "password"));
		assertThat(token.getToken()).isEqualTo(1);

	}
	
	@Test
	public void testAuthentication_user_is_invalid(){
		Token token = authenticationService.authenticate(new Authentication("invalidemspersonnel", "password"));
		assertThat(token).isNull();
	}

}
