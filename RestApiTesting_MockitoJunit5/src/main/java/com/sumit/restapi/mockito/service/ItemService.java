package com.sumit.restapi.mockito.service;



import org.springframework.stereotype.Service;
import com.sumit.restapi.mockito.entity.Item;

@Service
public class ItemService implements ItemServiceInterface {

	
	public Item getItem() {
		
		return new Item(100,"Item1",10,20);
	}

}
