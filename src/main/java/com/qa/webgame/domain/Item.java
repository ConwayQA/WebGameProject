package com.qa.webgame.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "item_id")
    private Long itemId;
    private Long rarity;
    private Double chance;
    @Column (name = "item_description")
    private String itemDescription;
    private String properties;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    Set<InventoryItem> inventory;

    public Item() {
    }

    public Item(Long rarity, Double chance, String description, String properties) {
        this.rarity = rarity;
        this.chance = chance;
        this.itemDescription = description;
        this.properties = properties;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getRarity() {
        return rarity;
    }

    public void setRarity(Long rarity) {
        this.rarity = rarity;
    }

    public Double getChance() {
        return chance;
    }

    public void setChance(Double chance) {
        this.chance = chance;
    }

    public String getDescription() {
        return itemDescription;
    }

    public void setDescription(String description) {
        this.itemDescription = description;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((chance == null) ? 0 : chance.hashCode());
        result = prime * result + ((itemDescription == null) ? 0 : itemDescription.hashCode());
        result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
        result = prime * result + ((properties == null) ? 0 : properties.hashCode());
        result = prime * result + ((rarity == null) ? 0 : rarity.hashCode());
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
        Item other = (Item) obj;
        if (chance == null) {
            if (other.chance != null)
                return false;
        } else if (!chance.equals(other.chance))
            return false;
        if (itemDescription == null) {
            if (other.itemDescription != null)
                return false;
        } else if (!itemDescription.equals(other.itemDescription))
            return false;
        if (itemId == null) {
            if (other.itemId != null)
                return false;
        } else if (!itemId.equals(other.itemId))
            return false;
        if (properties == null) {
            if (other.properties != null)
                return false;
        } else if (!properties.equals(other.properties))
            return false;
        if (rarity == null) {
            if (other.rarity != null)
                return false;
        } else if (!rarity.equals(other.rarity))
            return false;
        return true;
    }

    

}