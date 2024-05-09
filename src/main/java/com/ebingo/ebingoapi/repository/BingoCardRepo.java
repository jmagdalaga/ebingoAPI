package com.ebingo.ebingoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ebingo.ebingoapi.model.BingoCard;

public interface BingoCardRepo extends JpaRepository<BingoCard, String> {
}
