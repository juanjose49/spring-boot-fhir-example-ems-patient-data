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

import java.util.HashMap;
import java.util.Map;

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
		User user = authenticationService.authenticate("emspersonnel", "password");
		assertThat(user.getUserUuid()).isEqualTo(1);
		verify(userService).getUser(1);

	}
	
	@Test
	public void testAuthentication_user_is_invalid(){
		User user = authenticationService.authenticate("invalidemspersonnel", "password");
		assertThat(user).isNull();
		verify(userService,times(0)).getUser(anyInt());
	}

}
