package com.ciklum.lottoland.view;

import com.ciklum.lottoland.game.Statistics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsViewTest
{

    @Test
    void canCreateStatisticsView(){
        Statistics statistics = new Statistics(4, 5, 6);

        StatisticsView statisticsView = StatisticsView.fromStatistics(statistics);

        assertEquals(4, statisticsView.getTotalP1Wins());
        assertEquals(5, statisticsView.getTotalP2Wins());
        assertEquals(6, statisticsView.getTotalDraws());
    }
}
