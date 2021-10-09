package com.ciklum.lottoland.view;

import com.ciklum.lottoland.game.Statistics;


public class StatisticsView
{
    private Integer totalP1Wins;
    private Integer totalP2Wins;
    private Integer totalDraws;


    public StatisticsView(Integer totalP1Wins, Integer totalP2Wins, Integer totalDraws)
    {
        this.totalP1Wins = totalP1Wins;
        this.totalP2Wins = totalP2Wins;
        this.totalDraws = totalDraws;
    }

    public static StatisticsView fromStatistics(Statistics statistics){
        return new StatisticsView(statistics.getTotalP1Wins().get(), statistics.getTotalP2Wins().get(), statistics.getTotalDraws().get());
    }


    public Integer getTotalP2Wins()
    {
        return totalP2Wins;
    }


    public Integer getTotalP1Wins()
    {
        return totalP1Wins;
    }


    public Integer getTotalDraws()
    {
        return totalDraws;
    }

}
