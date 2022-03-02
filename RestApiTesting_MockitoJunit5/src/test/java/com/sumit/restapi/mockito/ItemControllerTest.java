package com.sumit.restapi.mockito;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.sumit.restapi.mockito.controller.ItemController;
import com.sumit.restapi.mockito.entity.Item;
import com.sumit.restapi.mockito.service.ItemServiceInterface;

//@SpringBootTest(classes= {ItemController.class})

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@InjectMocks
	ItemController controller;
	
	@MockBean
	ItemServiceInterface service;
	
	@Autowired
	MockMvc mockmvc;
	
	@Test
	public void hello_world() throws Exception
	{
		mockmvc.perform(get("/hello_world"))
		.andExpect(status().is(200))
		.andExpect(content().string("Hello World"));
	}
	
	@Test
	public void get_Item() throws Exception
	{
		
		when(service.getItem()).thenReturn(new Item(100,"Item1",10,20));
		mockmvc.perform(get("/get_item"))
				.andExpect(status().is(200))
				.andExpect(content().json("\r\n"
						+ "{\'id\':100,\'name\':\'Item1\',\'price\':10,\'quantity\':20}"));
		
	}
	
}
