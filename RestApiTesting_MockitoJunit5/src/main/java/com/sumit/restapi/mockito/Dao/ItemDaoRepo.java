package com.sumit.restapi.mockito.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sumit.restapi.mockito.entity.Item;


@Component
public interface ItemDaoRepo extends CrudRepository<Item, Integer> {

}
