package com.qa.webgame.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CharacterInfoDTOTest {

    private Long id = 1L;
    private CharacterDTO testCharacterDTO;
    private CharacterDTO testCharacterDTOWithId;
    private CharacterDTO testOtherCharacterDTO;
    private CharacterDTO testOtherCharacterDTOWithId;
	
	@Before
	public void setUp() {
        testCharacterDTO = new CharacterDTO(100L, 0L, 1L, 100L);
        testCharacterDTOWithId = new CharacterDTO(testCharacterDTO.getHealth(), testCharacterDTO.getExperience(), testCharacterDTO.getLevel(), testCharacterDTO.getMana());
        testCharacterDTOWithId.setCharacterId(id);
        testOtherCharacterDTO = new CharacterDTO(100L, 0L, 1L, 100L);
        testOtherCharacterDTOWithId = new CharacterDTO(testOtherCharacterDTO.getHealth(), testOtherCharacterDTO.getExperience(), testOtherCharacterDTO.getLevel(), testOtherCharacterDTO.getMana());
        testOtherCharacterDTOWithId.setCharacterId(id);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(testCharacterDTOWithId.getCharacterId());
		assertNotNull(testCharacterDTOWithId.getHealth());
		assertNotNull(testCharacterDTOWithId.getExperience());
		assertNotNull(testCharacterDTOWithId.getLevel());
		assertNotNull(testCharacterDTOWithId.getMana());
		
		testCharacterDTOWithId.setCharacterId(null);
		assertNull(testCharacterDTOWithId.getCharacterId());
		testCharacterDTOWithId.setHealth(null);
		assertNull(testCharacterDTOWithId.getHealth());
		testCharacterDTOWithId.setExperience(null);
		assertNull(testCharacterDTOWithId.getExperience());
		testCharacterDTOWithId.setLevel(null);
		assertNull(testCharacterDTOWithId.getLevel());
		testCharacterDTOWithId.setMana(null);
		assertNull(testCharacterDTOWithId.getMana());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(testCharacterDTO.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(testCharacterDTO.equals(new Object()));
	}
	
	@Test
	public void checkEquality() {
		assertTrue(testCharacterDTO.equals(testCharacterDTO));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(testCharacterDTO.equals(testOtherCharacterDTO));
	}
	
	@Test
	public void CharacterDTORarityNullButOtherRarityNotNull() {
		testCharacterDTO.setHealth(null);
		assertFalse(testCharacterDTO.equals(testOtherCharacterDTO));
	}
	
	@Test
	public void CharacterDTORarityNotEqual() {
		testOtherCharacterDTO.setHealth(3L);
		assertFalse(testCharacterDTO.equals(testOtherCharacterDTO));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullRarity() {
		testCharacterDTO.setHealth(null);
		testOtherCharacterDTO.setHealth(null);
		assertTrue(testCharacterDTO.equals(testOtherCharacterDTO));
	}
	
	@Test
	public void nullId() {
		testCharacterDTOWithId.setCharacterId(null);
		assertFalse(testCharacterDTOWithId.equals(testOtherCharacterDTOWithId));
	}
	
	@Test
	public void nullIdOnBoth() {
		testCharacterDTOWithId.setCharacterId(null);
		testOtherCharacterDTOWithId.setCharacterId(null);
		assertTrue(testCharacterDTOWithId.equals(testOtherCharacterDTOWithId));
	}
    
	@Test
	public void otherIdDifferent() {
		testOtherCharacterDTOWithId.setCharacterId(2L);
		assertFalse(testCharacterDTOWithId.equals(testOtherCharacterDTOWithId));
	}
	
	@Test
	public void nullChance() {
		testCharacterDTO.setExperience(null);
		assertFalse(testCharacterDTO.equals(testOtherCharacterDTO));
	}
	
	@Test
	public void nullChanceOnBoth() {
		testCharacterDTO.setExperience(null);
		testOtherCharacterDTO.setExperience(null);
		assertTrue(testCharacterDTO.equals(testOtherCharacterDTO));
	}
	
	@Test
	public void otherChanceDifferent() {
		testOtherCharacterDTO.setExperience(10L);
		assertFalse(testCharacterDTO.equals(testOtherCharacterDTO));
	}
	
	@Test
	public void otherDescriptionDifferent() {
		testOtherCharacterDTO.setLevel(2L);
		assertFalse(testCharacterDTO.equals(testOtherCharacterDTO));
	}

	@Test
	public void nullDescription() {
		testCharacterDTO.setLevel(null);
		assertFalse(testCharacterDTO.equals(testOtherCharacterDTO));
	}
	
	@Test
	public void nullDescriptionOnBoth() {
		testCharacterDTO.setLevel(null);
		testOtherCharacterDTO.setLevel(null);
		assertTrue(testCharacterDTO.equals(testOtherCharacterDTO));
	}
		
	@Test
	public void otherPropertiesDifferent() {
		testOtherCharacterDTO.setMana(200L);
		assertFalse(testCharacterDTO.equals(testOtherCharacterDTO));
	}

	@Test
	public void nullProperties() {
		testCharacterDTO.setMana(null);
		assertFalse(testCharacterDTO.equals(testOtherCharacterDTO));
	}
	
	@Test
	public void nullPropertiesOnBoth() {
		testCharacterDTO.setMana(null);
		testOtherCharacterDTO.setMana(null);
		assertTrue(testCharacterDTO.equals(testOtherCharacterDTO));
	}

	@Test
	public void constructorWithoutId() {
		CharacterDTO customer = new CharacterDTO(100L, 0L, 1L, 100L);
		assertNull(customer.getCharacterId());
		assertNotNull(customer.getHealth());
		assertNotNull(customer.getExperience());
		assertNotNull(customer.getLevel());
		assertNotNull(customer.getMana());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(testCharacterDTO.hashCode(), testOtherCharacterDTO.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
        CharacterDTO CharacterDTO = new CharacterDTO(null, null, null, null);
        CharacterDTO.setCharacterId(null);
        CharacterDTO otherCharacterDTO = new CharacterDTO(null, null, null, null);
        otherCharacterDTO.setCharacterId(null);
		assertEquals(CharacterDTO.hashCode(), otherCharacterDTO.hashCode());
	}
}