package com.qa.webgame.repository;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import com.qa.webgame.domain.CharacterInfo;

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
public class CharacterRepositoryTest {    
     
    @Autowired
    private TestEntityManager entityManager;

    @Autowired    
    private CharacterRepository repo;  
    
    @Mock
    private ModelMapper mapper;

    private List<CharacterInfo> CharacterInfoList;

    private CharacterInfo testCharacterInfo;

    private Long id = 1L;

    private CharacterInfo testCharacterInfoWithId;

    @Before
    public void setUp(){
        this.CharacterInfoList = new ArrayList<>();
        this.testCharacterInfo = new CharacterInfo(100L, 0L, 1L, 100L);
        this.CharacterInfoList.add(testCharacterInfo);
        this.testCharacterInfoWithId = new CharacterInfo(testCharacterInfo.getHealth(), testCharacterInfo.getExperience(), testCharacterInfo.getLevel(), testCharacterInfo.getMana());
        this.testCharacterInfoWithId.setCharacterId(id);
    }

    @Test    
    public void readCharacterInfoByIdTest() {       
        CharacterInfo CharacterInfo = entityManager.persistAndFlush(testCharacterInfo); 
        CharacterInfo testCharacterInfo = (repo.findById(CharacterInfo.getCharacterId()).get());   
        assertTrue(testCharacterInfo.equals(CharacterInfo));
    }



}