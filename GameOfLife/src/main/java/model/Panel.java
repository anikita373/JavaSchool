package model;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import ru.pvn.jdbc.Main;
import ru.pvn.jdbc.dao.PersonDao;
import ru.pvn.jdbc.domain.Person;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class Panel extends JPanel implements ActionListener {

    String[] args;
    ApplicationContext context = SpringApplication.run(Main.class);
    PersonDao dao = context.getBean(PersonDao.class);
    private int id=dao.count();
    int Px = 1200;
    int Py = 600;
    int size = 1;
    int xW = Px/size;
    int yH = Py/size;
    int[][] life = new int[xW][yH];
    int[][] oldLife = new int[xW][yH];
    int[][] staticLife = new int[xW][yH];
    long generation=0;
    boolean start = true;
    boolean copy = true;
    Timer timer= new Timer(1, this);

    public Panel(){
        setSize(1200,600);
        setBackground(Color.BLACK);
        setLayout(null);
        timer.start();
    }

    public void paintComponent(Graphics g){
        generation++;
        super.paintComponent(g);
        grid(g);
        try {
            spawn(g);
        } catch (DrawException e) {
            e.printStackTrace();
        }
        display(g);
        if (lifeIsStatic()) {
            timer.stop();
            id++;
            System.out.println("G"+generation);
            try {
                final JFrame parent = new JFrame();
                JButton button = new JButton();
                String name = JOptionPane.showInputDialog(parent, "What is your name?", null);
                Main main = new Main();
                main.dispose();
                dao.insert(new Person(id, generation, name));
                Console.main();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }



    public boolean lifeIsStatic(){
        int islife=0;
        for (int x =0; x < (xW); x++){
            for (int y =0; y < (yH); y++) {
                if (life[x][y] != staticLife[x][y]) islife++ ;
            }
        }
        if (islife==0)  return true;

        if (copy == true){
            copy = !copy;
        } else {
            for (int x =0; x < (xW); x++){
                for (int y =0; y < (yH); y++) {
                    staticLife[x][y] = life[x][y];
                }
            }
            copy = !copy;
        }
        System.out.println(islife);
        return false;
    }

    private void grid(Graphics g){
        //рисуем грид
        g.setColor(Color.darkGray);
        for (int i=0; i<life.length;i++){
            g.drawLine(0,i*size, Px,i*size);
            g.drawLine(i*size,0,i*size, Py);
        }
    }

    private void spawn(Graphics g) throws DrawException {
        if (start == true){
            Spawner spawner = new Spawner();
            //oldLife = spawner.randomSpawn(50);
//            oldLife = spawner.glaider(200,550);
//            oldLife = spawner.gosperGun(100,10);
//            oldLife = spawner.gosperGun(200,10);
//            oldLife = spawner.gosperGun(300,10);
//            oldLife = spawner.gosperGun(400,10);
//            oldLife = spawner.gosperGun(500,10);
//            oldLife = spawner.gosperGun(600,10);
//            oldLife = spawner.gosperGun(700,10);
//            oldLife = spawner.gosperGun(800,10);


               //oldLife = spawner.randomSpawn(500);
               //oldLife = spawner.point(-100,100);
               //oldLife = spawner.gosperGun(-800,10);
              // oldLife = spawner.glaider(-800,10);
//            oldLife = spawner.point(101,100);
//            oldLife = spawner.point(102,100);
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


    public void actionPerformed(ActionEvent e){
        int  alive;
        //правила
        LifeChecker lifeChecker = new LifeChecker();
        for (int x =0; x < (xW); x++){
            for (int y =0; y < (yH); y++) {
                    alive = lifeChecker.check(x,y,life,xW,yH);
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
}
