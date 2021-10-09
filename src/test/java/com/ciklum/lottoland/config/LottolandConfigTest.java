package com.ciklum.lottoland.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottolandConfigTest
{

    @Test
    void canCreateServiceBean(){
        assertDoesNotThrow( ()->{
            LottolandConfig lottolandConfig = new LottolandConfig();
            lottolandConfig.rockPaperScissorsService();
        } );
    }
}
