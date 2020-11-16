import javax.swing.JFrame;

public class Frame extends JFrame{

    public Frame(){
        //============== Добавляем панель ==============//
        add(new Panel());
        //==============================================//


        //================ Создаем окно ================//
        setSize(1200,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

    public static void main(String[] args){
        new Frame();
    }

}
