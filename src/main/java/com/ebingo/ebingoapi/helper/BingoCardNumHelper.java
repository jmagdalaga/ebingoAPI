package com.ebingo.ebingoapi.helper;

import java.util.List;

import com.ebingo.ebingoapi.model.BingoCard;

public class BingoCardNumHelper {
    private String cardId;
    private BingoCard card;
    private List<String> numbers;

    public BingoCardNumHelper(String cardId, BingoCard card, List<String> numbers) {
        this.cardId = cardId;
        this.card = card;
        this.numbers = numbers;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public BingoCard getCard() {
        return card;
    }

    public void setCard(BingoCard card) {
        this.card = card;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }
}
