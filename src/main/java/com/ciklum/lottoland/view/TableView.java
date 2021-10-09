package com.ciklum.lottoland.view;

import com.ciklum.lottoland.enums.Hand;
import com.ciklum.lottoland.game.Table;

import java.util.Objects;

public class TableView
{
    public static final String PLAYER_1_WINS_MESSAGE = "Player 1 Wins!";
    public static final String PLAYER_2_WINS_MESSAGE = "Player 2 Wins!";
    public static final String DRAW_MESSAGE = "DRAW";
    private final Integer roundsSoFar;
    private final String result;
    private final Hand latestP1Hand;
    private final Hand latestP2Hand;
    private final String tableId;


    public TableView(Integer roundsSoFar, String result, Hand latestP1Hand, Hand latestP2Hand, String tableId)
    {
        this.roundsSoFar = roundsSoFar;
        this.result = result;
        this.latestP1Hand = latestP1Hand;
        this.latestP2Hand = latestP2Hand;
        this.tableId = tableId;
    }

    public static TableView fromTable(Table table){
        String result  = "";
        if(table.getLatestGameResult() != null)
        {
            switch (table.getLatestGameResult())
            {
                case P1WIN:
                    result = PLAYER_1_WINS_MESSAGE;
                    break;
                case P2WIN:
                    result = PLAYER_2_WINS_MESSAGE;
                    break;
                case DRAW:
                    result = DRAW_MESSAGE;
                    break;
            }
        }

        return new TableView(table.totalRounds(), result, table.getLatestP1Hand(), table.getLatestP2Hand(), table.getTableId().toString());
    }


    public Hand getLatestP1Hand()
    {
        return latestP1Hand;
    }


    public String getResult()
    {
        return result;
    }


    public Integer getRoundsSoFar()
    {
        return roundsSoFar;
    }


    public Hand getLatestP2Hand()
    {
        return latestP2Hand;
    }


    public String getTableId()
    {
        return tableId;
    }


    @Override public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TableView tableView = (TableView) o;
        return Objects.equals(roundsSoFar, tableView.roundsSoFar) &&
            Objects.equals(result, tableView.result) &&
            latestP1Hand == tableView.latestP1Hand &&
            latestP2Hand == tableView.latestP2Hand &&
            Objects.equals(tableId, tableView.tableId);
    }



}
