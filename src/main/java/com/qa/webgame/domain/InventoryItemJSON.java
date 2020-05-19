package com.qa.webgame.domain;

public class InventoryItemJSON {

    private Long characterID;
    private Long itemID;
    private Long position;
    private Long charges;


    public InventoryItemJSON() {
    }


    public InventoryItemJSON(Long characterID, Long itemID, Long position, Long charges) {
        this.characterID = characterID;
        this.itemID = itemID;
        this.position = position;
        this.charges = charges;
    }

    public Long getCharacterID() {
        return this.characterID;
    }

    public void setCharacterID(Long characterID) {
        this.characterID = characterID;
    }

    public Long getItemID() {
        return this.itemID;
    }

    public void setItemID(Long itemID) {
        this.itemID = itemID;
    }

    public Long getPosition() {
        return this.position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public Long getCharges() {
        return this.charges;
    }

    public void setCharges(Long charges) {
        this.charges = charges;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((characterID == null) ? 0 : characterID.hashCode());
        result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
        result = prime * result + ((charges == null) ? 0 : charges.hashCode());
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
        InventoryItemJSON other = (InventoryItemJSON) obj;
        if (characterID == null) {
            if (other.characterID != null)
                return false;
        } else if (!characterID.equals(other.characterID))
            return false;
        if (itemID == null) {
            if (other.itemID != null)
                return false;
        } else if (!itemID.equals(other.itemID))
            return false;
        if (charges == null) {
            if (other.charges != null)
                return false;
        } else if (!charges.equals(other.charges))
            return false;
        if (position == null) {
            if (other.position != null)
                return false;
        } else if (!position.equals(other.position))
            return false;
        return true;
    }

}