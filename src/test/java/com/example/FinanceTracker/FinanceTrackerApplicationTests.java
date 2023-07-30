package com.example.FinanceTracker;

import com.example.FinanceTracker.dto.LoginResponseDTO;
import com.example.FinanceTracker.person.PersonRepository;
import com.example.FinanceTracker.person.PersonService;
import com.example.FinanceTracker.security.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class FinanceTrackerApplicationTests {

	@Autowired
	private PersonService personService;

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void encodePass() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("password"));
	}

	@Test
	public void jwtTest() {
		String userName = "derrick";
		String password = "password";

		authenticationService.registerUser(userName, password);
		String token = authenticationService.loginUser(userName, password).getJwt();

		System.out.println(token);
	}

	@Test
	public void userIdTest() {
		String userName = "derrick";
		String password = "password";
		authenticationService.registerUser(userName, password);
		Long user_id = 1L;

		if (personRepository.findByUserId(1L).isPresent()) {
			user_id = user_id + 1L;
		}
		System.out.println(user_id);
	}



	@Test
	void contextLoads() {
	}



}
