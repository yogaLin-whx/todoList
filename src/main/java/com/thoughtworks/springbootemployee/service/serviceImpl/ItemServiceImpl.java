package com.thoughtworks.springbootemployee.service.serviceImpl;

import com.thoughtworks.springbootemployee.dto.ItemRequest;
import com.thoughtworks.springbootemployee.dto.ItemResponse;
import com.thoughtworks.springbootemployee.entity.Item;
import com.thoughtworks.springbootemployee.repository.ItemRepository;
import com.thoughtworks.springbootemployee.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public ItemResponse save(ItemRequest itemRequest) {
        Item item = new Item();
        BeanUtils.copyProperties(itemRequest, item);
        item = itemRepository.save(item);
        ItemResponse itemResponse = new ItemResponse();
        BeanUtils.copyProperties(item, itemResponse);
        return itemResponse;
    }

    @Override
    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }

    @Override
    public ItemResponse findById(int id) {
        ItemResponse itemResponse = new ItemResponse();
        Item item = itemRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(item, itemResponse);
        return itemResponse;
    }

    @Override
    public ItemResponse updateById(int id, ItemRequest itemRequest) {
        Item item = new Item();
        ItemResponse itemResponse = new ItemResponse();
        BeanUtils.copyProperties(itemRequest, item);
        item = itemRepository.save(item);
        BeanUtils.copyProperties(item, itemResponse);
        return itemResponse;
    }

    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public void addItem(Item item) {
        itemRepository.save(item);
    }
}
