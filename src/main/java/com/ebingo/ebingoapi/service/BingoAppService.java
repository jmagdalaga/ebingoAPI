package com.ebingo.ebingoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebingo.ebingoapi.helper.BingoCardNumHelper;
import com.ebingo.ebingoapi.model.*;
import com.ebingo.ebingoapi.repository.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class BingoAppService {

    @Autowired
    private BingoGameRepo gameRepository;

    @Autowired
    private BingoCardRepo cardRepository;

    @Autowired
    private BingoNumDrawRepo drawnNumberRepository;

    @Autowired
    private BingoCardNumRepo cardNumberRepository;

    public BingoGame createGame() {
        String gameId = generateUniqueId();
        BingoGame game = new BingoGame(gameId);
        gameRepository.save(game);
        return game;
    }

    public boolean checkGameExists(String gameId) {
        return gameRepository.existsById(gameId);
    }

    public BingoNumDraw drawNumber(String gameId) {
        int number = generateBingoNumber();
        BingoNumDraw drawnNumber = new BingoNumDraw(gameId, number);
        drawnNumberRepository.save(drawnNumber);
        return drawnNumber;
    }

    public BingoCardNumHelper createCard(String gameId) {
        String cardId = generateUniqueId();
        BingoCard card = new BingoCard(cardId, gameId);
        cardRepository.save(card);
        Map<String, List<Integer>> cardNumbersMap = generateCardNumbers(cardId);
        List<String> cardNumbersList = convertCardNumbersToStringList(cardNumbersMap);
        saveCardNumbers(cardId, cardNumbersMap); 
        return new BingoCardNumHelper(cardId, card, cardNumbersList);
    }

    private void saveCardNumbers(String cardId, Map<String, List<Integer>> cardNumbersMap) {
        for (Map.Entry<String, List<Integer>> entry : cardNumbersMap.entrySet()) {
            String letter = entry.getKey();
            List<Integer> numbers = entry.getValue();
            for (Integer number : numbers) {
                BingoCardNum cardNumber = new BingoCardNum(cardId, number);
                cardNumberRepository.save(cardNumber);
            }
        }
    }
    
    private List<String> convertCardNumbersToStringList(Map<String, List<Integer>> cardNumbersMap) {
        List<String> cardNumbersList = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : cardNumbersMap.entrySet()) {
            StringBuilder numbers = new StringBuilder();
            numbers.append(entry.getKey()).append(":").append(entry.getValue());
            cardNumbersList.add(numbers.toString());
        }
        return cardNumbersList;
    }
    

    public boolean checkWin(String cardId) {
        List<BingoCardNum> cardNumbers = cardNumberRepository.findByCardId(cardId);
        int[][] cardMatrix = generateCardMatrix(cardNumbers);
        return checkWinCondition(cardMatrix);
    }

    private String generateUniqueId() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder uniqueId = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            uniqueId.append(characters.charAt(random.nextInt(characters.length())));
        }
        return uniqueId.toString();
    }    

    private int generateBingoNumber() {
        Random random = new Random();
        return random.nextInt(75) + 1; 
    }

    private Map<String, List<Integer>> generateCardNumbers(String cardId) {
        Map<String, List<Integer>> cardNumbers = new HashMap<>();
        Random random = new Random();
        String[] letters = {"B", "I", "N", "G", "O"};
        int[] minNumbers = {1, 16, 31, 46, 61}; 
        int[] maxNumbers = {15, 30, 45, 60, 75}; 

        for (int i = 0; i < 5; i++) {
            String letter = letters[i];
            List<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                int number = random.nextInt(maxNumbers[i] - minNumbers[i] + 1) + minNumbers[i];
                numbers.add(number);
            }
            cardNumbers.put(letter, numbers);
        }
        return cardNumbers;
    }

    
    
    private boolean checkWinCondition(int[][] cardMatrix) {
        for (int i = 0; i < 5; i++) {
            if (cardMatrix[i][0] == 1 && cardMatrix[i][1] == 1 && cardMatrix[i][2] == 1 && cardMatrix[i][3] == 1 && cardMatrix[i][4] == 1) {
                return true;
            }
        }

        for (int j = 0; j < 5; j++) {
            if (cardMatrix[0][j] == 1 && cardMatrix[1][j] == 1 && cardMatrix[2][j] == 1 && cardMatrix[3][j] == 1 && cardMatrix[4][j] == 1) {
                return true;
            }
        }

        if ((cardMatrix[0][0] == 1 && cardMatrix[1][1] == 1 && cardMatrix[2][2] == 1 && cardMatrix[3][3] == 1 && cardMatrix[4][4] == 1) ||
                (cardMatrix[0][4] == 1 && cardMatrix[1][3] == 1 && cardMatrix[2][2] == 1 && cardMatrix[3][1] == 1 && cardMatrix[4][0] == 1)) {
            return true;
        }

        return false;
    }

    private int[][] generateCardMatrix(List<BingoCardNum> cardNumbers) {
        int[][] cardMatrix = new int[5][5];
        for (BingoCardNum cardNumber : cardNumbers) {
            int number = cardNumber.getNumberValue();
            int column = (number - 1) % 15; 
            int row = (number - 1) / 15; 
            if (row >= 0 && row < 5 && column >= 0 && column < 5) {
                cardMatrix[row][column] = 1; 
            } else {
                throw new IllegalStateException("Invalid card number: " + number);
            }
        }
        return cardMatrix;
    }




































    public boolean checkwin(String cardId) {
        return false;
    }

    
}
