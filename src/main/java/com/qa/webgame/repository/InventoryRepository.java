package com.qa.webgame.repository;

import com.qa.webgame.domain.CharacterInfo;
import com.qa.webgame.domain.InventoryItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryItem, Long>{

    void deleteAllByCharacter(CharacterInfo c);

}