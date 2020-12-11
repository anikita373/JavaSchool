package com.company;

public class RequestHandler extends Thread{
    private int idHandler;
    private FrontEnd frontalSystem;
    private BackEnd backSystemBank;

    RequestHandler(int id, FrontEnd fs, BackEnd backSystem)
    {
        this.idHandler = id;
        this.frontalSystem = fs;
        this.backSystemBank=backSystem;
    }

    @Override
    public void run()
    {
        while (true)
        {
            //получаем запрос из очереди
            Request request = frontalSystem.getRequest();
            System.out.println("Обработчик заявок №"+idHandler+": Получена заявка на обработку по клиенту - "+request.getClientName());
            //пробуем выполнить транзакцию
            backSystemBank.runTransaction(request,getIdHandler());
        }
    }

    public int getIdHandler() {
        return idHandler;
    }
}
