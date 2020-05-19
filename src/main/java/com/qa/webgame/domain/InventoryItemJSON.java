package com.qa.webgame.domain;

public class InventoryItemJSON {

    private Long CharacterID;
    private Long ItemID;
    private Long position;
    private Long charges;


    public InventoryItemJSON() {
    }


    public InventoryItemJSON(Long CharacterID, Long ItemID, Long position, Long charges) {
        this.CharacterID = CharacterID;
        this.ItemID = ItemID;
        this.position = position;
        this.charges = charges;
    }

    public Long getCharacterID() {
        return this.CharacterID;
    }

    public void setCharacterID(Long CharacterID) {
        this.CharacterID = CharacterID;
    }

    public Long getItemID() {
        return this.ItemID;
    }

    public void setItemID(Long ItemID) {
        this.ItemID = ItemID;
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
        result = prime * result + ((CharacterID == null) ? 0 : CharacterID.hashCode());
        result = prime * result + ((ItemID == null) ? 0 : ItemID.hashCode());
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
        if (CharacterID == null) {
            if (other.CharacterID != null)
                return false;
        } else if (!CharacterID.equals(other.CharacterID))
            return false;
        if (ItemID == null) {
            if (other.ItemID != null)
                return false;
        } else if (!ItemID.equals(other.ItemID))
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