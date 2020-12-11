package com.company;
import java.util.concurrent.atomic.AtomicLong;

public class BackEnd {
    private int defalutBalance = 10_000;
    private AtomicLong balance = new AtomicLong();
    public void runTransaction(Request request, int idHandler)
    {
        switch (request.getRequestType())
        {
            case INC:
                balance.addAndGet(request.getSum());
                System.out.println("|*BACK*| "+request+" ВЫПОЛНЕН!. Источник: обработчик |"
                        +idHandler+"| Баланс: "+balance);
                break;
            case DEC:
                if (balance.get()>=request.getSum())
                {
                    balance.addAndGet(-request.getSum());
                    System.out.println("|*BACK*| "+request+" ВЫПОЛНЕН!. Источник: обработчик |"
                            +idHandler+"| Баланс: "+balance);
                }
                else {
                    System.out.println("|*BACK*| " + request + " НЕ ВЫПОЛНЕН! Источник: обработчик |"
                            +idHandler+"| Баланс: " + balance);
                }
                break;
        }
    }
    public void setBalance(int sum){
        if (sum<0){
            System.out.println("Ошибка: Баланс не может быть отрицательным. " +
                    "Значение баланса было устновлено по умолчанию ("+
                     defalutBalance+")");
            sum = defalutBalance;
        }             this.balance.addAndGet(sum);
    }

}

