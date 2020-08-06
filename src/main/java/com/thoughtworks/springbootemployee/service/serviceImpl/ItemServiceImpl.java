package com.thoughtworks.springbootemployee.service.serviceImpl;

import com.thoughtworks.springbootemployee.entity.Item;
import com.thoughtworks.springbootemployee.repository.ItemRepository;
import com.thoughtworks.springbootemployee.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository  itemRepository;

    @Override
    public Item save(Item item) {
        return  itemRepository.save(item);
    }

    @Override
    public void deleteById(int id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item findById(int id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public  Item updateById(int id,Item item){
        return itemRepository.save(item);
    }
}
