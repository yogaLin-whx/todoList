package com.thoughtworks.springbootemployee.test;

import com.thoughtworks.springbootemployee.dto.ItemRequest;
import com.thoughtworks.springbootemployee.dto.ItemResponse;
import com.thoughtworks.springbootemployee.entity.Item;
import com.thoughtworks.springbootemployee.repository.ItemRepository;
import com.thoughtworks.springbootemployee.service.serviceImpl.ItemServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        ItemRequest itemRequest = new ItemRequest();
        BeanUtils.copyProperties(item, itemRequest);

        //when
        itemService.save(itemRequest);

        //then
        assertEquals(1, itemRepository.findAll().size());
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
        ItemResponse itemResponse = itemService.findById(item.getId());

        //then
        assertEquals(item.getContent(), itemResponse.getName());
        assertEquals(item.isStatus(), itemResponse.isStatus());
    }

    @Test
    void should_return_update_item_when_update_item_given_exist_item_with_update_value() {
        //given
        Item item = new Item();
        item.setContent("This is a test");
        item = itemRepository.save(item);
        item.setContent("update");

        //when
        Item itemResult = itemService.updateById(item.getId(), item);

        //then
        assertEquals(item, itemResult);
    }

    @Test
    void should_return_2item_when_get_all_items() {
        //given
        Item item1 = new Item();
        Item item2 = new Item();
        itemRepository.save(item1);
        itemRepository.save(item2);

        //when
        List<Item> itemsResult = itemService.getItems();

        //then
        assertEquals(2, itemsResult.size());
    }

}
