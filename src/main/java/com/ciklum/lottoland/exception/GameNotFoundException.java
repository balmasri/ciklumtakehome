package com.ciklum.lottoland.exception;

public class GameNotFoundException extends RuntimeException
{
    public GameNotFoundException(String message){
        super(message);
    }
}
