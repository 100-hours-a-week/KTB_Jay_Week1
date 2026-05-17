package org.example.service;

import org.example.domain.item.Item;
import org.example.repository.ItemRepository;

import java.util.List;

public class ItemService {
    private ItemRepository itemRepository = new ItemRepository();

    public ItemService(ItemRepository irepo){
        this.itemRepository = irepo;
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }
}
