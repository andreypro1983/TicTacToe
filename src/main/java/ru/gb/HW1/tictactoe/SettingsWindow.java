package ru.gb.HW1.tictactoe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 250;
    private static final int WINDOW_WIDTH = 350;

    private static final String TEXT_FIELD_SIZE = "Установленный размер поля: ";
    private static final String TEXT_WIN_SIZE = "Установленная длина: ";

    private static final int MIN_FIELD_LEN = 3;
    private static final int MAX_FIELD_LEN = 10;

    private static final int MIN_WIN_LEN = 3;
    private static final int MAX_WIN_LEN = 10;

    JButton btnStart = new JButton("Start new game");
    JLabel gameMode = new JLabel("Выберите режим игры");
    JLabel gameField = new JLabel(TEXT_FIELD_SIZE + MIN_FIELD_LEN);
    JLabel winCount = new JLabel(TEXT_WIN_SIZE + MIN_FIELD_LEN);
    JSlider fieldLength = new JSlider(MIN_FIELD_LEN, MAX_FIELD_LEN, MIN_FIELD_LEN);
    JSlider winLength = new JSlider(MIN_WIN_LEN, MIN_FIELD_LEN, MIN_FIELD_LEN);

    JRadioButton humanVsAi = new JRadioButton("Человек против компьютера");
    JRadioButton humanVsHuman = new JRadioButton("Человек против человека");
    ButtonGroup gameModeButtonsGroup = new ButtonGroup();

    JPanel panBottom;

    SettingsWindow(GameWindows gw) {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);


        panBottom = new JPanel(new GridLayout(8, 1));
        gameModeButtonsGroup.add(humanVsAi);
        gameModeButtonsGroup.add(humanVsHuman);
        panBottom.add(gameMode);
        panBottom.add(humanVsAi);
        panBottom.add(humanVsHuman);
        humanVsAi.setSelected(true);

        panBottom.add(gameField);
        panBottom.add(fieldLength);
        panBottom.add(winCount);
        panBottom.add(winLength);

        add(btnStart, BorderLayout.SOUTH);
        add(panBottom);
        fieldLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gameField.setText(TEXT_FIELD_SIZE + fieldLength.getValue());
                winLength.setMaximum(fieldLength.getValue());
            }
        });

        winLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winCount.setText(TEXT_WIN_SIZE + winLength.getValue());
            }
        });

        pushStartButton(gw);
        setLocationRelativeTo(gw);
    }

    private void pushStartButton(GameWindows gw) {
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fieldSize = fieldLength.getValue();
                gw.startNewGame(humanVsAi.isSelected() ? 0 : 1, fieldSize, fieldSize, winLength.getValue());
                setVisible(false);
            }
        });
    }

}
