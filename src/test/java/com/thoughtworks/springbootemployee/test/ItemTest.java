package com.thoughtworks.springbootemployee.test;

import com.thoughtworks.springbootemployee.entity.Item;
import com.thoughtworks.springbootemployee.repository.ItemRepository;
import com.thoughtworks.springbootemployee.service.serviceImpl.ItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ItemTest {

    @Autowired
    ItemRepository  itemRepository;

    @Autowired
    ItemServiceImpl itemService;

    @BeforeEach
    void clearRepository(){
        itemRepository.deleteAll();
    }

    @Test
    void  should_return_item_with_id_when_add_item_list_given_item(){
        //given
        Item item = new Item();
        item.setContent("This is a test");

        //when
        Item itemResult = itemService.save(item);

        //then
        assertNotNull(itemResult);
    }
}
