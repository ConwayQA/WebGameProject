package com.qa.webgame.repository;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.qa.webgame.domain.Item;

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

    @Before
    public void setUp(){
        this.itemList = new ArrayList<>();
        this.testItem = new Item(1L, 4.0, "Potion of Lesser Healing:Use to recover health by 50", "consumable:1,currentHealth:50", "https://drive.google.com/uc?id=1eFd4Knyoi0klSudPerzqokqt_Dqfw3nm");
        this.itemList.add(testItem);
        this.testItemWithId = new Item(testItem.getRarity(), testItem.getChance(), testItem.getDescription(), testItem.getProperties(), testItem.getImgUrl());
        this.testItemWithId.setItemId(id);
    }

    @Test    
    public void readItemByIdTest() {       
        Item item = entityManager.persistAndFlush(testItem); 
        Item testItem = (repo.findById(item.getItemId()).get());   
        assertTrue(testItem.equals(item));
    }



}