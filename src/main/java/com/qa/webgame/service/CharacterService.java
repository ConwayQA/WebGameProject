package com.qa.webgame.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.qa.webgame.domain.CharacterInfo;
import com.qa.webgame.domain.InventoryItem;
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

    private final ModelMapper mapper;

    @Autowired
    public CharacterService(CharacterRepository repo, InventoryRepository inventRepo, ModelMapper mapper){
        this.repo = repo;
        this.inventRepo = inventRepo;
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
        CharacterInfo tempCharacter = this.repo.findById(id).orElseThrow(CharacterNotFoundException::new);
        return this.mapToDTO(tempCharacter);
    }

    public CharacterDTO updateCharacter(Long id, CharacterInfo character){
        CharacterInfo update = this.repo.findById(id).orElseThrow(CharacterNotFoundException::new);
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
        return this.repo.existsById(id);
    }

	public Set<InventoryDTO> findInventoryByCharacter(Long id) {
        CharacterInfo tempCharacter = this.repo.findById(id).orElseThrow(CharacterNotFoundException::new);
        Set<InventoryItem> tempInventory = tempCharacter.getInventory();
        return tempInventory.stream().map(this::mapToDTO).collect(Collectors.toSet());
	}

	public Set<InventoryDTO> updateInventory(Long id, List<InventoryItem> inventory) {
        CharacterInfo tempCharacter = this.repo.findById(id).orElseThrow(CharacterNotFoundException::new);
        this.inventRepo.deleteAllByCharacter(tempCharacter);
        List<InventoryItem> tempInventory = this.inventRepo.saveAll(inventory);
		return tempInventory.stream().map(this::mapToDTO).collect(Collectors.toSet());
    }
}