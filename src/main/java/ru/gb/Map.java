package ru.gb;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {

    private boolean isGameOver;

    private boolean isInitialized;

    private int panelWidth;
    private int panelHeight;
    private int cellWidth;
    private int cellHeight;

    private int sizeCountX;
    private int sizeCountY;

    private static final int DOT_PADDING = 2;

    private static final Random rnd = new Random();
    private final int HUMAN = 1;
    private final int AI = 2;
    private final int EMPTY = 0;

    private char[][] field;

    int gameOverType;
    private static final int STATE_DRAW = 0;
    private static final int STATE_HUMAN_WIN = 1;
    private static final int STATE_AI_WIN = 2;

    private static final String DRAW_TEXT = "Ничья!";
    private static final String HUMAN_WIN_TEXT = "Победил игрок!";
    private static final String AI_WIN_TEXT = "Победил компьютер!";


    public Map() {

        setBackground(Color.BLACK);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
//                 super.mouseReleased(e);
                update(e);
            }
        });

        isInitialized = false;


    }

    private void initMap() {
        field = new char[sizeCountY][sizeCountX];
        for (int y = 0; y < sizeCountY; y++) {
            for (int x = 0; x < sizeCountX; x++) {
                field[y][x] = EMPTY;
            }

        }

    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < sizeCountX && y >= 0 && y < sizeCountY;
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY;
    }

    private void update(MouseEvent e) {
        if (isGameOver || !isInitialized) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellY][cellX] = HUMAN;
        repaint();
        if (checkEndGame(HUMAN, STATE_HUMAN_WIN)) return;
        aiTurn();
        repaint();
        if (checkEndGame(AI, STATE_AI_WIN)) return;
    }

    private boolean checkEndGame(int player, int gameOverType) {
        if (checkWin((char) player)) {
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isMapFull()) {
            this.gameOverType = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }

    private void aiTurn() {
        int valueX, valueY;
        do {
            valueX = rnd.nextInt(sizeCountX);
            valueY = rnd.nextInt(sizeCountY);
        } while (!isEmptyCell(valueX, valueY));
        field[valueY][valueX] = AI;
    }

    private boolean checkWin(char C) {
        if (field[0][0] == C && field[0][1] == C && field[0][2] == C) return true;
        if (field[1][0] == C && field[1][1] == C && field[1][2] == C) return true;
        if (field[2][0] == C && field[2][1] == C && field[2][2] == C) return true;
        if (field[0][0] == C && field[1][0] == C && field[2][0] == C) return true;
        if (field[0][1] == C && field[1][1] == C && field[2][1] == C) return true;
        if (field[0][2] == C && field[1][2] == C && field[2][2] == C) return true;
        if (field[0][0] == C && field[1][1] == C && field[2][2] == C) return true;
        if (field[0][2] == C && field[1][1] == C && field[2][0] == C) return true;
        return false;
    }

    private boolean isMapFull() {
        for (int y = 0; y < sizeCountY; y++) {
            for (int x = 0; x < sizeCountX; x++) {
                if (field[y][x] == EMPTY) return false;
            }
        }
        return true;
    }

    void startNewGame(int mode, int sizeCountX, int sizeCountY, int wLen) {
        this.sizeCountX = sizeCountX;
        this.sizeCountY = sizeCountY;
        isInitialized = true;
        isGameOver = false;
        initMap();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (gameOverType) {
            case STATE_HUMAN_WIN:
                g.drawString(HUMAN_WIN_TEXT, 80, getHeight() / 2);
                break;
            case STATE_AI_WIN:
                g.drawString(AI_WIN_TEXT, 20, getHeight() / 2);
                break;
            case STATE_DRAW:
                g.drawString(DRAW_TEXT, 180, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Unexpected gameOver state: " + gameOverType);
        }
    }

    private void render(Graphics g) {

        if (!isInitialized) return;
        panelHeight = getHeight();
        panelWidth = getWidth();
        cellWidth = panelWidth / sizeCountX;
        cellHeight = panelHeight / sizeCountY;

        g.setColor(Color.WHITE);

        for (int h = 0; h < sizeCountX; h++) {
            int y = cellHeight * h;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int w = 0; w < sizeCountY; w++) {
            int x = cellWidth * w;
            g.drawLine(x, 0, x, panelHeight);

        }


        for (int y = 0; y < sizeCountY; y++) {
            for (int x = 0; x < sizeCountX; x++) {
                if (field[y][x] == EMPTY) continue;
                if (field[y][x] == HUMAN) {
                    g.setColor(Color.RED);
                    g.fillOval(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING, cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else if (field[y][x] == AI) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING, cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException("Unknown symbol in cell X=" + x + ", Y=" + y);
                }

            }
        }
        if (isGameOver) showMessageGameOver(g);
    }
}
