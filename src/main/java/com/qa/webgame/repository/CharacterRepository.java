package com.qa.webgame.repository;

import com.qa.webgame.domain.CharacterInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterInfo, Long>{
    
}