package com.thoughtworks.springbootemployee.service.serviceImpl;

import com.thoughtworks.springbootemployee.entity.Item;
import com.thoughtworks.springbootemployee.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemServiceImpl {

    @Autowired
    ItemRepository  itemRepository;

    public Item save(Item item) {
        return  null;
    }
}
