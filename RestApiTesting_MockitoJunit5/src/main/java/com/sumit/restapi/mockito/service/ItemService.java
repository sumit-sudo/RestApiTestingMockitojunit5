package com.sumit.restapi.mockito.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumit.restapi.mockito.Dao.ItemDaoRepo;
import com.sumit.restapi.mockito.entity.Item;

@Service
public class ItemService implements ItemServiceInterface {

	@Autowired
	ItemDaoRepo repo;
	
	public Item getItem() {
		
		return new Item(100,"Item1",10,20);
	}

	@Override
	public List<Item> getItems() {
		List<Item> items=(List<Item>) repo.findAll();
		
		for(Item item:items)
		{
			item.setValue(item.getQuantity()*item.getPrice());
			//System.out.println(item.getValue());
		}
		return items;
	}

}
