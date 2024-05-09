package com.ebingo.ebingoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ebingo.ebingoapi.helper.BingoCardNumHelper;
import com.ebingo.ebingoapi.model.*;
import com.ebingo.ebingoapi.service.BingoAppService;

@RestController
@RequestMapping("/ebingo")
public class BingoAppController {

    @Autowired
    private BingoAppService bingoService;

    @PostMapping("/create-bingo-game")
    public ResponseEntity<BingoGame> createGame() {
        BingoGame game = bingoService.createGame();
        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }

    @PostMapping("/create-bingo-card/{gameId}")
    public ResponseEntity<BingoCardNumHelper> createCard(@PathVariable String gameId) {
        BingoCardNumHelper cardWithNumbers = bingoService.createCard(gameId);
        return new ResponseEntity<>(cardWithNumbers, HttpStatus.CREATED);
    } 

    @GetMapping("/check-bingo-game/{gameId}")
    public int checkGameExists(@PathVariable String gameId) {
        return bingoService.checkGameExists(gameId) ? 1 : 0;
    }

    @PostMapping("/bingo-num-draw/{gameId}")
    public ResponseEntity<BingoNumDraw> drawNumber(@PathVariable String gameId) {
        BingoNumDraw drawnNumber = bingoService.drawNumber(gameId);
        return new ResponseEntity<>(drawnNumber, HttpStatus.CREATED);
    }   

    @GetMapping("/check-winner/{cardId}")
    public int checkWin(@PathVariable String cardId) {
        return bingoService.checkwin(cardId) ? 1 : 0;
    }
}
