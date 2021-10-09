package com.ciklum.lottoland.controller;

import com.ciklum.lottoland.service.LottolandRockPaperScissorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.UUID;

@Controller
public class LottolandController
{

    static final String TABLE_ATTRIBUTE = "table";
    static final String ROCK_PAPER_SCISSORS_TEMPLATE = "rock-paper-scissors";
    static final String STATISTICS_ATTRIBUTE = "statistics";
    static final String STATISTICS_TEMPLATE = "statistics";
    @Autowired LottolandRockPaperScissorsService lottolandRockPaperScissorsService;

    public LottolandController(LottolandRockPaperScissorsService lottolandRockPaperScissorsService){
        this.lottolandRockPaperScissorsService = lottolandRockPaperScissorsService;
    }

    @GetMapping("/api/game/{id}")
    public String getGame(
        @PathVariable(name = "id", required = false)
            String id, Model model)
    {

        model.addAttribute(TABLE_ATTRIBUTE, lottolandRockPaperScissorsService.getGame(UUID.fromString(id)));
        return ROCK_PAPER_SCISSORS_TEMPLATE;
    }


    @GetMapping("/api/game/new")
    public String startGame(Model model)
    {
        model.addAttribute(TABLE_ATTRIBUTE, lottolandRockPaperScissorsService.startGame());
        return ROCK_PAPER_SCISSORS_TEMPLATE;
    }


    @GetMapping("/api/game/play/{id}")
    public String playGame(
        @PathVariable(name = "id")
            String id, Model model)
    {

        model.addAttribute(TABLE_ATTRIBUTE, lottolandRockPaperScissorsService.playGame(UUID.fromString(id)));

        return ROCK_PAPER_SCISSORS_TEMPLATE;

    }

    @GetMapping("/api/statistics")
    public String statistics(Model model)
    {

        model.addAttribute(STATISTICS_ATTRIBUTE, lottolandRockPaperScissorsService.statisticsView());

        return STATISTICS_TEMPLATE;

    }

}
