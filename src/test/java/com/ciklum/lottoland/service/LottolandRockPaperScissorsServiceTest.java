package com.ciklum.lottoland.service;

import com.ciklum.lottoland.enums.Hand;
import com.ciklum.lottoland.view.StatisticsView;
import com.ciklum.lottoland.view.TableView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static com.ciklum.lottoland.view.TableView.*;
import static org.junit.jupiter.api.Assertions.*;

class LottolandRockPaperScissorsServiceTest
{

    @Test
    void canStartGame()
    {
        LottolandRockPaperScissorsService lottolandRockPaperScissorsService = new LottolandRockPaperScissorsService();
        TableView tableView = lottolandRockPaperScissorsService.startGame();
        assertEquals(lottolandRockPaperScissorsService.getGames().size(), 1);
        assertEquals(TableView.fromTable(lottolandRockPaperScissorsService.getGames().values().stream().findFirst().get()), tableView);
    }


    @Test
    void canGetGame()
    {
        LottolandRockPaperScissorsService lottolandRockPaperScissorsService = new LottolandRockPaperScissorsService();
        TableView createdTableView = lottolandRockPaperScissorsService.startGame();
        TableView retrievedTableView = lottolandRockPaperScissorsService.getGame(UUID.fromString(createdTableView.getTableId()));
        assertEquals(createdTableView, retrievedTableView);
    }


    @Test
    void canPlayGameP1Wins()
    {
        LottolandRockPaperScissorsService service = Mockito.spy(new LottolandRockPaperScissorsService());
        Mockito.when(service.getRandomHand()).thenReturn(Hand.SCISSORS);
        TableView startedGame = service.startGame();
        TableView playedGame = service.playGame(UUID.fromString(startedGame.getTableId()));
        assertEquals(startedGame.getTableId(), playedGame.getTableId());
        assertEquals(Hand.ROCK, playedGame.getLatestP1Hand());
        assertEquals(Hand.SCISSORS, playedGame.getLatestP2Hand());
        assertEquals(1, playedGame.getRoundsSoFar());
        assertEquals(PLAYER_1_WINS_MESSAGE, playedGame.getResult());
    }


    @Test
    void canPlayGameP2Wins()
    {
        LottolandRockPaperScissorsService service = Mockito.spy(new LottolandRockPaperScissorsService());
        Mockito.when(service.getRandomHand()).thenReturn(Hand.PAPER);
        TableView startedGame = service.startGame();
        TableView playedGame = service.playGame(UUID.fromString(startedGame.getTableId()));
        assertEquals(startedGame.getTableId(), playedGame.getTableId());
        assertEquals(Hand.ROCK, playedGame.getLatestP1Hand());
        assertEquals(Hand.PAPER, playedGame.getLatestP2Hand());
        assertEquals(1, playedGame.getRoundsSoFar());
        assertEquals(PLAYER_2_WINS_MESSAGE, playedGame.getResult());
    }


    @Test
    void canPlayGameDraw()
    {
        LottolandRockPaperScissorsService service = Mockito.spy(new LottolandRockPaperScissorsService());
        Mockito.when(service.getRandomHand()).thenReturn(Hand.ROCK);
        TableView startedGame = service.startGame();
        TableView playedGame = service.playGame(UUID.fromString(startedGame.getTableId()));
        assertEquals(startedGame.getTableId(), playedGame.getTableId());
        assertEquals(Hand.ROCK, playedGame.getLatestP1Hand());
        assertEquals(Hand.ROCK, playedGame.getLatestP2Hand());
        assertEquals(1, playedGame.getRoundsSoFar());
        assertEquals(DRAW_MESSAGE, playedGame.getResult());
    }

    @Test
    void canGetCorrectStatistics()
    {
        LottolandRockPaperScissorsService service = Mockito.spy(new LottolandRockPaperScissorsService());
        Mockito.when(service.getRandomHand()).thenReturn(Hand.SCISSORS);
        TableView startedGame = service.startGame();
        TableView playedGame = service.playGame(UUID.fromString(startedGame.getTableId()));
        StatisticsView statisticsView = service.statisticsView();
        assertEquals(1, statisticsView.getTotalP1Wins());
        assertEquals(0, statisticsView.getTotalP2Wins());
        assertEquals(0, statisticsView.getTotalDraws());
    }
}
