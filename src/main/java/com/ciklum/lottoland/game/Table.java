package com.ciklum.lottoland.game;

import com.ciklum.lottoland.enums.GameResult;
import com.ciklum.lottoland.enums.Hand;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Table
{
    private UUID tableId;
    //keeping them in case we ever lost the data in statistics to be able to reproduce
    private AtomicInteger player1Wins;
    private AtomicInteger player2Wins;
    private AtomicInteger draws;
    private Hand latestP1Hand;
    private Hand latestP2Hand;
    private GameResult latestGameResult;


    public Table(UUID tableId, Integer player1Wins, Integer player2Wins, Integer draws, Hand latestP1Hand, Hand latestP2Hand, GameResult latestGameResult)
    {
        this.tableId = tableId;
        this.player1Wins = new AtomicInteger(player1Wins);
        this.player2Wins = new AtomicInteger(player2Wins);
        this.draws = new AtomicInteger(draws);
        this.latestP1Hand = latestP1Hand;
        this.latestP2Hand = latestP2Hand;
        this.latestGameResult = latestGameResult;
    }


    public Integer getDraws()
    {
        return draws.get();
    }


    public Integer getPlayer2Wins()
    {
        return player2Wins.get();
    }


    public Integer getPlayer1Wins()
    {
        return player1Wins.get();
    }

    public Integer totalRounds()
    {
        return player1Wins.get() + player2Wins.get() + draws.get();
    }


    public UUID getTableId()
    {
        return tableId;
    }


    public Hand getLatestP2Hand()
    {
        return latestP2Hand;
    }


    public Hand getLatestP1Hand()
    {
        return latestP1Hand;
    }


    public void setLatestP1Hand(Hand latestP1Hand)
    {
        this.latestP1Hand = latestP1Hand;
    }


    public void setLatestP2Hand(Hand latestP2Hand)
    {
        this.latestP2Hand = latestP2Hand;
    }


    public void setLatestGameResult(GameResult latestGameResult)
    {
        this.latestGameResult = latestGameResult;
    }


    public void incrementDraws()
    {
        this.draws.incrementAndGet();
    }


    public void incrementPlayer1Wins()
    {
        this.player1Wins.incrementAndGet();
    }


    public void incrementPlayer2Wins()
    {
        this.player2Wins.incrementAndGet();
    }


    public GameResult getLatestGameResult()
    {
        return latestGameResult;
    }

}
