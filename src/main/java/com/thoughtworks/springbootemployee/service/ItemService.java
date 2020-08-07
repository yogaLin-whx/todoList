package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.ItemRequest;
import com.thoughtworks.springbootemployee.dto.ItemResponse;
import com.thoughtworks.springbootemployee.entity.Item;

import java.util.List;

public interface ItemService {

    void deleteById(int id);

    ItemResponse findById(int id);

    void updateById(int id, ItemRequest IitemRequest);

    List<Item> getItems();

    Item addItem(ItemRequest itemRequest);
}
