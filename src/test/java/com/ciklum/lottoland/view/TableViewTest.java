package com.ciklum.lottoland.view;

import com.ciklum.lottoland.enums.GameResult;
import com.ciklum.lottoland.enums.Hand;
import com.ciklum.lottoland.game.Table;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.ciklum.lottoland.view.TableView.*;
import static org.junit.jupiter.api.Assertions.*;

class TableViewTest
{

    @Test
    void canCreateFromTableWithCorrectMessageP1(){
        Table table = new Table(UUID.randomUUID(), 5, 3, 4, Hand.PAPER, Hand.ROCK, GameResult.P1WIN);
        TableView tableView = TableView.fromTable(table);
        assertEquals(PLAYER_1_WINS_MESSAGE, tableView.getResult());
    }

    @Test
    void canCreateFromTableWithCorrectMessageP2(){
        Table table = new Table(UUID.randomUUID(), 5, 3, 4, Hand.PAPER, Hand.ROCK, GameResult.P2WIN);
        TableView tableView = TableView.fromTable(table);
        assertEquals(PLAYER_2_WINS_MESSAGE, tableView.getResult());
    }


    @Test
    void canCreateFromTableWithCorrectDraw(){
        Table table = new Table(UUID.randomUUID(), 5, 3, 4, Hand.PAPER, Hand.ROCK, GameResult.DRAW);
        TableView tableView = TableView.fromTable(table);
        assertEquals(DRAW_MESSAGE, tableView.getResult());
    }

    @Test
    void canCreateFromTableWithCorrectParams(){
        UUID tableId = UUID.randomUUID();
        Table table = new Table(tableId, 5, 3, 4, Hand.PAPER, Hand.ROCK, GameResult.P1WIN);
        TableView tableView = TableView.fromTable(table);
        assertEquals(tableId.toString(), tableView.getTableId());
        assertEquals(5 +3+4, tableView.getRoundsSoFar());
        assertEquals(Hand.PAPER, tableView.getLatestP1Hand());
        assertEquals(Hand.ROCK, tableView.getLatestP2Hand());
        assertEquals(PLAYER_1_WINS_MESSAGE, tableView.getResult());
    }

}
