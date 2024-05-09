package com.ebingo.ebingoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebingo.ebingoapi.model.BingoNumDraw;

import java.util.List;

public interface BingoNumDrawRepo extends JpaRepository<BingoNumDraw, Long> {
    List<BingoNumDraw> findByGameId(String gameId);
}
