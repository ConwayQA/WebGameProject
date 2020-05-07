package com.qa.webgame.repository;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.qa.webgame.domain.Item;
import com.qa.webgame.dto.ItemDTO;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {    
     
    @Autowired
    private TestEntityManager entityManager;

    @Autowired    
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
    public void readItemByIdTest() {       
        Item item = entityManager.persistAndFlush(testItem); 
        Item testItem = (repo.findById(item.getItemId()).get());   
        assertTrue(testItem.equals(item));
    }



}