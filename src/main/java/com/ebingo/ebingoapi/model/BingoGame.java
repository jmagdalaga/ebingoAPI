package com.ebingo.ebingoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BingoGame {
    @Id
    private String gameId;

    public BingoGame() {}

    public BingoGame(String gameId) {
        this.gameId = gameId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
