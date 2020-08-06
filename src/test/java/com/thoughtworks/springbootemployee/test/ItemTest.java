package com.thoughtworks.springbootemployee.test;

import com.thoughtworks.springbootemployee.entity.Item;
import com.thoughtworks.springbootemployee.repository.ItemRepository;
import com.thoughtworks.springbootemployee.service.serviceImpl.ItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ItemTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemServiceImpl itemService;

    @BeforeEach
    void clearRepository() {
        itemRepository.deleteAll();
    }


    @Test
    void should_return_item_with_id_when_add_item_list_given_item() {
        //given
        Item item = new Item();
        item.setContent("This is a test");
        item.setStatus(false);

        //when
        Item itemResult = itemService.save(item);

        //then
        assertNotNull(itemResult);
    }

    @Test
    void should_return_null_when_delete_item_list_given_exist_item() {
        //given
        Item item = new Item();
        item = itemRepository.save(item);

        //when
        itemService.deleteById(item.getId());
        Item existItem = itemRepository.findById(item.getId()).orElse(null);

        //then
        assertNull(existItem);
    }

    @Test
    void should_return_item_with_same_id_when_find_item_by_id_given_exist_item_with_id() {
        //given
        Item item = new Item();
        item = itemRepository.save(item);

        //when
        Item existItem = itemService.findById(item.getId());

        //then
        assertEquals(item.getId(), existItem.getId());
    }

}
