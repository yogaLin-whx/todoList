package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.entity.Item;
import com.thoughtworks.springbootemployee.service.serviceImpl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ItemController {

    @Autowired
    private ItemServiceImpl itemService;


    @GetMapping
    private List<Item> getItem() {
        return itemService.getItems();
    }

    @PostMapping
    private void addItem(@RequestBody Item item) {
        itemService.addItem(item);
    }



}
