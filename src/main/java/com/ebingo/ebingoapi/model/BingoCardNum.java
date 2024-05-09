package com.ebingo.ebingoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BingoCardNum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardNumberId;
    private String cardId;
    private int numberValue;

    public BingoCardNum() {}

    public BingoCardNum(String cardId, int numberValue) {
        this.cardId = cardId;
        this.numberValue = numberValue;
    }

    public Long getCardNumberId() {
        return cardNumberId;
    }

    public void setCardNumberId(Long cardNumberId) {
        this.cardNumberId = cardNumberId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(int numberValue) {
        this.numberValue = numberValue;
    }
}
