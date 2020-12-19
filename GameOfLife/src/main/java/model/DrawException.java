package model;

public class DrawException extends Exception{

    private int number;
    public int getNumber(){return number;}
    public DrawException(String message){
        super(message);
    }
}

