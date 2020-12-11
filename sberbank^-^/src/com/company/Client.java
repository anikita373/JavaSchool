package com.company;

public class Client  extends Thread{
    private FrontEnd frontEnd;
    private Request request;

    public Client(FrontEnd frontEnd, Request request)
    {
        this.frontEnd=frontEnd;
        this.request = request;
    }

    @Override
    public void run()
    {
        frontEnd.addRequest(request);
        System.out.println("Заявка отправлена в очередь");
    }
}
