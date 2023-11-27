package ru.gb.HW1.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindows extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 200;
    Map map;
    SettingsWindow settingsWindow;

    JButton btnStart = new JButton("New Game");
    JButton btnExit = new JButton("Exit");

    GameWindows() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ticTacToe");
        setResizable(false);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setVisible(true);
        map = new Map();
//        setLocationRelativeTo(null);
        JPanel panelBottom = new JPanel(new GridLayout(1, 2));
        settingsWindow = new SettingsWindow(this);
        panelBottom.add(btnStart);
        panelBottom.add(btnExit);
        add(panelBottom, BorderLayout.SOUTH);
        add(map);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        map.repaint();
        setVisible(true);

    }

    void startNewGame(int mode, int sizeCountX, int sizeCountY, int wLen) {
        map.startNewGame(mode, sizeCountX, sizeCountY, wLen);
    }
}
