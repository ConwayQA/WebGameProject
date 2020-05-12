package com.qa.webgame.service;

import java.util.List;
import java.util.stream.Collectors;

import com.qa.webgame.domain.Item;
import com.qa.webgame.dto.ItemDTO;
import com.qa.webgame.exceptions.ItemNotFoundException;
import com.qa.webgame.repository.ItemRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public ItemService(ItemRepository repo, ModelMapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    private ItemDTO mapToDTO(Item item){
        return this.mapper.map(item, ItemDTO.class);
    }

    public List<ItemDTO> readItems(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public ItemDTO createItem(Item item){
        Item tempItem = this.repo.save(item);
        return this.mapToDTO(tempItem);
    }

    public ItemDTO findItemById(Long id){
        Item tempItem = this.repo.findById(id).orElseThrow(ItemNotFoundException::new);
        return this.mapToDTO(tempItem);
    }

    public ItemDTO updateItem(Long id, Item item){
        Item update = this.repo.findById(id).orElseThrow(ItemNotFoundException::new);
        update.setRarity(item.getRarity());
        update.setChance(item.getChance());
        update.setDescription(item.getDescription());
        update.setProperties(item.getProperties());
        Item tempItem = this.repo.save(update);
        return this.mapToDTO(tempItem);
    }

    public boolean deleteItem(Long id){
        if(!this.repo.existsById(id)){
            throw new ItemNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}