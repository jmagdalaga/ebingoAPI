package com.ebingo.ebingoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BingoNumDraw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drawnNumberId;
    private String gameId;
    private int numberValue;

    public BingoNumDraw() {}

    public BingoNumDraw(String gameId, int numberValue) {
        this.gameId = gameId;
        this.numberValue = numberValue;
    }

    public Long getDrawnNumberId() {
        return drawnNumberId;
    }

    public void setDrawnNumberId(Long drawnNumberId) {
        this.drawnNumberId = drawnNumberId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public int getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(int numberValue) {
        this.numberValue = numberValue;
    }
}
