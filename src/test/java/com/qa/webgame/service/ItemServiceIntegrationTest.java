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
        this.testItem = new Item(5L, 0.1, "Sword of ultimate power", "attack:100,defense:90,magic:50");
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
        Item newItem = new Item(3L, 5.5, "Sword of Average power", "attack:10,defense:9,magic:5");
        Item updateItem = new Item(newItem.getRarity(), newItem.getChance(), newItem.getDescription(), newItem.getProperties());
        updateItem.setItemId(this.testItemWithId.getItemId());
        assertThat(this.service.updateItem(this.testItemWithId.getItemId(), newItem))
                    .isEqualTo(this.mapToDTO(updateItem));
    }
    
}