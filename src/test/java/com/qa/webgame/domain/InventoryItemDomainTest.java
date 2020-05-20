package com.qa.webgame.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class InventoryItemDomainTest {

    private Long id = 1L;
    private InventoryItem testInventoryItem;
    private InventoryItem testInventoryItemWithId;
    private InventoryItem testOtherInventoryItem;
    private InventoryItem testOtherInventoryItemWithId;
    private CharacterInfo testCharacter;
    private Item testItem;
    private CharacterInfo testCharacterOther;
    private Item testItemOther;
    
	@Before
	public void setUp() {
        testCharacter = new CharacterInfo(100L, 0L, 1L, 100L);
        testItem = new Item(1L, 4.0, "Potion of Lesser Healing:Use to recover health by 50", "consumable:1,currentHealth:50", "https://drive.google.com/uc?id=1eFd4Knyoi0klSudPerzqokqt_Dqfw3nm");
        testCharacterOther = new CharacterInfo(200L, 1000L, 5L, 200L);
        testItemOther = new Item(2L, 5.0, "Potion of Lesser Healing:Use to recover health by 50", "consumable:1,currentHealth:50", "https://drive.google.com/uc?id=1eFd4Knyoi0klSudPerzqokqt_Dqfw3nm");
        testInventoryItem = new InventoryItem(testCharacter, testItem, 2L, 1L);
        testInventoryItemWithId = new InventoryItem(testInventoryItem.getCharacter(), testInventoryItem.getItem(), testInventoryItem.getPosition(), testInventoryItem.getCharges());
        testInventoryItemWithId.setInventoryId(id);
        testOtherInventoryItem = new InventoryItem(testCharacter, testItem, 2L, 1L);
        testOtherInventoryItemWithId = new InventoryItem(testOtherInventoryItem.getCharacter(), testOtherInventoryItem.getItem(), testOtherInventoryItem.getPosition(), testOtherInventoryItem.getCharges());
        testOtherInventoryItemWithId.setInventoryId(id);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(testInventoryItemWithId.getInventoryId());
		assertNotNull(testInventoryItemWithId.getCharacter());
		assertNotNull(testInventoryItemWithId.getItem());
		assertNotNull(testInventoryItemWithId.getPosition());
		assertNotNull(testInventoryItemWithId.getCharges());
		
		testInventoryItemWithId.setInventoryId(null);
		assertNull(testInventoryItemWithId.getInventoryId());
		testInventoryItemWithId.setCharacter(null);
		assertNull(testInventoryItemWithId.getCharacter());
		testInventoryItemWithId.setItem(null);
		assertNull(testInventoryItemWithId.getItem());
		testInventoryItemWithId.setPosition(null);
		assertNull(testInventoryItemWithId.getPosition());
		testInventoryItemWithId.setCharges(null);
		assertNull(testInventoryItemWithId.getCharges());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(testInventoryItem.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(testInventoryItem.equals(new Object()));
	}
	
	@Test
	public void checkEquality() {
		assertTrue(testInventoryItem.equals(testInventoryItem));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(testInventoryItem.equals(testOtherInventoryItem));
	}
	
	@Test
	public void InventoryItemRarityNullButOtherRarityNotNull() {
		testInventoryItem.setCharacter(null);
		assertFalse(testInventoryItem.equals(testOtherInventoryItem));
	}
	
	@Test
	public void InventoryItemRarityNotEqual() {
		testOtherInventoryItem.setCharacter(testCharacterOther);
		assertFalse(testInventoryItem.equals(testOtherInventoryItem));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullRarity() {
		testInventoryItem.setCharacter(null);
		testOtherInventoryItem.setCharacter(null);
		assertTrue(testInventoryItem.equals(testOtherInventoryItem));
	}
	
	@Test
	public void nullId() {
		testInventoryItemWithId.setInventoryId(null);
		assertFalse(testInventoryItemWithId.equals(testOtherInventoryItemWithId));
	}
	
	@Test
	public void nullIdOnBoth() {
		testInventoryItemWithId.setInventoryId(null);
		testOtherInventoryItemWithId.setInventoryId(null);
		assertTrue(testInventoryItemWithId.equals(testOtherInventoryItemWithId));
	}
    
	@Test
	public void otherIdDifferent() {
		testOtherInventoryItemWithId.setInventoryId(2L);
		assertFalse(testInventoryItemWithId.equals(testOtherInventoryItemWithId));
	}
	
	@Test
	public void nullItem() {
		testInventoryItem.setItem(null);
		assertFalse(testInventoryItem.equals(testOtherInventoryItem));
	}
	
	@Test
	public void nullItemOnBoth() {
		testInventoryItem.setItem(null);
		testOtherInventoryItem.setItem(null);
		assertTrue(testInventoryItem.equals(testOtherInventoryItem));
	}
	
	@Test
	public void otherItemDifferent() {
		testOtherInventoryItem.setItem(testItemOther);
		assertFalse(testInventoryItem.equals(testOtherInventoryItem));
	}
	
	@Test
	public void otherPositionDifferent() {
		testOtherInventoryItem.setPosition(5L);
		assertFalse(testInventoryItem.equals(testOtherInventoryItem));
	}

	@Test
	public void nullPosition() {
		testInventoryItem.setPosition(null);
		assertFalse(testInventoryItem.equals(testOtherInventoryItem));
	}
	
	@Test
	public void nullPositionOnBoth() {
		testInventoryItem.setPosition(null);
		testOtherInventoryItem.setPosition(null);
		assertTrue(testInventoryItem.equals(testOtherInventoryItem));
	}
		
	@Test
	public void otherPropertiesDifferent() {
		testOtherInventoryItem.setCharges(200L);
		assertFalse(testInventoryItem.equals(testOtherInventoryItem));
	}

	@Test
	public void nullProperties() {
		testInventoryItem.setCharges(null);
		assertFalse(testInventoryItem.equals(testOtherInventoryItem));
	}
	
	@Test
	public void nullPropertiesOnBoth() {
		testInventoryItem.setCharges(null);
		testOtherInventoryItem.setCharges(null);
		assertTrue(testInventoryItem.equals(testOtherInventoryItem));
	}

	@Test
	public void constructorWithoutId() {
		InventoryItem customer = new InventoryItem(testCharacter, testItem, 2L, 1L);
		assertNull(customer.getInventoryId());
		assertNotNull(customer.getCharacter());
		assertNotNull(customer.getItem());
		assertNotNull(customer.getPosition());
		assertNotNull(customer.getCharges());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(testInventoryItem.hashCode(), testOtherInventoryItem.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
        InventoryItem InventoryItem = new InventoryItem(null, null, null, null);
        InventoryItem.setInventoryId(null);
        InventoryItem otherInventoryItem = new InventoryItem(null, null, null, null);
        otherInventoryItem.setInventoryId(null);
		assertEquals(InventoryItem.hashCode(), otherInventoryItem.hashCode());
	}
}