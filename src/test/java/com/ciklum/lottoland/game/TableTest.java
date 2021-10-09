package com.ciklum.lottoland.game;

import com.ciklum.lottoland.enums.GameResult;
import com.ciklum.lottoland.enums.Hand;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TableTest
{
    @Test
    void canUpdateTable(){
        UUID tableId = UUID.randomUUID();
        Table table = new Table(tableId, 0, 0, 0, null, null, null);
        table.incrementDraws();
        table.incrementPlayer1Wins();
        table.incrementPlayer2Wins();
        table.setLatestGameResult(GameResult.DRAW);
        table.setLatestP1Hand(Hand.PAPER);
        table.setLatestP2Hand(Hand.PAPER);

        assertEquals(tableId, table.getTableId());
        assertEquals(1, table.getPlayer1Wins());
        assertEquals(1, table.getPlayer2Wins());
        assertEquals(1, table.getDraws());
        assertEquals(Hand.PAPER, table.getLatestP1Hand());
        assertEquals(Hand.PAPER, table.getLatestP2Hand());
        assertEquals(GameResult.DRAW, table.getLatestGameResult());
        assertEquals(3, table.totalRounds());
    }
}
