package com.company;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FrontEnd {
    //Очередь
    private int queueSize = 2;
    private BlockingQueue<Request> requests;
    public FrontEnd()
    {
        requests = new ArrayBlockingQueue<>(queueSize,true);
    }

    //Помещаем в очередь
    public void addRequest(Request request)
    {
        try {
            requests.put(request);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println("Заявка помещена в очередь");
        }
        System.out.println(request.getClientName()+": "+request+" отправлена в банк");

    }

    //получаем запрос из очереди
    public Request getRequest()
    {
        Request currentRequest = null;
        try {
            currentRequest = requests.take();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return currentRequest;
    }
}
