// package com.qa.webgame.controller;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.qa.webgame.domain.CharacterInfo;
// import com.qa.webgame.dto.CharacterDTO;
// import com.qa.webgame.repository.CharacterRepository;

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
// public class CharacterInfoControllerIntegrationTest {
    
//     @Autowired
//     private MockMvc mock;

//     @Autowired
//     private CharacterRepository repository;

//     @Autowired
//     private ModelMapper mapper;

//     private ObjectMapper objectMapper = new ObjectMapper();

//     private CharacterInfo testCharacter;

//     private CharacterInfo testCharacterWithID;

//     private long id;

//     private CharacterDTO testCharacterDTO;

//     private CharacterDTO mapToDTO(CharacterInfo character){
//         return this.mapper.map(character, CharacterDTO.class);
//     }

//     @Before
//     public void setUp(){
//         this.repository.deleteAll();
//         this.testCharacter = new CharacterInfo(100L, 0L, 1L, 100L);
//         this.testCharacterWithID = this.repository.save(testCharacter);
//         this.id = testCharacterWithID.getCharacterId();
//         this.testCharacterDTO = this.mapToDTO(testCharacterWithID);
//     }

//     @Test
//     public void getAllCharactersTest() throws Exception {
//         List<CharacterDTO> CharacterDTOList = new ArrayList<>();
//         CharacterDTOList.add(testCharacterDTO);
//         String content = this.mock.perform(
//             request(HttpMethod.GET, "/getAllCharacters")
//                 .accept(MediaType.APPLICATION_JSON)
//         )
//             .andExpect(status().isOk())
//             .andReturn()
//             .getResponse()
//             .getContentAsString();
//         assertEquals(content, this.objectMapper.writeValueAsString(CharacterDTOList));
//     }

//     @Test
//     public void getCharacterByID() throws Exception {
//         String content = this.mock.perform(
//                 request(HttpMethod.GET, "/getCharacterByID/" + this.id)
//                 .accept(MediaType.APPLICATION_JSON)
//         )
//             .andExpect(status().isOk())
//             .andReturn()
//             .getResponse()
//             .getContentAsString();
//         assertEquals(content, this.objectMapper.writeValueAsString(testCharacterDTO));
//     }

//     @Test
//     public void createCharacterTest() throws Exception {
//         String result = this.mock.perform(
//                 request(HttpMethod.POST, "/createCharacter")
//                 .contentType(MediaType.APPLICATION_JSON)
//                 .content(this.objectMapper.writeValueAsString(testCharacter))
//                 .accept(MediaType.APPLICATION_JSON)
//         )
//             .andExpect(status().isCreated())
//             .andReturn()
//             .getResponse()
//             .getContentAsString();
//         assertEquals(result, this.objectMapper.writeValueAsString(testCharacterDTO));
//     }

//     @Test
//     public void deleteCharacterTest() throws Exception {
//         this.mock.perform(
//                 request(HttpMethod.DELETE, "/deleteCharacter/" + this.id)
//         ).andExpect(status().isNoContent());
//     }
// }