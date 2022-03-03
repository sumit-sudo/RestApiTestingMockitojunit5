package com.sumit.restapi.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.sumit.restapi.mockito.Dao.ItemDaoRepo;
import com.sumit.restapi.mockito.entity.Item;
import com.sumit.restapi.mockito.service.ItemService;

//@SpringBootTest(classes= {ItemService.class})

public class ItemServiceTest {

	@InjectMocks
	ItemService service;
	@MockBean
	ItemDaoRepo repo;
	
	@Test
	public void getItemTest()
	{	
		System.out.println(service.getItem());
		System.out.println(new Item(100,"Item1",10,20));
		assertEquals(0, service.getItem().getValue());
		//verify();
	}

	
	@Test
	public void getItems()
	{
		List<Item> obj=new ArrayList<>();
		obj.add(new Item(100,"Item1",10,20));
		obj.add(new Item(102,"Item2",5,10));
		obj.add(new Item(103,"Item3",15,2));
		
		//System.out.println(service.getItems().get(0).getId());
		
		when(repo.findAll()).thenReturn(obj);
		
		assertEquals(100, service.getItems().get(0).getId());
		
	}
	
}
