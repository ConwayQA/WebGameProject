// package com.qa.webgame.controller;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.qa.webgame.domain.Item;
// import com.qa.webgame.dto.ItemDTO;
// import com.qa.webgame.repository.ItemRepository;

// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.modelmapper.ModelMapper;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.MediaType;
// import org.springframework.test.context.junit4.SpringRunner;
// import org.springframework.test.web.servlet.MockMvc;

// import java.util.ArrayList;
// import java.util.List;

// import static org.junit.Assert.assertEquals;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// @RunWith(SpringRunner.class)
// @SpringBootTest
// @AutoConfigureMockMvc
// public class ItemControllerIntegrationTest {
    
//     @Autowired
//     private MockMvc mock;

//     @Autowired
//     private ItemRepository repository;

//     @Autowired
//     private ModelMapper mapper;

//     private ObjectMapper objectMapper = new ObjectMapper();

//     private Item testItem;

//     private Item testItemWithID;

//     private long id;

//     private ItemDTO testItemDTO;

//     private ItemDTO mapToDTO(Item Item){
//         return this.mapper.map(Item, ItemDTO.class);
//     }

//     @Before
//     public void setUp(){
//         this.repository.deleteAll();
//         this.testItem = new Item(1L, 4.0, "Potion of Lesser Healing:Use to recover health by 50", "consumable:1,currentHealth:50", "https://drive.google.com/uc?id=1eFd4Knyoi0klSudPerzqokqt_Dqfw3nm");
//         this.testItemWithID = this.repository.save(testItem);
//         this.id = testItemWithID.getItemId();
//         this.testItemDTO = this.mapToDTO(testItemWithID);
//     }

//     @Test
//     public void getAllItemsTest() throws Exception {
//         List<ItemDTO> ItemDTOList = new ArrayList<>();
//         ItemDTOList.add(testItemDTO);
//         String content = this.mock.perform(
//             request(HttpMethod.GET, "/getAllItems")
//                 .accept(MediaType.APPLICATION_JSON)
//         )
//             .andExpect(status().isOk())
//             .andReturn()
//             .getResponse()
//             .getContentAsString();
//         assertEquals(content, this.objectMapper.writeValueAsString(ItemDTOList));
//     }

//     @Test
//     public void getItemByID() throws Exception {
//         String content = this.mock.perform(
//                 request(HttpMethod.GET, "/getItemByID/" + this.id)
//                 .accept(MediaType.APPLICATION_JSON)
//         )
//             .andExpect(status().isOk())
//             .andReturn()
//             .getResponse()
//             .getContentAsString();
//         assertEquals(content, this.objectMapper.writeValueAsString(testItemDTO));
//     }

//     @Test
//     public void createItemTest() throws Exception {
//         String result = this.mock.perform(
//                 request(HttpMethod.POST, "/createItem")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(this.objectMapper.writeValueAsString(testItem))
//                 .accept(MediaType.APPLICATION_JSON)
//         )
//             .andExpect(status().isCreated())
//             .andReturn()
//             .getResponse()
//             .getContentAsString();
//         assertEquals(result, this.objectMapper.writeValueAsString(testItemDTO));
//     }

//     @Test
//     public void deleteItemTest() throws Exception {
//         this.mock.perform(
//                 request(HttpMethod.DELETE, "/deleteItem/" + this.id)
//         ).andExpect(status().isNoContent());
//     }
// }