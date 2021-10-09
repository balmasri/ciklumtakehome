package com.ciklum.lottoland.game;


import java.util.concurrent.atomic.AtomicInteger;

public class Statistics
{
    private AtomicInteger totalP1Wins;
    private AtomicInteger totalP2Wins;
    private AtomicInteger totalDraws;


    public Statistics()
    {
        this.totalP1Wins = new AtomicInteger();
        this.totalP2Wins = new AtomicInteger();
        this.totalDraws = new AtomicInteger();
    }


    public Statistics(Integer totalP1Wins, Integer totalP2Wins, Integer totalDraws)
    {
        this.totalP1Wins = new AtomicInteger(totalP1Wins);
        this.totalP2Wins = new AtomicInteger(totalP2Wins);
        this.totalDraws = new AtomicInteger(totalDraws);
    }


    public AtomicInteger getTotalP1Wins()
    {
        return totalP1Wins;
    }


    public AtomicInteger getTotalP2Wins()
    {
        return totalP2Wins;
    }


    public AtomicInteger getTotalDraws()
    {
        return totalDraws;
    }


    public void incrementTotalDraws()
    {
        this.totalDraws.incrementAndGet();
    }


    public void incrementTotalP2Wins()
    {
        this.totalP2Wins.incrementAndGet();
    }


    public void incrementTotalP1Wins()
    {
        this.totalP1Wins.incrementAndGet();
    }


}
