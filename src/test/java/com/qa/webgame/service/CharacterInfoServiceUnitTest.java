package com.qa.webgame.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.qa.webgame.domain.CharacterInfo;
import com.qa.webgame.dto.CharacterDTO;
import com.qa.webgame.exceptions.CharacterNotFoundException;
import com.qa.webgame.repository.CharacterRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CharacterInfoServiceUnitTest {

    @InjectMocks
    private CharacterService service;

    @Mock
    private CharacterRepository repo;

    @Mock
    private ModelMapper mapper;

    private List<CharacterInfo> CharacterList;

    private CharacterInfo testCharacter;

    private Long id = 1L;

    private CharacterInfo testCharacterWithId;

    private CharacterDTO testCharacterDTO;

    private CharacterDTO mapToDTO(CharacterInfo Character){
        return this.mapper.map(Character, CharacterDTO.class);
    }

    @Before
    public void setUp(){
        this.CharacterList = new ArrayList<>();
        this.testCharacter = new CharacterInfo(100L, 0L, 1L, 100L);
        this.CharacterList.add(testCharacter);
        this.testCharacterWithId = new CharacterInfo(testCharacter.getHealth(), testCharacter.getExperience(), testCharacter.getLevel(), testCharacter.getMana());
        this.testCharacterWithId.setCharacterId(id);
        this.testCharacterDTO = mapToDTO(testCharacterWithId);
    }
    
    @Test
    public void getAllCharactersTest(){
        when(repo.findAll()).thenReturn(this.CharacterList);
        when(this.mapper.map(testCharacterWithId, CharacterDTO.class)).thenReturn(testCharacterDTO);
        assertEquals(this.service.createCharacter(testCharacter), this.testCharacterDTO);
        verify(repo, times(1)).save(this.testCharacter);
    }

    @Test
    public void createCharacterTest(){
        when(repo.save(testCharacter)).thenReturn(testCharacterWithId);
        when(this.mapper.map(testCharacterWithId, CharacterDTO.class)).thenReturn(testCharacterDTO);
        assertEquals(this.service.createCharacter(testCharacter), this.testCharacterDTO);
        verify(repo, times(1)).save(this.testCharacter);
    }

    @Test
    public void findCharacterByIdTest(){
        when(this.repo.findById(id)).thenReturn(java.util.Optional.ofNullable(testCharacterWithId));
        when(this.mapper.map(testCharacterWithId, CharacterDTO.class)).thenReturn(testCharacterDTO);
        assertEquals(this.service.findCharacterById(this.id), testCharacterDTO);
        verify(repo, times(1)).findById(id);
    }

    // @Test
    // public void deleteCharacterByExistingId(){
    //     when(this.repo.existsById(id)).thenReturn(true, false);
    //     assertFalse(service.deleteCharacter(id));
    //     verify(repo, times(1)).deleteById(id);
    //     verify(repo, times(2)).existsById(id);
    // }

    @Test(expected = CharacterNotFoundException.class)
    public void deleteCharacterByNonExistingId(){
        when(this.repo.existsById(id)).thenReturn(false);
        service.deleteCharacter(id);
        verify(repo, times(1)).existsById(id);
    }

    @Test
    public void updateCharacterTest(){

       CharacterInfo newCharacter = new CharacterInfo(200L, 1000L, 2L, 200L);
       CharacterInfo updateCharacter = new CharacterInfo(newCharacter.getHealth(), newCharacter.getExperience(), newCharacter.getLevel(), newCharacter.getMana());
       updateCharacter.setCharacterId(id);

       CharacterDTO updateCharacterDTO = new ModelMapper().map(updateCharacter, CharacterDTO.class);

       when(this.repo.findById(id)).thenReturn(java.util.Optional.ofNullable(testCharacterWithId));
       when(this.repo.save(updateCharacter)).thenReturn(updateCharacter);
       when(this.mapper.map(updateCharacter, CharacterDTO.class)).thenReturn(updateCharacterDTO);

       assertEquals(updateCharacterDTO, this.service.updateCharacter(id, newCharacter));
       verify(this.repo, times(1)).findById(id);
       verify(this.repo, times(1)).save(updateCharacter);
    }
}