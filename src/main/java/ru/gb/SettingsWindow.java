package ru.gb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 150;
    private static final int WINDOW_WIDTH = 250;

    JButton btnStart = new JButton("Start new game");

    SettingsWindow(GameWindows gw) {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gw.startNewGame(0, 3, 3, 3);
                setVisible(false);
            }
        });
//        btnStart.setBackground(Color.BLUE);
        add(btnStart);
        setLocationRelativeTo(gw);


    }

}
