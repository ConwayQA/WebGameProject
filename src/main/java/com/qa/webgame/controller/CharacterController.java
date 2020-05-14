package com.qa.webgame.controller;

import java.util.List;

import com.qa.webgame.domain.Character;
import com.qa.webgame.dto.CharacterDTO;
import com.qa.webgame.service.CharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CharacterController {
    
    private final CharacterService service;

    @Autowired
    public CharacterController(CharacterService service) {
        this.service = service;
    }
    
    @GetMapping("/getAllCharacters")
    public ResponseEntity<List<CharacterDTO>> getAllCharacters(){
        return ResponseEntity.ok(this.service.readCharacters());
    }

    @PostMapping("/createCharacter")
    public ResponseEntity<CharacterDTO> createCharacter(@RequestBody Character character){
        return new ResponseEntity<CharacterDTO>(this.service.createCharacter(character), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCharacter/{id}")
    public ResponseEntity<?> deleteCharacter(@PathVariable Long id){
        return this.service.deleteCharacter(id)
            ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            : ResponseEntity.noContent().build();
    }

    @GetMapping("/getCharacterByID/{id}")
    public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findCharacterById(id));
    }

    @PutMapping("/updateCharacter/{id}")
    public ResponseEntity<CharacterDTO> updateCharacter(@PathVariable Long id, @RequestBody Character character){
        return ResponseEntity.ok(this.service.updateCharacter(id, character));
    }
}