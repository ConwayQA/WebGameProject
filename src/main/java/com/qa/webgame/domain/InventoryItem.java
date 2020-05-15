package com.qa.webgame.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "inventory_items")
public class InventoryItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "inventory_id")
    private Long inventoryId;

    @ManyToOne
    @JoinColumn(name = "character_id")
    CharacterInfo character;

    @ManyToOne
    @JoinColumn(name = "item_id")
    Item item;

    private Long position;
    private Long charges;

    public InventoryItem() {
    }

    public InventoryItem(CharacterInfo character, Item item, Long position, Long charges) {
        this.character = character;
        this.item = item;
        this.position = position;
        this.charges = charges;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public CharacterInfo getCharacter() {
        return character;
    }

    public void setCharacter(CharacterInfo character) {
        this.character = character;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public Long getCharges() {
        return charges;
    }

    public void setCharges(Long charges) {
        this.charges = charges;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((character == null) ? 0 : character.hashCode());
        result = prime * result + ((charges == null) ? 0 : charges.hashCode());
        result = prime * result + ((inventoryId == null) ? 0 : inventoryId.hashCode());
        result = prime * result + ((item == null) ? 0 : item.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InventoryItem other = (InventoryItem) obj;
        if (character == null) {
            if (other.character != null)
                return false;
        } else if (!character.equals(other.character))
            return false;
        if (charges == null) {
            if (other.charges != null)
                return false;
        } else if (!charges.equals(other.charges))
            return false;
        if (inventoryId == null) {
            if (other.inventoryId != null)
                return false;
        } else if (!inventoryId.equals(other.inventoryId))
            return false;
        if (item == null) {
            if (other.item != null)
                return false;
        } else if (!item.equals(other.item))
            return false;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        return true;
    }
    
}