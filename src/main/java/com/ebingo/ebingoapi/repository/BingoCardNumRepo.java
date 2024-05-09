package com.ebingo.ebingoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebingo.ebingoapi.model.BingoCardNum;

import java.util.List;

public interface BingoCardNumRepo extends JpaRepository<BingoCardNum, Long> {
    List<BingoCardNum> findByCardId(String cardId);
}
