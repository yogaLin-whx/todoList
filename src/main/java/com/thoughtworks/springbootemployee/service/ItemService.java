package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.dto.ItemRequest;
import com.thoughtworks.springbootemployee.dto.ItemResponse;

import java.util.List;

public interface ItemService {

    ItemResponse save(ItemRequest item);

    void deleteById(int id);

    ItemResponse findById(int id);

    ItemResponse updateById(int id, ItemRequest IitemRequest);

    List<ItemResponse> getItems();

    void addItem(ItemRequest itemRequest);
}
