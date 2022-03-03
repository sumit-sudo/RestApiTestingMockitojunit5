package com.sumit.restapi.mockito;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestApiIntegrationTesting {

	@Autowired
	private TestRestTemplate restTemplate;
		
	@Test
	public void contextLoads() throws JSONException {	
		
		String response = this.restTemplate.getForObject("/get_items", String.class);
		
		JSONAssert.assertEquals("[{id:101}]", 
				response, false);
	}

	
}
