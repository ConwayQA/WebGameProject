package com.qa.webgame.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.qa.webgame.domain.Item;
import com.qa.webgame.dto.ItemDTO;
import com.qa.webgame.repository.ItemRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemServiceIntegrationTest {

    @Autowired
    private ItemService service;

    @Autowired
    private ItemRepository repository;

    @Autowired
    private ModelMapper mapper;

    private Item testItem;

    private Item testItemWithId;

    private ItemDTO mapToDTO(Item item){
        return this.mapper.map(item, ItemDTO.class);
    }

    @Before
    public void setUp(){
        this.testItem = new Item(1L, 4.0, "Potion of Lesser Healing:Use to recover health by 50", "consumable:1,currentHealth:50", "https://drive.google.com/uc?id=1eFd4Knyoi0klSudPerzqokqt_Dqfw3nm");
        this.repository.deleteAll();
        this.testItemWithId = this.repository.save(this.testItem);
    }

    @Test
    public void readItemsTest(){
        assertThat(this.service.readItems()).isEqualTo(
            Stream.of(this.mapToDTO(testItemWithId)).collect(Collectors.toList())
        );
    }

    @Test
    public void createItemTest(){
        assertEquals(this.mapToDTO(this.testItemWithId), this.service.createItem(testItem));
    }

    @Test
    public void findItemByIdTest(){
        assertThat(this.service.findItemById(this.testItemWithId.getItemId())).isEqualTo(this.mapToDTO(this.testItemWithId));
    }

    @Test
    public void deleteItemTest(){
        assertThat(this.service.deleteItem(this.testItemWithId.getItemId())).isFalse();
    }

    @Test
    public void updateItemTest(){
        Item newItem = new Item(1L, 4.0, "Potion of Lesser Arcana:Use to recover mana by 50", "consumable:1,currentMana:50", "https://drive.google.com/uc?id=1_gT3YPNsECA4mQHqwbUa-db2hu3XmQGm");
        Item updateItem = new Item(newItem.getRarity(), newItem.getChance(), newItem.getDescription(), newItem.getProperties(), newItem.getImgUrl());
        updateItem.setItemId(this.testItemWithId.getItemId());
        assertThat(this.service.updateItem(this.testItemWithId.getItemId(), newItem))
                    .isEqualTo(this.mapToDTO(updateItem));
    }
    
}