package ru.gb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {

    private int panelWidth;
    private int panelHeight;
    private int cellWidth;
    private int cellHeight;

    private int sizeCountX;
    private int sizeCountY;

    public Map() {
        setBackground(Color.BLUE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });

    }

    private void update(MouseEvent e){
        int cellX = e.getX() /cellWidth;
        int cellY = e.getY()/ cellHeight;
        repaint();

    }

    void startNewGame(int mode, int sizeCountX, int sizeCountY, int wLen) {
        this.sizeCountX = sizeCountX;
        this.sizeCountY = sizeCountY;
        System.out.println("Начали игру");
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        panelHeight = getHeight();
        panelWidth = getWidth();
        cellWidth = panelWidth / sizeCountX;
        cellHeight = panelHeight /sizeCountY;

        g.setColor(Color.BLACK);

        for (int h = 0; h < sizeCountX; h++) {
            int y = cellHeight*h;
            g.drawLine(0,y,panelWidth,y);
        }
        for (int w = 0; w < sizeCountY; w++) {
            int x= cellWidth * w;
            g.drawLine(x,0,x,panelHeight);

        }

    }
}
