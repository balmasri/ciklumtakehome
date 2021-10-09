package com.ciklum.lottoland.service;

import com.ciklum.lottoland.enums.GameResult;
import com.ciklum.lottoland.enums.Hand;
import com.ciklum.lottoland.exception.GameNotFoundException;
import com.ciklum.lottoland.game.*;
import com.ciklum.lottoland.logic.RPSGameLogic;
import com.ciklum.lottoland.view.StatisticsView;
import com.ciklum.lottoland.view.TableView;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;

import java.util.*;

public class LottolandRockPaperScissorsService
{

    private final Map<UUID, Table> games;
    private final Statistics statistics;
    private final Random random = new Random();


    public LottolandRockPaperScissorsService()
    {
        games = Maps.newHashMap();
        statistics = new Statistics();

    }


    public TableView getGame(UUID id)
    {
        return TableView.fromTable(games.get(id));
    }


    public TableView startGame()
    {
        UUID tableId = UUID.randomUUID();
        Table table = new Table(tableId, 0, 0, 0, null, null, null);
        games.put(tableId, table);
        return TableView.fromTable(table);
    }


    public TableView playGame(UUID id)
    {
        if (games.containsKey(id))
        {
            Table table = games.get(id);
            GameResult gameResult = doPlayGameAndUpdateTable(table);
            if (gameResult == GameResult.DRAW)
            {
                table.incrementDraws();
                statistics.incrementTotalDraws();
            }
            else if (gameResult == GameResult.P1WIN)
            {
                table.incrementPlayer1Wins();
                statistics.incrementTotalP1Wins();
            }

            else if (gameResult == GameResult.P2WIN)
            {
                table.incrementPlayer2Wins();
                statistics.incrementTotalP2Wins();
            }

            return TableView.fromTable(table);
        }
        else
        {
            throw new GameNotFoundException(String.format("Unable to find game with id %s", id));
        }
    }


    public StatisticsView statisticsView()
    {
        return StatisticsView.fromStatistics(statistics);
    }


    @VisibleForTesting
    Hand getRandomHand()
    {

        List<Hand> hands = Collections.unmodifiableList(Arrays.asList(Hand.values()));
        return  hands.get(random.nextInt(hands.size()));
    }

    @VisibleForTesting
     Map<UUID, Table> getGames()
    {
        return games;
    }
    private GameResult doPlayGameAndUpdateTable(Table table)
    {
        Hand p1hand = Hand.ROCK;
        Hand p2hand = getRandomHand();

        GameResult gameResult = RPSGameLogic.playGame(p1hand, p2hand);

        table.setLatestP1Hand(p1hand);
        table.setLatestP2Hand(p2hand);
        table.setLatestGameResult(gameResult);

        return gameResult;
    }
}
