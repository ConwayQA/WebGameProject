package com.qa.webgame.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.qa.webgame.domain.CharacterInfo;
import com.qa.webgame.dto.CharacterDTO;
import com.qa.webgame.service.CharacterService;

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
public class CharacterInfoControllerUnitTest {

    @InjectMocks
    private CharacterController CharacterInfoController;

    @Mock
    private CharacterService service;

    private List<CharacterInfo> characterInfoList;

    private CharacterInfo testCharacterInfo;

    private CharacterInfo testCharacterInfoWithId;

    private long id = 1L;

    private CharacterDTO testCharacterInfoDTO;

    private final ModelMapper mapper = new ModelMapper();

    private CharacterDTO mapToDTO(CharacterInfo characterInfo){
        return this.mapper.map(characterInfo, CharacterDTO.class);
    }

    @Before
    public void setUp(){
        this.characterInfoList = new ArrayList<>();
        this.testCharacterInfo = new CharacterInfo(100L, 0L, 1L, 100L);
        this.characterInfoList.add(testCharacterInfo);
        this.testCharacterInfoWithId = new CharacterInfo(testCharacterInfo.getHealth(), testCharacterInfo.getExperience(), testCharacterInfo.getLevel(), testCharacterInfo.getMana());
        this.testCharacterInfoWithId.setCharacterId(id);
        this.testCharacterInfoDTO = mapToDTO(testCharacterInfoWithId);
    }

    @Test
    public void getAllCharactersTest(){
        when(service.readCharacters()).thenReturn(this.characterInfoList.stream().map(this::mapToDTO).collect(Collectors.toList()));
        assertFalse("No CharacterInfos found", this.CharacterInfoController.getAllCharacters().getBody().isEmpty());
        verify(service, times(1)).readCharacters();
    }

    @Test
    public void createCharacterInfoTest(){
        when(this.service.createCharacter(testCharacterInfo)).thenReturn(this.testCharacterInfoDTO);
        assertEquals(this.CharacterInfoController.createCharacter(testCharacterInfo), new ResponseEntity<CharacterDTO>(this.testCharacterInfoDTO, HttpStatus.CREATED));
        verify(this.service, times(1)).createCharacter(testCharacterInfo);
    }

    @Test
    public void deleteCharacterInfoTestFalse(){
        this.CharacterInfoController.deleteCharacter(id);
        verify(service, times(1)).deleteCharacter(id);
    }


    @Test
    public void deleteCharacterInfoTestTrue(){
        when(service.deleteCharacter(3L)).thenReturn(true);
        this.CharacterInfoController.deleteCharacter(3L);
        verify(service, times(1)).deleteCharacter(3L);
    }

    @Test
    public void getCharacterInfoByIDTest(){
        when(this.service.findCharacterById(id)).thenReturn(this.testCharacterInfoDTO);
        assertEquals(this.CharacterInfoController.getCharacterById(id), new ResponseEntity<CharacterDTO>(this.testCharacterInfoDTO, HttpStatus.OK));
        verify(service, times(1)).findCharacterById(id);
    }
    
}