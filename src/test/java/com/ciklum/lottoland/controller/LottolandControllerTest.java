package com.ciklum.lottoland.controller;


import com.ciklum.lottoland.service.LottolandRockPaperScissorsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.util.UUID;

import static com.ciklum.lottoland.controller.LottolandController.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottolandControllerTest
{
    @Test
    void canStartGame()
    {
        LottolandRockPaperScissorsService service = Mockito.mock(LottolandRockPaperScissorsService.class);
        Model model = Mockito.mock(Model.class);
        LottolandController lottolandController = new LottolandController(service);

        String template = lottolandController.startGame(model);

        Mockito.verify(service).startGame();
        Mockito.verify(model).addAttribute(Mockito.eq(TABLE_ATTRIBUTE), Mockito.any());
        assertEquals(template, ROCK_PAPER_SCISSORS_TEMPLATE );
    }


    @Test
    void canGetGame()
    {
        LottolandRockPaperScissorsService service = Mockito.mock(LottolandRockPaperScissorsService.class);
        Model model = Mockito.mock(Model.class);
        LottolandController lottolandController = new LottolandController(service);
        UUID uuid = UUID.randomUUID();

        String template = lottolandController.getGame(uuid.toString(), model);

        Mockito.verify(service).getGame(uuid);
        Mockito.verify(model).addAttribute(Mockito.eq(TABLE_ATTRIBUTE), Mockito.any());
        assertEquals(template, ROCK_PAPER_SCISSORS_TEMPLATE );
    }


    @Test
    void canPlayGame()
    {
        LottolandRockPaperScissorsService service = Mockito.mock(LottolandRockPaperScissorsService.class);
        Model model = Mockito.mock(Model.class);
        LottolandController lottolandController = new LottolandController(service);
        UUID uuid = UUID.randomUUID();

        String template = lottolandController.playGame(uuid.toString(), model);

        Mockito.verify(service).playGame(uuid);
        Mockito.verify(model).addAttribute(Mockito.eq(TABLE_ATTRIBUTE), Mockito.any());
        assertEquals(template, ROCK_PAPER_SCISSORS_TEMPLATE );

    }

    @Test
    void canGetStatistics()
    {
        LottolandRockPaperScissorsService service = Mockito.mock(LottolandRockPaperScissorsService.class);
        Model model = Mockito.mock(Model.class);
        LottolandController lottolandController = new LottolandController(service);

        String template = lottolandController.statistics(model);

        Mockito.verify(service).statisticsView();
        Mockito.verify(model).addAttribute(Mockito.eq(STATISTICS_ATTRIBUTE), Mockito.any());
        assertEquals(template, STATISTICS_TEMPLATE );

    }

}
