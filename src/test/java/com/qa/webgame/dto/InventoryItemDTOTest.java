package com.qa.webgame.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class InventoryItemDTOTest {

    private Long id = 1L;
    private InventoryDTO testInventoryDTO;
    private InventoryDTO testInventoryDTOWithId;
    private InventoryDTO testOtherInventoryDTO;
    private InventoryDTO testOtherInventoryDTOWithId;
    private ItemDTO testItem;
    private ItemDTO testItemOther;
    
	@Before
	public void setUp() {
        testItem = new ItemDTO(1L, 4.0, "Potion of Lesser Healing:Use to recover health by 50", "consumable:1,currentHealth:50", "https://drive.google.com/uc?id=1eFd4Knyoi0klSudPerzqokqt_Dqfw3nm");
        testItemOther = new ItemDTO(2L, 5.0, "Potion of Lesser Healing:Use to recover health by 50", "consumable:1,currentHealth:50", "https://drive.google.com/uc?id=1eFd4Knyoi0klSudPerzqokqt_Dqfw3nm");
        testInventoryDTO = new InventoryDTO( testItem, 2L, 1L);
        testInventoryDTOWithId = new InventoryDTO(testInventoryDTO.getItem(), testInventoryDTO.getPosition(), testInventoryDTO.getCharges());
        testInventoryDTOWithId.setInventoryId(id);
        testOtherInventoryDTO = new InventoryDTO( testItem, 2L, 1L);
        testOtherInventoryDTOWithId = new InventoryDTO(testOtherInventoryDTO.getItem(), testOtherInventoryDTO.getPosition(), testOtherInventoryDTO.getCharges());
        testOtherInventoryDTOWithId.setInventoryId(id);
	}
	
	@Test
	public void settersTest() {
		assertNotNull(testInventoryDTOWithId.getInventoryId());
		assertNotNull(testInventoryDTOWithId.getItem());
		assertNotNull(testInventoryDTOWithId.getPosition());
		assertNotNull(testInventoryDTOWithId.getCharges());
		
		testInventoryDTOWithId.setInventoryId(null);
		assertNull(testInventoryDTOWithId.getInventoryId());
		testInventoryDTOWithId.setItem(null);
		assertNull(testInventoryDTOWithId.getItem());
		testInventoryDTOWithId.setPosition(null);
		assertNull(testInventoryDTOWithId.getPosition());
		testInventoryDTOWithId.setCharges(null);
		assertNull(testInventoryDTOWithId.getCharges());
		
	}
	
	@Test
	public void equalsWithNull() {
		assertFalse(testInventoryDTO.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(testInventoryDTO.equals(new Object()));
	}
	
	@Test
	public void checkEquality() {
		assertTrue(testInventoryDTO.equals(testInventoryDTO));
	}
	
	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(testInventoryDTO.equals(testOtherInventoryDTO));
	}
	
	@Test
	public void nullId() {
		testInventoryDTOWithId.setInventoryId(null);
		assertFalse(testInventoryDTOWithId.equals(testOtherInventoryDTOWithId));
	}
	
	@Test
	public void nullIdOnBoth() {
		testInventoryDTOWithId.setInventoryId(null);
		testOtherInventoryDTOWithId.setInventoryId(null);
		assertTrue(testInventoryDTOWithId.equals(testOtherInventoryDTOWithId));
	}
    
	@Test
	public void otherIdDifferent() {
		testOtherInventoryDTOWithId.setInventoryId(2L);
		assertFalse(testInventoryDTOWithId.equals(testOtherInventoryDTOWithId));
	}
	
	@Test
	public void nullItem() {
		testInventoryDTO.setItem(null);
		assertFalse(testInventoryDTO.equals(testOtherInventoryDTO));
	}
	
	@Test
	public void nullItemOnBoth() {
		testInventoryDTO.setItem(null);
		testOtherInventoryDTO.setItem(null);
		assertTrue(testInventoryDTO.equals(testOtherInventoryDTO));
	}
	
	@Test
	public void otherItemDifferent() {
		testOtherInventoryDTO.setItem(testItemOther);
		assertFalse(testInventoryDTO.equals(testOtherInventoryDTO));
	}
	
	@Test
	public void otherPositionDifferent() {
		testOtherInventoryDTO.setPosition(5L);
		assertFalse(testInventoryDTO.equals(testOtherInventoryDTO));
	}

	@Test
	public void nullPosition() {
		testInventoryDTO.setPosition(null);
		assertFalse(testInventoryDTO.equals(testOtherInventoryDTO));
	}
	
	@Test
	public void nullPositionOnBoth() {
		testInventoryDTO.setPosition(null);
		testOtherInventoryDTO.setPosition(null);
		assertTrue(testInventoryDTO.equals(testOtherInventoryDTO));
	}
		
	@Test
	public void otherPropertiesDifferent() {
		testOtherInventoryDTO.setCharges(200L);
		assertFalse(testInventoryDTO.equals(testOtherInventoryDTO));
	}

	@Test
	public void nullProperties() {
		testInventoryDTO.setCharges(null);
		assertFalse(testInventoryDTO.equals(testOtherInventoryDTO));
	}
	
	@Test
	public void nullPropertiesOnBoth() {
		testInventoryDTO.setCharges(null);
		testOtherInventoryDTO.setCharges(null);
		assertTrue(testInventoryDTO.equals(testOtherInventoryDTO));
	}

	@Test
	public void constructorWithoutId() {
		InventoryDTO customer = new InventoryDTO( testItem, 2L, 1L);
		assertNull(customer.getInventoryId());
		assertNotNull(customer.getItem());
		assertNotNull(customer.getPosition());
		assertNotNull(customer.getCharges());
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(testInventoryDTO.hashCode(), testOtherInventoryDTO.hashCode());
	}
	@Test
	public void hashCodeTestWithNull() {
        InventoryDTO InventoryDTO = new InventoryDTO(null, null, null);
        InventoryDTO.setInventoryId(null);
        InventoryDTO otherInventoryDTO = new InventoryDTO(null, null, null);
        otherInventoryDTO.setInventoryId(null);
		assertEquals(InventoryDTO.hashCode(), otherInventoryDTO.hashCode());
	}
}