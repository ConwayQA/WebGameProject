package com.qa.webgame.dto;

public class CharacterDTO {
    
    private Long characterId;
    private Long health;
    private Long experience;
    private Long level;
    private Long mana;

    public CharacterDTO() {
    }

    public CharacterDTO(Long health, Long experience, Long level, Long mana) {
        this.health = health;
        this.experience = experience;
        this.level = level;
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
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getMana() {
        return mana;
    }

    public void setMana(Long mana) {
        this.mana = mana;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((characterId == null) ? 0 : characterId.hashCode());
        result = prime * result + ((experience == null) ? 0 : experience.hashCode());
        result = prime * result + ((health == null) ? 0 : health.hashCode());
        result = prime * result + ((level == null) ? 0 : level.hashCode());
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
        CharacterDTO other = (CharacterDTO) obj;
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
        if (level == null) {
            if (other.level != null)
                return false;
        } else if (!level.equals(other.level))
            return false;
        if (mana == null) {
            if (other.mana != null)
                return false;
        } else if (!mana.equals(other.mana))
            return false;
        return true;
    }

    
    
}