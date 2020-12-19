package model;
public class Spawner extends Panel {

    int[][] spawnlife = new int[xW][yH];


    public int[][] randomSpawn(int Rate) throws DrawException {
        if ((Rate>100) || (Rate < 0)) throw new DrawException("Rate out of range! " +
                "Set Rate between 0 and 100!");
        else {
            for (int x = 0; x < (xW); x++) {
                for (int y = 0; y < (yH); y++) {
                    if ((int) (Math.random() * 100) < Rate) spawnlife[x][y] = 1;
                }
            }
            return spawnlife;
        }
    }


    public int[][] line(int x1, int x2, int y) throws DrawException {
        if (x1>x2) throw new DrawException("The starting point cannot be greater than the ending point!");
        else {
            for (int x = x1; x < (x2 - x1); x++) {
                spawnlife[x][y] = 1;
            }
            return spawnlife;
        }
    }

    public int[][] point (int x, int y) throws DrawException {
        if ((x<0 || y<0) || (x > xW || y > yH)) throw new DrawException("Point cannot " +
                "be created outside the torus");
        else {
            spawnlife[x][y] = 1;

            return spawnlife;
        }
    }

    public int[][] glaider (int x, int y) throws DrawException {
        if ((x<0 || y<0) || (x > xW || y > yH)) throw new DrawException("Glider cannot " +
                "be created outside the torus");
        else {
            spawnlife[x + 4][y + 3] = 1;
            spawnlife[x + 5][y + 4] = 1;
            spawnlife[x + 3][y + 5] = 1;
            spawnlife[x + 4][y + 5] = 1;
            spawnlife[x + 5][y + 5] = 1;
            return spawnlife;
        }
    }

    public int[][] gosperGun (int x, int y) throws DrawException {
        if ((x<0 || y<0) || (x > xW || y > yH)) throw new DrawException("Gosper gun cannot " +
                "be created outside the torus");
        else {
            spawnlife[x + 1][y + 5] = 1;
            spawnlife[x + 1][y + 6] = 1;
            spawnlife[x + 2][y + 5] = 1;
            spawnlife[x + 2][y + 6] = 1;

            // 1 элемент
            spawnlife[x + 12][y + 5] = 1;
            spawnlife[x + 12][y + 6] = 1;
            spawnlife[x + 12][y + 7] = 1;
            spawnlife[x + 13][y + 4] = 1;
            spawnlife[x + 13][y + 8] = 1;
            spawnlife[x + 14][y + 3] = 1;
            spawnlife[x + 14][y + 9] = 1;
            spawnlife[x + 15][y + 4] = 1;
            spawnlife[x + 15][y + 8] = 1;
            spawnlife[x + 16][y + 5] = 1;
            spawnlife[x + 16][y + 6] = 1;
            spawnlife[x + 16][y + 7] = 1;
            spawnlife[x + 17][y + 5] = 1;
            spawnlife[x + 17][y + 6] = 1;
            spawnlife[x + 17][y + 7] = 1;

            // 2 элемент
            spawnlife[x + 22][y + 3] = 1;
            spawnlife[x + 22][y + 4] = 1;
            spawnlife[x + 22][y + 5] = 1;

            spawnlife[x + 23][y + 2] = 1;
            spawnlife[x + 23][y + 3] = 1;
            spawnlife[x + 23][y + 5] = 1;
            spawnlife[x + 23][y + 6] = 1;

            spawnlife[x + 24][y + 2] = 1;
            spawnlife[x + 24][y + 3] = 1;
            spawnlife[x + 24][y + 5] = 1;
            spawnlife[x + 24][y + 6] = 1;

            spawnlife[x + 25][y + 2] = 1;
            spawnlife[x + 25][y + 3] = 1;
            spawnlife[x + 25][y + 4] = 1;
            spawnlife[x + 25][y + 5] = 1;
            spawnlife[x + 25][y + 6] = 1;

            spawnlife[x + 26][y + 1] = 1;
            spawnlife[x + 26][y + 2] = 1;
            spawnlife[x + 26][y + 6] = 1;
            spawnlife[x + 26][y + 7] = 1;

            spawnlife[x + 32][y + 5] = 1;
            spawnlife[x + 32][y + 6] = 1;

            //куб
            spawnlife[x + 35][y + 3] = 1;
            spawnlife[x + 35][y + 4] = 1;
            spawnlife[x + 36][y + 3] = 1;
            spawnlife[x + 36][y + 4] = 1;
            return spawnlife;
        }
    }

    public  int[][] cleanArea (){
        for (int x =0; x < (xW); x++){
            for (int y =0; y < (yH); y++) {
                spawnlife[x][y] = 0;
            }
        }
        return spawnlife;
    }


}
