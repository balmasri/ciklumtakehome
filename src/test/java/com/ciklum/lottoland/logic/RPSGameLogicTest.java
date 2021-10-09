package com.ciklum.lottoland.logic;

import com.ciklum.lottoland.enums.GameResult;
import com.ciklum.lottoland.enums.Hand;
import org.junit.jupiter.api.Test;

import static com.ciklum.lottoland.enums.Hand.*;
import static org.junit.jupiter.api.Assertions.*;

class RPSGameLogicTest
{
    @Test
    void testAllCombinations(){
        assertEquals(GameResult.P2WIN,RPSGameLogic.playGame(ROCK, PAPER));
        assertEquals(GameResult.P1WIN,RPSGameLogic.playGame(PAPER, ROCK));
        assertEquals(GameResult.P2WIN,RPSGameLogic.playGame(PAPER, SCISSORS));
        assertEquals(GameResult.P1WIN,RPSGameLogic.playGame(SCISSORS, PAPER));
        assertEquals(GameResult.P1WIN,RPSGameLogic.playGame(ROCK, SCISSORS));
        assertEquals(GameResult.P2WIN,RPSGameLogic.playGame(SCISSORS, ROCK));
        assertEquals(GameResult.DRAW,RPSGameLogic.playGame(PAPER, PAPER));
        assertEquals(GameResult.DRAW,RPSGameLogic.playGame(ROCK, ROCK));
        assertEquals(GameResult.DRAW,RPSGameLogic.playGame(SCISSORS, SCISSORS));
    }

}
