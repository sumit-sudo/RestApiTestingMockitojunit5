package com.sumit.restapi.mockito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.restapi.mockito.entity.Item;
import com.sumit.restapi.mockito.service.ItemServiceInterface;

@RestController
public class ItemController {

	@Autowired
	ItemServiceInterface service;
	
	@GetMapping("/hello_world")
	public String hello_world()
	{
		return "Hello World";
	}
	
	@GetMapping("/get_item")
	public Item getSingleItem()
	{
		return service.getItem();
	}
	
	
}
