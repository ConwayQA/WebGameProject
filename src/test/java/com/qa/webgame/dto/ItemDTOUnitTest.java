package com.qa.webgame.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemDTOUnitTest {

    private Long id = 1L;
    private ItemDTO testItemDTO;
    private ItemDTO testItemDTOWithId;
    private ItemDTO testOtherItemDTO;
    private ItemDTO testOtherItemDTOWithId;
	
	@Before
	public void setUp() {
        testItemDTO = new ItemDTO(5L, 0.1, "Sword of ultimate power", "attack:100,defense:90,magic:50");
        testItemDTOWithId = new ItemDTO(testItemDTO.getRarity(), testItemDTO.getChance(), testItemDTO.getDescription(), testItemDTO.getProperties());
        testItemDTOWithId.setItemId(id);
        testOtherItemDTO = new ItemDTO(5L, 0.1, "Sword of ultimate power", "attack:100,defense:90,magic:50");
        testOtherItemDTOWithId = new ItemDTO(testOtherItemDTO.getRarity(), testOtherItemDTO.getChance(), testOtherItemDTO.getDescription(), testOtherItemDTO.getProperties());
        testOtherItemDTOWithId.setItemId(id);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(testItemDTOWithId.getItemId());
		assertNotNull(testItemDTOWithId.getRarity());
		assertNotNull(testItemDTOWithId.getChance());
		assertNotNull(testItemDTOWithId.getDescription());
		assertNotNull(testItemDTOWithId.getProperties());
		
		testItemDTOWithId.setItemId(null);
		assertNull(testItemDTOWithId.getItemId());
		testItemDTOWithId.setRarity(null);
		assertNull(testItemDTOWithId.getRarity());
		testItemDTOWithId.setChance(null);
		assertNull(testItemDTOWithId.getChance());
		testItemDTOWithId.setDescription(null);
		assertNull(testItemDTOWithId.getDescription());
		testItemDTOWithId.setProperties(null);
		assertNull(testItemDTOWithId.getProperties());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(testItemDTO.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(testItemDTO.equals(new Object()));
	}
	
	@Test
	public void checkEquality() {
		assertTrue(testItemDTO.equals(testItemDTO));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(testItemDTO.equals(testOtherItemDTO));
	}
	
	@Test
	public void ItemDTORarityNullButOtherRarityNotNull() {
		testItemDTO.setRarity(null);
		assertFalse(testItemDTO.equals(testOtherItemDTO));
	}
	
	@Test
	public void ItemDTORarityNotEqual() {
		testOtherItemDTO.setRarity(3L);
		assertFalse(testItemDTO.equals(testOtherItemDTO));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjectsNullRarity() {
		testItemDTO.setRarity(null);
		testOtherItemDTO.setRarity(null);
		assertTrue(testItemDTO.equals(testOtherItemDTO));
	}
	
	@Test
	public void nullId() {
		testItemDTOWithId.setItemId(null);
		assertFalse(testItemDTOWithId.equals(testOtherItemDTOWithId));
	}
	
	@Test
	public void nullIdOnBoth() {
		testItemDTOWithId.setItemId(null);
		testOtherItemDTOWithId.setItemId(null);
		assertTrue(testItemDTOWithId.equals(testOtherItemDTOWithId));
	}
    
	@Test
	public void otherIdDifferent() {
		testOtherItemDTOWithId.setItemId(2L);
		assertFalse(testItemDTOWithId.equals(testOtherItemDTOWithId));
	}
	
	@Test
	public void nullChance() {
		testItemDTO.setChance(null);
		assertFalse(testItemDTO.equals(testOtherItemDTO));
	}
	
	@Test
	public void nullChanceOnBoth() {
		testItemDTO.setChance(null);
		testOtherItemDTO.setChance(null);
		assertTrue(testItemDTO.equals(testOtherItemDTO));
	}
	
	@Test
	public void otherChanceDifferent() {
		testOtherItemDTO.setChance(10.0);
		assertFalse(testItemDTO.equals(testOtherItemDTO));
	}
		
	@Test
	public void otherDescriptionDifferent() {
		testOtherItemDTO.setDescription("Sword of Average Power");
		assertFalse(testItemDTO.equals(testOtherItemDTO));
	}

	@Test
	public void nullDescription() {
		testItemDTO.setDescription(null);
		assertFalse(testItemDTO.equals(testOtherItemDTO));
	}
	
	@Test
	public void nullDescriptionOnBoth() {
		testItemDTO.setDescription(null);
		testOtherItemDTO.setDescription(null);
		assertTrue(testItemDTO.equals(testOtherItemDTO));
	}
		
	@Test
	public void otherPropertiesDifferent() {
		testOtherItemDTO.setProperties("attack:10,defense:9,magic:5");
		assertFalse(testItemDTO.equals(testOtherItemDTO));
	}

	@Test
	public void nullProperties() {
		testItemDTO.setProperties(null);
		assertFalse(testItemDTO.equals(testOtherItemDTO));
	}
	
	@Test
	public void nullPropertiesOnBoth() {
		testItemDTO.setProperties(null);
		testOtherItemDTO.setProperties(null);
		assertTrue(testItemDTO.equals(testOtherItemDTO));
	}
	
	@Test
	public void constructorWithoutId() {
		ItemDTO customer = new ItemDTO(5L, 0.1, "Sword of ultimate power", "attack:100,defense:90,magic:50");
		assertNull(customer.getItemId());
		assertNotNull(customer.getRarity());
		assertNotNull(customer.getChance());
		assertNotNull(customer.getDescription());
		assertNotNull(customer.getProperties());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(testItemDTO.hashCode(), testOtherItemDTO.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
        ItemDTO ItemDTO = new ItemDTO(null, null, null, null);
        ItemDTO.setItemId(null);
        ItemDTO otherItemDTO = new ItemDTO(null, null, null, null);
        otherItemDTO.setItemId(null);
		assertEquals(ItemDTO.hashCode(), otherItemDTO.hashCode());
	}
}