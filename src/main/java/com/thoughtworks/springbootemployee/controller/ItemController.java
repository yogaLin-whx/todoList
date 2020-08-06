package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.dto.ItemResponse;
import com.thoughtworks.springbootemployee.entity.Item;
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
    private List<ItemResponse> getItem() {
        return itemService.getItems();
    }

    @PostMapping
    private void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }



}
