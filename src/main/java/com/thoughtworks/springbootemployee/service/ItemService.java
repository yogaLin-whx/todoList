package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.ItemRequest;
import com.thoughtworks.springbootemployee.dto.ItemResponse;
import com.thoughtworks.springbootemployee.entity.Item;

import java.util.List;

public interface ItemService {

    ItemResponse save(ItemRequest item);

    void deleteById(int id);

    ItemResponse findById(int id);

    ItemResponse updateById(int id, ItemRequest itemRequest);

     List<Item> getItems();

     void addItem(Item item);
}
