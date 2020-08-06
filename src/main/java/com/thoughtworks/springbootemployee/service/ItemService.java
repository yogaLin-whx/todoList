package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Item;

import java.util.List;

public interface ItemService {

    Item save(Item item);

    void deleteById(int id);

    Item findById(int id);

    Item updateById(int id, Item item);

     List<Item> getItems();

     void addItem(Item item);
}
