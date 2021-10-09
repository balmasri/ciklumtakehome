package com.ciklum.lottoland.config;

import com.ciklum.lottoland.service.LottolandRockPaperScissorsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LottolandConfig
{
    @Bean
    public LottolandRockPaperScissorsService rockPaperScissorsService(){
        return new LottolandRockPaperScissorsService();
    }
}
