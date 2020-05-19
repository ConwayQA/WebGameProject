package com.qa.webgame.controller;

import java.util.List;

import com.qa.webgame.domain.Item;
import com.qa.webgame.dto.ItemDTO;
import com.qa.webgame.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ItemController {

    private final ItemService service;

    @Autowired
    public ItemController(ItemService service) {
        this.service = service;
    }
    
    @GetMapping("/getAllItems")
    public ResponseEntity<List<ItemDTO>> getAllItems(){
        return ResponseEntity.ok(this.service.readItems());
    }

    @PostMapping("/createItem")
    public ResponseEntity<ItemDTO> createItem(@RequestBody Item item){
        return new ResponseEntity<ItemDTO>(this.service.createItem(item), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id){
        return this.service.deleteItem(id)
            ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
            : ResponseEntity.noContent().build();
    }

    @GetMapping("/getItemByID/{id}")
    public ResponseEntity<ItemDTO> getItemById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findItemById(id));
    }

    @PutMapping("/updateItem/{id}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable Long id, @RequestBody Item item){
        return ResponseEntity.ok(this.service.updateItem(id, item));
    }

}