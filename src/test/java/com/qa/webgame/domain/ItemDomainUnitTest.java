package com.qa.webgame.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemDomainUnitTest {

    private Long id = 1L;
    private Item testItem;
    private Item testItemWithId;
    private Item testOtherItem;
    private Item testOtherItemWithId;
	
	@Before
	public void setUp() {
        testItem = new Item(1L, 4.0, "Potion of Lesser Healing:Use to recover health by 50", "consumable:1,currentHealth:50", "https://drive.google.com/uc?id=1eFd4Knyoi0klSudPerzqokqt_Dqfw3nm");
        testItemWithId = new Item(testItem.getRarity(), testItem.getChance(), testItem.getDescription(), testItem.getProperties(), testItem.getImgUrl());
        testItemWithId.setItemId(id);
        testOtherItem = new Item(1L, 4.0, "Potion of Lesser Healing:Use to recover health by 50", "consumable:1,currentHealth:50", "https://drive.google.com/uc?id=1eFd4Knyoi0klSudPerzqokqt_Dqfw3nm");
        testOtherItemWithId = new Item(testOtherItem.getRarity(), testOtherItem.getChance(), testOtherItem.getDescription(), testOtherItem.getProperties(), testItem.getImgUrl());
        testOtherItemWithId.setItemId(id);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(testItemWithId.getItemId());
		assertNotNull(testItemWithId.getRarity());
		assertNotNull(testItemWithId.getChance());
		assertNotNull(testItemWithId.getDescription());
		assertNotNull(testItemWithId.getProperties());
		assertNotNull(testItemWithId.getImgUrl());
		
		testItemWithId.setItemId(null);
		assertNull(testItemWithId.getItemId());
		testItemWithId.setRarity(null);
		assertNull(testItemWithId.getRarity());
		testItemWithId.setChance(null);
		assertNull(testItemWithId.getChance());
		testItemWithId.setDescription(null);
		assertNull(testItemWithId.getDescription());
		testItemWithId.setProperties(null);
		assertNull(testItemWithId.getProperties());
		testItemWithId.setImgUrl(null);
		assertNull(testItemWithId.getImgUrl());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(testItem.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(testItem.equals(new Object()));
	}
	
	@Test
	public void checkEquality() {
		assertTrue(testItem.equals(testItem));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(testItem.equals(testOtherItem));
	}
	
	@Test
	public void itemRarityNullButOtherRarityNotNull() {
		testItem.setRarity(null);
		assertFalse(testItem.equals(testOtherItem));
	}
	
	@Test
	public void itemRarityNotEqual() {
		testOtherItem.setRarity(3L);
		assertFalse(testItem.equals(testOtherItem));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullRarity() {
		testItem.setRarity(null);
		testOtherItem.setRarity(null);
		assertTrue(testItem.equals(testOtherItem));
	}
	
	@Test
	public void nullId() {
		testItemWithId.setItemId(null);
		assertFalse(testItemWithId.equals(testOtherItemWithId));
	}
	
	@Test
	public void nullIdOnBoth() {
		testItemWithId.setItemId(null);
		testOtherItemWithId.setItemId(null);
		assertTrue(testItemWithId.equals(testOtherItemWithId));
	}
    
	@Test
	public void otherIdDifferent() {
		testOtherItemWithId.setItemId(2L);
		assertFalse(testItemWithId.equals(testOtherItemWithId));
	}
	
	@Test
	public void nullChance() {
		testItem.setChance(null);
		assertFalse(testItem.equals(testOtherItem));
	}
	
	@Test
	public void nullChanceOnBoth() {
		testItem.setChance(null);
		testOtherItem.setChance(null);
		assertTrue(testItem.equals(testOtherItem));
	}
	
	@Test
	public void otherChanceDifferent() {
		testOtherItem.setChance(10.0);
		assertFalse(testItem.equals(testOtherItem));
	}
	
	@Test
	public void otherDescriptionDifferent() {
		testOtherItem.setDescription("Sword of Average Power");
		assertFalse(testItem.equals(testOtherItem));
	}

	@Test
	public void nullDescription() {
		testItem.setDescription(null);
		assertFalse(testItem.equals(testOtherItem));
	}
	
	@Test
	public void nullDescriptionOnBoth() {
		testItem.setDescription(null);
		testOtherItem.setDescription(null);
		assertTrue(testItem.equals(testOtherItem));
	}
		
	@Test
	public void otherPropertiesDifferent() {
		testOtherItem.setProperties("attack:10,defense:9,magic:5");
		assertFalse(testItem.equals(testOtherItem));
	}

	@Test
	public void nullProperties() {
		testItem.setProperties(null);
		assertFalse(testItem.equals(testOtherItem));
	}
	
	@Test
	public void nullPropertiesOnBoth() {
		testItem.setProperties(null);
		testOtherItem.setProperties(null);
		assertTrue(testItem.equals(testOtherItem));
	}

	@Test
	public void otherImgUrlDifferent() {
		testOtherItem.setImgUrl("attack:10,defense:9,magic:5");
		assertFalse(testItem.equals(testOtherItem));
	}

	@Test
	public void nullImgUrl() {
		testItem.setImgUrl(null);
		assertFalse(testItem.equals(testOtherItem));
	}
	
	@Test
	public void nullImgUrlOnBoth() {
		testItem.setImgUrl(null);
		testOtherItem.setImgUrl(null);
		assertTrue(testItem.equals(testOtherItem));
	}

	@Test
	public void constructorWithoutId() {
		Item customer = new Item(1L, 4.0, "Potion of Lesser Healing:Use to recover health by 50", "consumable:1,currentHealth:50", "https://drive.google.com/uc?id=1eFd4Knyoi0klSudPerzqokqt_Dqfw3nm");
		assertNull(customer.getItemId());
		assertNotNull(customer.getRarity());
		assertNotNull(customer.getChance());
		assertNotNull(customer.getDescription());
		assertNotNull(customer.getProperties());
		assertNotNull(customer.getImgUrl());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(testItem.hashCode(), testOtherItem.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
        Item item = new Item(null, null, null, null, null);
        item.setItemId(null);
        Item otherItem = new Item(null, null, null, null, null);
        otherItem.setItemId(null);
		assertEquals(item.hashCode(), otherItem.hashCode());
	}
}