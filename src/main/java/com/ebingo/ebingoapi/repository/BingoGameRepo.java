package com.ebingo.ebingoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebingo.ebingoapi.model.BingoGame;

public interface BingoGameRepo extends JpaRepository<BingoGame, String> {
}
