package com.qa.webgame.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "character_info")
public class CharacterInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "character_id")
    private Long characterId;
    private Long health;
    private Long experience;
    @Column (name = "current_level")
    private Long currentLevel;
    private Long mana;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "character", cascade = CascadeType.REMOVE)
    Set<InventoryItem> inventory;

    public CharacterInfo() {
    }

    public CharacterInfo(Long health, Long experience, Long level, Long mana) {
        this.health = health;
        this.experience = experience;
        this.currentLevel = level;
        this.mana = mana;
    }

    public Long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(Long characterId) {
        this.characterId = characterId;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public Long getLevel() {
        return currentLevel;
    }

    public void setLevel(Long level) {
        this.currentLevel = level;
    }

    public Long getMana() {
        return mana;
    }

    public void setMana(Long mana) {
        this.mana = mana;
    }

    public Set<InventoryItem> getInventory() {
        return inventory;
    }

    public void setInventory(Set<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((characterId == null) ? 0 : characterId.hashCode());
        result = prime * result + ((experience == null) ? 0 : experience.hashCode());
        result = prime * result + ((health == null) ? 0 : health.hashCode());
        result = prime * result + ((currentLevel == null) ? 0 : currentLevel.hashCode());
        result = prime * result + ((mana == null) ? 0 : mana.hashCode());
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
        CharacterInfo other = (CharacterInfo) obj;
        if (characterId == null) {
            if (other.characterId != null)
                return false;
        } else if (!characterId.equals(other.characterId))
            return false;
        if (experience == null) {
            if (other.experience != null)
                return false;
        } else if (!experience.equals(other.experience))
            return false;
        if (health == null) {
            if (other.health != null)
                return false;
        } else if (!health.equals(other.health))
            return false;
        if (currentLevel == null) {
            if (other.currentLevel != null)
                return false;
        } else if (!currentLevel.equals(other.currentLevel))
            return false;
        if (mana == null) {
            if (other.mana != null)
                return false;
        } else if (!mana.equals(other.mana))
            return false;
        return true;
    }
    
}