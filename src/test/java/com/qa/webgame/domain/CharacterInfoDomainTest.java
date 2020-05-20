package com.qa.webgame.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CharacterInfoDomainTest {

    private Long id = 1L;
    private CharacterInfo testCharacterInfo;
    private CharacterInfo testCharacterInfoWithId;
    private CharacterInfo testOtherCharacterInfo;
    private CharacterInfo testOtherCharacterInfoWithId;
	
	@Before
	public void setUp() {
        testCharacterInfo = new CharacterInfo(100L, 0L, 1L, 100L);
        testCharacterInfoWithId = new CharacterInfo(testCharacterInfo.getHealth(), testCharacterInfo.getExperience(), testCharacterInfo.getLevel(), testCharacterInfo.getMana());
        testCharacterInfoWithId.setCharacterId(id);
        testOtherCharacterInfo = new CharacterInfo(100L, 0L, 1L, 100L);
        testOtherCharacterInfoWithId = new CharacterInfo(testOtherCharacterInfo.getHealth(), testOtherCharacterInfo.getExperience(), testOtherCharacterInfo.getLevel(), testOtherCharacterInfo.getMana());
        testOtherCharacterInfoWithId.setCharacterId(id);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(testCharacterInfoWithId.getCharacterId());
		assertNotNull(testCharacterInfoWithId.getHealth());
		assertNotNull(testCharacterInfoWithId.getExperience());
		assertNotNull(testCharacterInfoWithId.getLevel());
		assertNotNull(testCharacterInfoWithId.getMana());
		
		testCharacterInfoWithId.setCharacterId(null);
		assertNull(testCharacterInfoWithId.getCharacterId());
		testCharacterInfoWithId.setHealth(null);
		assertNull(testCharacterInfoWithId.getHealth());
		testCharacterInfoWithId.setExperience(null);
		assertNull(testCharacterInfoWithId.getExperience());
		testCharacterInfoWithId.setLevel(null);
		assertNull(testCharacterInfoWithId.getLevel());
		testCharacterInfoWithId.setMana(null);
		assertNull(testCharacterInfoWithId.getMana());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(testCharacterInfo.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(testCharacterInfo.equals(new Object()));
	}
	
	@Test
	public void checkEquality() {
		assertTrue(testCharacterInfo.equals(testCharacterInfo));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(testCharacterInfo.equals(testOtherCharacterInfo));
	}
	
	@Test
	public void CharacterInfoRarityNullButOtherRarityNotNull() {
		testCharacterInfo.setHealth(null);
		assertFalse(testCharacterInfo.equals(testOtherCharacterInfo));
	}
	
	@Test
	public void CharacterInfoRarityNotEqual() {
		testOtherCharacterInfo.setHealth(3L);
		assertFalse(testCharacterInfo.equals(testOtherCharacterInfo));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullRarity() {
		testCharacterInfo.setHealth(null);
		testOtherCharacterInfo.setHealth(null);
		assertTrue(testCharacterInfo.equals(testOtherCharacterInfo));
	}
	
	@Test
	public void nullId() {
		testCharacterInfoWithId.setCharacterId(null);
		assertFalse(testCharacterInfoWithId.equals(testOtherCharacterInfoWithId));
	}
	
	@Test
	public void nullIdOnBoth() {
		testCharacterInfoWithId.setCharacterId(null);
		testOtherCharacterInfoWithId.setCharacterId(null);
		assertTrue(testCharacterInfoWithId.equals(testOtherCharacterInfoWithId));
	}
    
	@Test
	public void otherIdDifferent() {
		testOtherCharacterInfoWithId.setCharacterId(2L);
		assertFalse(testCharacterInfoWithId.equals(testOtherCharacterInfoWithId));
	}
	
	@Test
	public void nullChance() {
		testCharacterInfo.setExperience(null);
		assertFalse(testCharacterInfo.equals(testOtherCharacterInfo));
	}
	
	@Test
	public void nullChanceOnBoth() {
		testCharacterInfo.setExperience(null);
		testOtherCharacterInfo.setExperience(null);
		assertTrue(testCharacterInfo.equals(testOtherCharacterInfo));
	}
	
	@Test
	public void otherChanceDifferent() {
		testOtherCharacterInfo.setExperience(10L);
		assertFalse(testCharacterInfo.equals(testOtherCharacterInfo));
	}
	
	@Test
	public void otherDescriptionDifferent() {
		testOtherCharacterInfo.setLevel(2L);
		assertFalse(testCharacterInfo.equals(testOtherCharacterInfo));
	}

	@Test
	public void nullDescription() {
		testCharacterInfo.setLevel(null);
		assertFalse(testCharacterInfo.equals(testOtherCharacterInfo));
	}
	
	@Test
	public void nullDescriptionOnBoth() {
		testCharacterInfo.setLevel(null);
		testOtherCharacterInfo.setLevel(null);
		assertTrue(testCharacterInfo.equals(testOtherCharacterInfo));
	}
		
	@Test
	public void otherPropertiesDifferent() {
		testOtherCharacterInfo.setMana(200L);
		assertFalse(testCharacterInfo.equals(testOtherCharacterInfo));
	}

	@Test
	public void nullProperties() {
		testCharacterInfo.setMana(null);
		assertFalse(testCharacterInfo.equals(testOtherCharacterInfo));
	}
	
	@Test
	public void nullPropertiesOnBoth() {
		testCharacterInfo.setMana(null);
		testOtherCharacterInfo.setMana(null);
		assertTrue(testCharacterInfo.equals(testOtherCharacterInfo));
	}

	@Test
	public void constructorWithoutId() {
		CharacterInfo customer = new CharacterInfo(100L, 0L, 1L, 100L);
		assertNull(customer.getCharacterId());
		assertNotNull(customer.getHealth());
		assertNotNull(customer.getExperience());
		assertNotNull(customer.getLevel());
		assertNotNull(customer.getMana());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(testCharacterInfo.hashCode(), testOtherCharacterInfo.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
        CharacterInfo CharacterInfo = new CharacterInfo(null, null, null, null);
        CharacterInfo.setCharacterId(null);
        CharacterInfo otherCharacterInfo = new CharacterInfo(null, null, null, null);
        otherCharacterInfo.setCharacterId(null);
		assertEquals(CharacterInfo.hashCode(), otherCharacterInfo.hashCode());
	}
}