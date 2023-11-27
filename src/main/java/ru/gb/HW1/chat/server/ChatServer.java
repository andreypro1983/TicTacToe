package ru.gb.HW1.chat.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatServer extends JFrame implements ChatListener {
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 500;

    private final ServerListener server;

    private final JTextArea textArea;


    ChatServer() {
        server = new Server(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ChatServer");
        setResizable(false);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        JButton btnStartServer = new JButton("Запустить сервер");
        JButton btnStopServer = new JButton("Остановить сервер");

        JPanel topPanel = new JPanel(new GridLayout(1, 2));
        topPanel.add(btnStartServer);
        topPanel.add(btnStopServer);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane);

        setVisible(true);

        btnStartServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.onServerExecute("start");
            }
        });

        btnStopServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                server.onServerExecute("stop");
            }
        });
    }

    public static void main(String[] args) {
        new ChatServer();
    }

    private void addMessageToLog(String msg){
        textArea.append(msg);
    }

    @Override
    public void messageReceive(String msg) {
        addMessageToLog(msg);
    }

}
