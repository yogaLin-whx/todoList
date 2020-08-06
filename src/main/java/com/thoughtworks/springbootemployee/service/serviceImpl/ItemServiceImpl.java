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
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

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
    public void updateById(int id, ItemRequest itemRequest) {
        Item item = itemRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(itemRequest, item);
        itemRepository.save(item);
    }

    @Override
    public List<ItemResponse> getItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream().map(item -> {
            ItemResponse itemResponse = new ItemResponse();
            BeanUtils.copyProperties(item, itemResponse);
            return itemResponse;
        }).collect(Collectors.toList());
    }

    @Override
    public void addItem(ItemRequest itemRequest) {
        Item item = new Item();
        BeanUtils.copyProperties(itemRequest,item);
        itemRepository.save(item);
    }
}
