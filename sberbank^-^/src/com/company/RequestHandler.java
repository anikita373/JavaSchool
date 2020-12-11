package com.company;

public class RequestHandler extends Thread{
    private int idHandler;
    private FrontEnd frontEnd;
    private BackEnd backEnd;

    RequestHandler(int id, FrontEnd frontEnd, BackEnd backEnd)
    {
        this.idHandler = id;
        this.frontEnd = frontEnd;
        this.backEnd=backEnd;
    }

    @Override
    public void run()
    {
        while (true)
        {
            //получаем запрос из очереди
            Request request = frontEnd.getRequest();
            System.out.println("Обработчик заявок №"+idHandler+": Получена заявка на обработку по клиенту - "+request.getClientName());
            //пробуем выполнить транзакцию
            backEnd.runTransaction(request,getIdHandler());
        }
    }

    public int getIdHandler() {
        return idHandler;
    }
}
