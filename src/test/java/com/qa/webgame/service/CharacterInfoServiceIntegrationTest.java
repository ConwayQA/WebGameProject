package com.qa.webgame.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.qa.webgame.domain.CharacterInfo;
import com.qa.webgame.dto.CharacterDTO;
import com.qa.webgame.repository.CharacterRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CharacterInfoServiceIntegrationTest {

    @Autowired
    private CharacterService service;

    @Autowired
    private CharacterRepository repository;

    @Autowired
    private ModelMapper mapper;

    private CharacterInfo testCharacter;

    private CharacterInfo testCharacterWithId;

    private CharacterDTO mapToDTO(CharacterInfo character){
        return this.mapper.map(character, CharacterDTO.class);
    }

    @Before
    public void setUp(){
        this.testCharacter = new CharacterInfo(100L, 0L, 1L, 100L);
        this.repository.deleteAll();
        this.testCharacterWithId = this.repository.save(this.testCharacter);
    }

    @Test
    public void readCharactersTest(){
        assertThat(this.service.readCharacters()).isEqualTo(
            Stream.of(this.mapToDTO(testCharacterWithId)).collect(Collectors.toList())
        );
    }

    @Test
    public void createCharacterTest(){
        assertEquals(this.mapToDTO(this.testCharacterWithId), this.service.createCharacter(testCharacter));
    }

    @Test
    public void findCharacterByIdTest(){
        assertThat(this.service.findCharacterById(this.testCharacterWithId.getCharacterId())).isEqualTo(this.mapToDTO(this.testCharacterWithId));
    }

    // @Test
    // public void deleteCharacterTest(){
    //     assertThat(this.service.deleteCharacter(this.testCharacterWithId.getCharacterId())).isFalse();
    // }

    @Test
    public void updateCharacterTest(){
        CharacterInfo newCharacter = new CharacterInfo(200L, 1000L, 2L, 200L);
        CharacterInfo updateCharacter = new CharacterInfo(newCharacter.getHealth(), newCharacter.getExperience(), newCharacter.getLevel(), newCharacter.getMana());
        updateCharacter.setCharacterId(this.testCharacterWithId.getCharacterId());
        assertThat(this.service.updateCharacter(this.testCharacterWithId.getCharacterId(), newCharacter))
                    .isEqualTo(this.mapToDTO(updateCharacter));
    }
    
}