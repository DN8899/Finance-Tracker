package com.example.FinanceTracker;

import com.example.FinanceTracker.person.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
class FinanceTrackerApplicationTests {

	@Autowired
	private PersonService personService;
	private TestRestTemplate restTemplate;





	@Test
	void contextLoads() {
	}



}
