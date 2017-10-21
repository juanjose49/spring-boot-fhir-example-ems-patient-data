package com.fhirio.fhiremsservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fhirio.fhiremsservice.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	@Autowired
	private UserService userService;
	
	@Before
	public void setup(){
		HashMap<Integer, User> userMap = new HashMap<>();
		//bootstrap users
		userMap.put(Integer.valueOf(1), new User(1, "emspersonnel", "John", "Smith", 1));
		userMap.put(Integer.valueOf(2), new User(2, "emscallcenter", "Jane", "Smith", 1));
		this.userService.setUserMap(userMap);
		
	}
	
	@Test
	public void testGetUser_user_is_available(){
		User user = this.userService.getUser(2);
		assertThat(user).isNotNull();
		assertThat(user.getUserName()).isEqualTo("emscallcenter");
	}
	
	@Test
	public void testGetUser_user_is_not_available(){
		User user = this.userService.getUser(-1);
		assertThat(user).isNull();
	}

}
