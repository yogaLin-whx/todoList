package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.ItemRequest;
import com.thoughtworks.springbootemployee.dto.ItemResponse;
import com.thoughtworks.springbootemployee.entity.Item;

import java.util.List;

public interface ItemService {

    ItemResponse save(ItemRequest item);

    void deleteById(int id);

    Item findById(int id);

    Item updateById(int id, Item item);

     List<Item> getItems();

     void addItem(Item item);
}
