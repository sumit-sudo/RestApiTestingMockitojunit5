package com.sumit.restapi.mockito;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.sumit.restapi.mockito.controller.ItemController;
import com.sumit.restapi.mockito.entity.Item;
import com.sumit.restapi.mockito.service.ItemServiceInterface;

//@SpringBootTest(classes= {ItemControllerTest.class})

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	
	/*
	 * @MockBean is a Spring Based Annotation. When you want to inject 
	 * 	a mock into the Spring Context, we use @MockBean.
	 * @Mock and @InjectMocks are for unit tests using pure Mockito. No Spring Context.
	 * 
	 */
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
		//Mocking out the service layer dependency
		when(service.getItem()).thenReturn(new Item(100,"Item1",10,20));
		mockmvc.perform(get("/get_item"))
				.andExpect(status().is(200))
				.andExpect(content().json("\r\n"
						+ "{\'id\':100,\'name\':\'Item1\',\'price\':10,\'quantity\':20}"));
		
	}
	
	@Test
	public void getItemsFromDatabase() throws Exception
	{
		List<Item> obj=new ArrayList<>();
		obj.add(new Item(100,"Item1",10,20,200));
		obj.add(new Item(102,"Item2",5,10,50));
		obj.add(new Item(103,"Item3",15,2,30));
		
		//Mocking out the service layer dependency
		when(service.getItems()).thenReturn(obj);
		mockmvc.perform(get("/get_items"))
				.andExpect(status().is(200))
				.andExpect(content().json("\r\n"
						+ "[{\"id\":100,\"name\":\"Item1\",\"price\":10,\"quantity\":20,\"value\":200},{\"id\":102,\"name\":\"Item2\",\"price\":5,\"quantity\":10,\"value\":50},{\"id\":103,\"name\":\"Item3\",\"price\":15,\"quantity\":2,\"value\":30}]"));
		
		
		
	}
	
}
