package com.qa.webgame.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.qa.webgame.domain.Item;
import com.qa.webgame.dto.ItemDTO;
import com.qa.webgame.service.ItemService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerUnitTest {

    @InjectMocks
    private ItemController itemController;

    @Mock
    private ItemService service;

    private List<Item> itemList;

    private Item testItem;

    private Item testItemWithId;

    private long id = 1L;

    private ItemDTO testItemDTO;

    private final ModelMapper mapper = new ModelMapper();

    private ItemDTO mapToDTO(Item item){
        return this.mapper.map(item, ItemDTO.class);
    }

    @Before
    public void setUp(){
        this.itemList = new ArrayList<>();
        this.testItem = new Item(5L, 0.1, "Sword of ultimate power", "attack:100,defense:90,magic:50");
        this.itemList.add(testItem);
        this.testItemWithId = new Item(testItem.getRarity(), testItem.getChance(), testItem.getDescription(), testItem.getProperties());
        this.testItemWithId.setItemId(id);
        this.testItemDTO = mapToDTO(testItemWithId);
    }

    @Test
    public void getAllItemsTest(){
        when(service.readItems()).thenReturn(this.itemList.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No Items found", this.itemController.getAllItems().getBody().isEmpty());
        verify(service, times(1)).readItems();
    }

    @Test
    public void createItemTest(){
        when(this.service.createItem(testItem)).thenReturn(this.testItemDTO);
        assertEquals(this.itemController.createItem(testItem), new ResponseEntity<ItemDTO>(this.testItemDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createItem(testItem);
    }

    @Test
    public void deleteItemTestFalse(){
        this.itemController.deleteItem(id);
        verify(service, times(1)).deleteItem(id);
    }


    @Test
    public void deleteItemTestTrue(){
        when(service.deleteItem(3L)).thenReturn(true);
        this.itemController.deleteItem(3L);
        verify(service, times(1)).deleteItem(3L);
    }

    @Test
    public void getItemByIDTest(){
        when(this.service.findItemById(id)).thenReturn(this.testItemDTO);
        assertEquals(this.itemController.getItemById(id), new ResponseEntity<ItemDTO>(this.testItemDTO, HttpStatus.OK));
        verify(service, times(1)).findItemById(id);
    }
    
}