package com.qa.webgame.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.qa.webgame.domain.CharacterInfo;
import com.qa.webgame.domain.InventoryItem;
import com.qa.webgame.domain.InventoryItemJSON;
import com.qa.webgame.domain.Item;
import com.qa.webgame.dto.CharacterDTO;
import com.qa.webgame.dto.InventoryDTO;
import com.qa.webgame.exceptions.CharacterNotFoundException;
import com.qa.webgame.repository.CharacterRepository;
import com.qa.webgame.repository.InventoryRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    private final CharacterRepository repo;
    private final InventoryRepository inventRepo;
    private final ItemService itemService; 

    private final ModelMapper mapper;

    @Autowired
    public CharacterService(CharacterRepository repo, InventoryRepository inventRepo, ItemService itemService, ModelMapper mapper){
        this.repo = repo;
        this.inventRepo = inventRepo;
        this.itemService = itemService;
        this.mapper = mapper;
    }

    private CharacterDTO mapToDTO(CharacterInfo character){
        return this.mapper.map(character, CharacterDTO.class);
    }

    private InventoryDTO mapToDTO(InventoryItem inventory){
        return this.mapper.map(inventory, InventoryDTO.class);
    }

    public List<CharacterDTO> readCharacters(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public CharacterDTO createCharacter(CharacterInfo character){
        CharacterInfo tempCharacter = this.repo.save(character);
        return this.mapToDTO(tempCharacter);
    }

    public CharacterDTO findCharacterById(Long id){
        CharacterInfo tempCharacter = getCurrentCharacterInfo(id);
        return this.mapToDTO(tempCharacter);
    }

    public CharacterDTO updateCharacter(Long id, CharacterInfo character){
        CharacterInfo update = getCurrentCharacterInfo(id);
        update.setExperience(character.getExperience());
        update.setHealth(character.getHealth());
        update.setLevel(character.getLevel());
        update.setMana(character.getMana());
        CharacterInfo tempCharacter = this.repo.save(update);
        return this.mapToDTO(tempCharacter);
    }

    public boolean deleteCharacter(Long id){
        if(!this.repo.existsById(id)){
            throw new CharacterNotFoundException();
        }
        this.repo.deleteById(id);
        deleteInventoryByCharacter(id);
        return this.repo.existsById(id);
    }

	public Set<InventoryDTO> findInventoryByCharacter(Long id) {
        CharacterInfo tempCharacter = getCurrentCharacterInfo(id);
        Set<InventoryItem> tempInventory = tempCharacter.getInventory();
        return tempInventory.stream().map(this::mapToDTO).collect(Collectors.toSet());
    }

	public Set<InventoryDTO> updateInventory(Long id, List<InventoryItemJSON> inventory) {
        CharacterInfo tempCharacter = getCurrentCharacterInfo(id);
        deleteInventoryByCharacter(id);  
        List<InventoryItem> fetchFullInventory = generateInventory(tempCharacter, inventory);
        List<InventoryItem> tempInventory = this.inventRepo.saveAll(fetchFullInventory);
		return tempInventory.stream().map(this::mapToDTO).collect(Collectors.toSet());
    }

    public InventoryDTO addItemToInventory(Long id, InventoryItemJSON item){
        CharacterInfo tempCharacter = getCurrentCharacterInfo(id);
        InventoryItem tempItem = generateFullItem(tempCharacter, item);
        this.inventRepo.save(tempItem);
        return mapToDTO(tempItem);
    }

    public CharacterInfo getCurrentCharacterInfo(Long id) {
        return this.repo.findById(id).orElseThrow(CharacterNotFoundException::new);
    }

    public List<InventoryItem> generateInventory(CharacterInfo tempCharacter, List<InventoryItemJSON> inventory){
        List<InventoryItem> tempInventory = new ArrayList<>();
        for (InventoryItemJSON inventItem : inventory){
            tempInventory.add(generateFullItem(tempCharacter, inventItem));
        }
        return tempInventory;
    }

    public InventoryItem generateFullItem(CharacterInfo tempCharacter, InventoryItemJSON item){
        InventoryItem tempInventItem = new InventoryItem();
            tempInventItem.setCharacter(tempCharacter);
            Item fetchItem = itemService.findItemByIdPure(item.getItemID());
            tempInventItem.setItem(fetchItem);
            tempInventItem.setPosition(item.getPosition());
            tempInventItem.setCharges(item.getCharges());
            return tempInventItem;
    }

    public boolean deleteInventoryByCharacter(Long id){
        CharacterInfo tempCharacter = this.repo.findById(id).orElseThrow(CharacterNotFoundException::new);
        Set<InventoryItem> tempInventory = tempCharacter.getInventory();
        for (InventoryItem tempItem : tempInventory){
            this.inventRepo.delete(tempItem);
        }
        return false;
    }
}