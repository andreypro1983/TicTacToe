package ru.gb.HW1.chat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class ChatClient extends JFrame {

    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 450;

    private final static String PATH_FILE = "src/main/java/ru/gb/chat/client/log";

    private String[] list = {"Иванов", "Петров", "Сидоров"};

    private JTextArea textArea;
    private JComboBox<String> comboBox;
    private JTextField msgField;

    private FileHandler fileHandler;

    ChatClient(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ChatClient");
        setResizable(false);
        setLocationRelativeTo(null);

        JLabel loginLabel = new JLabel("login: ");
        loginLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel passwordLabel = new JLabel("password: ");
        passwordLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel ipLabel = new JLabel("ip: ");
        JLabel portLabel = new JLabel("port: ");
        ipLabel.setHorizontalAlignment(JLabel.CENTER);
        portLabel.setHorizontalAlignment(JLabel.CENTER);

        comboBox = new JComboBox<>(list);
        JTextField passwordField = new JTextField("*****");
        JTextField ipField = new JTextField("192.168.0.1");
        JTextField portField = new JTextField("666");
        JButton btnLogin = new JButton("Login");

        JPanel loginPanel = new JPanel(new GridLayout(1, 2));
        JPanel passwordPanel = new JPanel(new GridLayout(1, 2));
        JPanel ipPanel = new JPanel(new GridLayout(1, 2));
        JPanel portPanel = new JPanel(new GridLayout(1, 2));
        JPanel topPanel = new JPanel(new GridLayout(0, 1));

        loginPanel.add(loginLabel);
        loginPanel.add(comboBox);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        ipPanel.add(ipLabel);
        ipPanel.add(ipField);
        portPanel.add(portLabel);
        portPanel.add(portField);

        topPanel.add(loginPanel);
        topPanel.add(passwordPanel);
        topPanel.add(ipPanel);
        topPanel.add(portPanel);
        topPanel.add(btnLogin);
        add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        msgField = new JTextField();
        JButton btnSend = new JButton("Send");
        bottomPanel.add(btnSend, BorderLayout.EAST);
        bottomPanel.add(msgField, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textArea);
        add(scroll);

        setVisible(true);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textArea.getText().isEmpty()) {
                    try {
                        textArea.setText(fileHandler.loadFromFile(PATH_FILE));
                        System.out.println("История логов успешно загружена из файла");
                    } catch (IOException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });

        btnSend.addActionListener(e -> sendMessage());

        msgField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });
    }

    private void sendMessage() {
        if (!msgField.getText().isEmpty()) {
            String msg = comboBox.getSelectedItem() + ": " + msgField.getText() + "\n";
            textArea.append(msg);
            try {
                fileHandler.saveToFile(PATH_FILE, msg);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            msgField.setText(null);
        }
    }

    public static void main(String[] args) {
        new ChatClient(new FileHandler());
    }
}
