package org.example.service;

import org.example.domain.item.Item;
import org.example.repository.ItemRepository;

import java.util.List;

public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {

        this.itemRepository = itemRepository;
    }

    public List<Item> getItems() {

        return itemRepository.findAll();
    }
}