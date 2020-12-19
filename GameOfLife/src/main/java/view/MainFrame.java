package view;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import ru.pvn.jdbc.Main;
import ru.pvn.jdbc.dao.PersonDao;
import ru.pvn.jdbc.domain.Person;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;


public class MainFrame extends JPanel implements ActionListener {

    public static void main(String[] args) {
        JFrame frame = new JFrame("GameOfLife");
        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout layout = new GridLayout(5, 1, 10, 10);
        JPanel panel = new JPanel(layout);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton buttonNewGame = new JButton("New Game");
        JButton buttonRecords = new JButton("Records");
        JButton buttonExit = new JButton("Exit");
        TextArea recordArea = new TextArea();
        recordArea.setVisible(false);
        JScrollPane scroll = new JScrollPane(recordArea);
        JButton buttonBack = new JButton("Back");
        buttonBack.setVisible(false);

        buttonNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = new Main();
                try {

                    frame.setVisible(false);
                    main.CreateGameFrame();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        buttonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buttonNewGame.setVisible(true);
                buttonRecords.setVisible(true);
                buttonExit.setVisible(true);
                buttonBack.setVisible(false);
                recordArea.setVisible(false);
            }
        });

        buttonRecords.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonNewGame.setVisible(false);
                buttonRecords.setVisible(false);
                buttonExit.setVisible(false);

                ApplicationContext context = SpringApplication.run(Main.class);
                PersonDao dao = context.getBean(PersonDao.class);
                try {
                    Console.main();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                recordArea.setText(null);
                for (int i = 1; i <= dao.count(); i++){
                    Person records = dao.getById(i);
                    recordArea.append(String.valueOf(records) + "\n");
                }

                buttonBack.setVisible(true);
                recordArea.setVisible(true);
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                System.exit(0);
            }
        });

        panel.add(buttonNewGame);
        panel.add(buttonRecords);
        panel.add(recordArea);
        panel.add(buttonBack);
        panel.add(buttonExit);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}