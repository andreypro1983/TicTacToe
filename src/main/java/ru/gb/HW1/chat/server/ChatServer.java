package ru.gb.HW1.chat.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatServer extends JFrame {
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 500;
    boolean isServerWorking;

    ChatServer() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ChatServer");
        setResizable(false);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        JButton btnStartServer = new JButton("Запустить сервер");
        JButton btnStopServer = new JButton("Остановить сервер");

        JPanel topPanel = new JPanel(new GridLayout(1,2));
        topPanel.add(btnStartServer);
        topPanel.add(btnStopServer);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        setLayout(new BorderLayout());
        add(topPanel,BorderLayout.NORTH);
        add(scrollPane);

        setVisible(true);

        btnStartServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    textArea.append("Сервер уже работает\n");
                } else {
                    isServerWorking = true;
                    textArea.append("Сервер успешно запущен\n");
                }
            }
        });

        btnStopServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    textArea.append("Сервер уже остановлен\n");
                } else {
                    isServerWorking = false;
                    textArea.append("Сервер успешно остановлен\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}
