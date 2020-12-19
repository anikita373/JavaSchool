package model;

public class LifeChecker {

    public int check(int x, int y, int[][] life, int xW, int yH){
        int alive =0;
        alive += life[(x + xW - 1) % xW] [(y + yH - 1 ) % yH];     //левая верхняя
        alive += life[(x + xW - 1) % xW] [(y + yH) % yH];          //левая
        alive += life[(x + xW + 1) % xW] [(y + yH - 1) % yH];      //левая нижняя

        alive += life[(x + xW) % xW]     [(y + yH - 1 ) % yH];    //верхняя

        alive += life[(x + xW +1) % xW]  [(y+ yH) % yH];          //нижняя

        alive += life[(x + xW - 1) % xW][(y + 1 + yH) % yH];    //правая верхняя
        alive += life[(x + xW) % xW]    [(y + 1 + yH) % yH];        //правая
        alive += life[(x  + xW + 1) % xW][(y + 1 + yH) % yH];    //правая нижняя

        return alive;
    }
}
