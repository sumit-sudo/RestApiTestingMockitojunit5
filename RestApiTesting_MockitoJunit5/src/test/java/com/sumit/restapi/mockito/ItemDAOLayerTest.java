package com.sumit.restapi.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sumit.restapi.mockito.Dao.ItemDaoRepo;
import com.sumit.restapi.mockito.entity.Item;

@DataJpaTest
public class ItemDAOLayerTest {

	@Autowired
	ItemDaoRepo repo;
	
	@Test
	public void datatest()
	{
		
		assertEquals(100,repo.findById(100).get().getId());
	}
}
