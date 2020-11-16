import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Panel extends JPanel implements ActionListener {
//размеры панели
    int Px = 1200;
    int Py = 600;
    int size = 10;
    int xW = Px/size;
    int yH = Py/size;
    int[][] life = new int[xW][yH];
    int[][] oldLife = new int[xW][yH];


    boolean start = true;

    public Panel(){
        setSize(1200,600);
        setBackground(Color.BLACK);
        setLayout(null);

        new Timer(100, this).start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        grid(g);
        spawn(g);
        display(g);
    }

    private void grid(Graphics g){
        //рисуем грид
        g.setColor(Color.darkGray);
        for (int i=0; i<life.length;i++){
            g.drawLine(0,i*size, Px,i*size);
            g.drawLine(i*size,0,i*size, Py);
        }
    }

    private void spawn(Graphics g){
        if (start == true){
            for (int x =0; x < (xW); x++){
                for (int y =0; y < (yH); y++) {
                  if ((int)(Math.random()*10) == 0) oldLife[x][y] = 1;
               }
            }

            //глайдер
            drawFigure(1,50,50);


            start = false;
        }
    }



    private void display(Graphics g){
        g.setColor(Color.CYAN);
        copyArrays();
        for (int x =0; x < (xW); x++){
            for (int y =0; y < (yH); y++) {
                if (life[x][y] == 1){
                    g.fillRect(x*size, y* size,size,size);
                }
            }
        }

    }
    private int check(int x, int y){

        int alive =0;
        alive += life[(x + xW - 1) % xW][(y + yH - 1 ) % yH];    //левая верхняя
        alive += life[(x + xW) % xW]    [(y + yH - 1 ) % yH];      //левая
        alive += life[(x  + xW + 1) % xW][(y + yH - 1) % yH];    //левая нижняя

        alive += life[(x + xW -1) % xW]  [(y + yH) % yH];          //верхняя
        alive += life[(x + xW +1) % xW]  [(y+ yH) % yH];          //нижняя

        alive += life[(x + xW - 1) % xW][(y + 1 + yH) % yH];    //правая верхняя
        alive += life[(x + xW) % xW]    [(y + 1 + yH) % yH];        //правая
        alive += life[(x  + xW + 1) % xW][(y + 1 + yH) % yH];    //правая нижняя

        return alive;
    }

    public void actionPerformed(ActionEvent e){
        int  alive;
        //правила
        for (int x =0; x < (xW); x++){
            for (int y =0; y < (yH); y++) {

                    alive = check(x,y);

                    //правила
                    if (alive == 3)
                    {
                        oldLife[x][y] = 1;
                    }
                    else if (alive == 2 && life[x][y] == 1)
                    {
                        oldLife[x][y] = 1;
                    }
                    else oldLife[x][y] = 0;
                }

        }

        repaint();
    }

    private void copyArrays(){
        for (int x =0; x < (xW); x++){
            for (int y =0; y < (yH); y++) {
                life[x][y] = oldLife[x][y];
            }
        }
    }

   private void drawFigure (int name, int x, int y){
        int x1 = x + 9;
        int y1 = y + 9;
        if (name == 1)
        {
            for (int xo =x; xo < (x1); xo++){
                for (int yo =5; yo < (y1); yo++) {
                    oldLife[xo][yo] = 0;

                }
            }
            oldLife[x+4][y+3] = 1;
            oldLife[x+5][y+4] = 1;
            oldLife[x+3][y+5] = 1;
            oldLife[x+4][y+5] = 1;
            oldLife[x+5][y+5] = 1;

        }
        }


}
