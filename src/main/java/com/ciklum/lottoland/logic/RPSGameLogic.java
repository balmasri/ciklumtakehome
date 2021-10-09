package com.ciklum.lottoland.logic;

import com.ciklum.lottoland.enums.GameResult;
import com.ciklum.lottoland.enums.Hand;

import java.util.Map;

import static com.ciklum.lottoland.enums.GameResult.*;
import static com.ciklum.lottoland.enums.Hand.*;
import static com.ciklum.lottoland.enums.Hand.ROCK;

public final class RPSGameLogic
{

    private static Map<Hand, Hand> wins = Map.of(ROCK, SCISSORS, PAPER, ROCK, SCISSORS, PAPER);


    public static GameResult playGame(Hand hand1, Hand hand2)
    {
        if (hand1 == hand2)
        {
            return DRAW;
        }

        if(wins.get(hand1) == hand2){
            return P1WIN;
        }
        else{
            return P2WIN;
        }
    }
}
