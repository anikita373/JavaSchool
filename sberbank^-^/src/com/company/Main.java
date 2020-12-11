package com.company;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        BackEnd backEnd = new BackEnd();
        FrontEnd frontEnd = new FrontEnd();
        RandCharacter randCharacter = new RandCharacter();
        backEnd.setBalance(-1_000_000);
        Request[] requestList = {
                new Request("Клиент №1", randCharacter.randomizeSum(10_000, 5_000),
                        randCharacter.randomizeRequestType()),
                new Request("Клиент №2", randCharacter.randomizeSum(10_000, 5_000),
                        randCharacter.randomizeRequestType()),
                new Request("Клиент №3", randCharacter.randomizeSum(10_000, 5_000),
                        randCharacter.randomizeRequestType()),
                new Request("Клиент №4", randCharacter.randomizeSum(10_000, 5_000),
                        randCharacter.randomizeRequestType()),
        };
        //Пул потоков
        ExecutorService eСlients = Executors.newFixedThreadPool(requestList.length);

        //Запуск потоков
        for (Request req : requestList){
            eСlients.submit(new Client(frontEnd, req));
        }

        //Пул обработчиков
        ExecutorService eRequestHandler = Executors.newFixedThreadPool(2);
        //Запуск обработчиков
        eRequestHandler.submit(new RequestHandler(1,frontEnd,backEnd));
        eRequestHandler.submit(new RequestHandler(2,frontEnd,backEnd));
        eСlients.shutdown();
        eRequestHandler.shutdown();
    }
}
