package com.qa.webgame.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.qa.webgame.domain.Item;
import com.qa.webgame.dto.ItemDTO;
import com.qa.webgame.exceptions.ItemNotFoundException;
import com.qa.webgame.repository.ItemRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ItemServiceUnitTest {

    @InjectMocks
    private ItemService service;

    @Mock
    private ItemRepository repo;

    @Mock
    private ModelMapper mapper;

    private List<Item> itemList;

    private Item testItem;

    private Long id = 1L;

    private Item testItemWithId;

    private ItemDTO testItemDTO;

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
        when(repo.findAll()).thenReturn(this.itemList);
        when(this.mapper.map(testItemWithId, ItemDTO.class)).thenReturn(testItemDTO);
        assertEquals(this.service.createItem(testItem), this.testItemDTO);
        verify(repo, times(1)).save(this.testItem);
    }

    @Test
    public void createItemTest(){
        when(repo.save(testItem)).thenReturn(testItemWithId);
        when(this.mapper.map(testItemWithId, ItemDTO.class)).thenReturn(testItemDTO);
        assertEquals(this.service.createItem(testItem), this.testItemDTO);
        verify(repo, times(1)).save(this.testItem);
    }

    @Test
    public void findItemByIdTest(){
        when(this.repo.findById(id)).thenReturn(java.util.Optional.ofNullable(testItemWithId));
        when(this.mapper.map(testItemWithId, ItemDTO.class)).thenReturn(testItemDTO);
        assertEquals(this.service.findItemById(this.id), testItemDTO);
        verify(repo, times(1)).findById(id);
    }

    @Test
    public void deleteItemByExistingId(){
        when(this.repo.existsById(id)).thenReturn(true, false);
        assertFalse(service.deleteItem(id));
        verify(repo, times(1)).deleteById(id);
        verify(repo, times(2)).existsById(id);
    }

    @Test(expected = ItemNotFoundException.class)
    public void deleteItemByNonExistingId(){
        when(this.repo.existsById(id)).thenReturn(false);
        service.deleteItem(id);
        verify(repo, times(1)).existsById(id);
    }

    // @Test
    // public void updateItemTest(){

    //    Item newItem = new Item(2L, 3.0, "Sword of reasonable power", "attack:10,health:5");
    //    Item updateItem = new Item(newItem.getRarity(), newItem.getChance(), newItem.getDescription(), newItem.getProperties());
    //    updateItem.setItemId(id);

    //    ItemDTO updateItemDTO = new ModelMapper().map(updateItem, ItemDTO.class);

    //    when(this.repo.findById(id)).thenReturn(java.util.Optional.ofNullable(testItemWithId));
    //    when(this.repo.save(updateItem)).thenReturn(updateItem);
    //    when(this.mapper.map(updateItem, ItemDTO.class)).thenReturn(updateItemDTO);

    //    assertEquals(updateItemDTO, this.service.updateItem(id, newItem));
    //    verify(this.repo, times(1)).findById(id);
    //    verify(this.repo, times(1)).save(updateItem);
    // }
}