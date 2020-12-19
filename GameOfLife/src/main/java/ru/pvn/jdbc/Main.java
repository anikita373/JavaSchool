package ru.pvn.jdbc;

import model.Panel;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.pvn.jdbc.dao.PersonDao;
import ru.pvn.jdbc.domain.Person;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SpringBootApplication
public class Main extends JFrame {

    public void CreateGameFrame() throws Exception {
        JFrame frame = new JFrame("Game Of Life");
        frame.setSize(1220,639);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Panel panel = new Panel();
        frame.add(panel);
    }
}

