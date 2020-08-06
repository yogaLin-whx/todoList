package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.dto.ItemRequest;
import com.thoughtworks.springbootemployee.dto.ItemResponse;
import com.thoughtworks.springbootemployee.service.serviceImpl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;


    @GetMapping
    private List<ItemResponse> getItems() {
        return itemService.getItems();
    }

    @GetMapping("/{id}")
    private ItemResponse getItemById(@PathVariable int id){
        return itemService.findById(id);
    }

    @PostMapping
    private void addItem(@RequestBody ItemRequest itemRequest){
        itemService.addItem(itemRequest);
    }

}
