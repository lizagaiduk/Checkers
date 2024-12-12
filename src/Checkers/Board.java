package Checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board extends JPanel {
    static {
        System.out.println("Loading native library...");
        System.loadLibrary("libProjectLibrary");
        System.out.println("Native library loaded successfully.");
    }

    private static final int boardSize = 8;
    GameWindow gameWindow;
    public native int getCellState(int row, int col);
    public native void handleMouseClick(int row, int col);
    public native void handleKeyPress(int keyCode);
    public native void initializeBoard();
    public native int getBlackScore();
    public native int getWhiteScore();
    public native int[] getSelectedPiece();
    public native boolean checkTheEndOfGame();


    public Board(GameWindow gameWindow) {
        setPreferredSize(new Dimension(600, 600));
        initializeBoard();
        this.gameWindow=gameWindow;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int cellSize = getWidth() / boardSize;
                int row = e.getY() / cellSize;
                int col = e.getX() / cellSize;
                handleMouseClick(row,col);
                updateBoard();
             }
        });
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e.getKeyCode());
               updateBoard();
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = getWidth() / boardSize;
        Graphics2D g2d = (Graphics2D) g;
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                boolean isWhite = (row + col) % 2 == 0;
                g2d.setColor(isWhite ? Color.WHITE : Color.DARK_GRAY);
                g2d.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                int state = getCellState(row, col);
                if (state == 1) {
                    g2d.setColor(Color.WHITE);
                    g2d.fillOval(col * cellSize + 10, row * cellSize + 10, cellSize - 20, cellSize - 20);
                } else if (state == 2) {
                    g2d.setColor(Color.BLACK);
                    g2d.fillOval(col * cellSize + 10, row * cellSize + 10, cellSize - 20, cellSize - 20);
                }
            }
        }
        int[] selected = getSelectedPiece();
        if (selected != null) {
            g2d.setColor(Color.GREEN);
            g2d.setStroke(new BasicStroke(4));
            g2d.drawOval(selected[1] * cellSize + 10, selected[0] * cellSize + 10, cellSize - 20, cellSize - 20);
        }
        if (checkTheEndOfGame()) {
            displayEndWindow();
        }
    }
    public void updateBoard() {
        repaint();
        gameWindow.updateScore(getWhiteScore(),getBlackScore());
    }

    private void displayEndWindow() {
        JOptionPane.showMessageDialog(this, "Game over! " + (getWhiteScore() ==12 ? "White" : "Black") + " wins!");
        System.exit(0);
    }

}
