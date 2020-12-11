package com.company;

import java.util.Random;

public class RandCharacter {
    //рандомизация суммы
    public int randomizeSum(int bound, int min){
        Random rand = new Random();
        return rand.nextInt(bound) + min;
    }

    //рандомизация запроса
    public RequestType randomizeRequestType(){
        return (new Random().nextBoolean())? RequestType.DEC:RequestType.INC;
    }
}