package com.company;


public class Request {
    private String clientName;
    private int sum;
    private RequestType requestType;

    Request(String clientName, int sum, RequestType requestType)
    {
        this.clientName = clientName;
        this.sum = sum;
        this.requestType = requestType;
    }

    @Override
    public String toString()
    {
        StringBuilder infoRequest = new StringBuilder();
        infoRequest.append("Заявка (");
        infoRequest.append("Имя клиента |");
        infoRequest.append(clientName);
        infoRequest.append("| Тип операции |");
        if (requestType==RequestType.DEC)
            infoRequest.append("Вычет|");
        else
            infoRequest.append("Пополнение|");
        infoRequest.append(" Сумма |");
        infoRequest.append(sum);
        infoRequest.append("|)");
        return infoRequest.toString();
    }

    public String getClientName() {
        return clientName;
    }

    public long getSum() {
        return sum;
    }

    public RequestType getRequestType() {
        return requestType;
    }
}
