package com.ciklum.lottoland.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest
{
    @Test
    public void canUpdateStatistics(){
        Statistics statistics = new Statistics(0, 0, 0);

        statistics.incrementTotalP2Wins();
        statistics.incrementTotalP1Wins();
        statistics.incrementTotalDraws();

        assertEquals(1, statistics.getTotalDraws().get());
        assertEquals(1, statistics.getTotalP1Wins().get());
        assertEquals(1, statistics.getTotalP2Wins().get());
    }

}
