package com.honeypotato.userservice;

import com.honeypotato.auth.client.model.AuthProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceApplicationTests {
	@Autowired
	private AuthProperties authProperties;

	@Test
	public void contextLoads() {
		System.out.println(authProperties);
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
