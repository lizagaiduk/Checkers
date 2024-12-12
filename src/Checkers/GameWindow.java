package Checkers;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameWindow extends JFrame {
    private static final Font font;
    private final JLabel scoreLabel;
    private final JLabel timerLabel;
    private int elapsedTime = 0;
    static Board checkersBoard;

    static {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(
                    "sources/fonts/mainFont.ttf")).deriveFont(25f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public GameWindow() {
        setTitle("Checkers");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        checkersBoard=new Board(this);
        add(checkersBoard,BorderLayout.CENTER);

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(600,50));
        topPanel.setLayout(new GridLayout(1, 2));

        timerLabel = new JLabel("Time: 00:00", SwingConstants.CENTER);
        timerLabel.setFont(font.deriveFont(15f));
        topPanel.add(timerLabel);

       scoreLabel = new JLabel("Score: 0 - 0", SwingConstants.CENTER);
       scoreLabel.setFont(font.deriveFont(15f));
        topPanel.add(scoreLabel);
        add(topPanel, BorderLayout.NORTH);
        pack();
        setVisible(true);


        new Thread(this::runTimer).start();
    }

    private void runTimer() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(100);
                updateTimer();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }
    private void updateTimer() {
        elapsedTime+=100;
        int seconds=(elapsedTime/1000)%60;
        int minutes=(elapsedTime/1000)/60;
        timerLabel.setText(String.format("Time: %02d:%02d", minutes, seconds));
    }

    public void updateScore(int whitescore,int blackscore) {
        scoreLabel.setText("Score: "+ whitescore+ " - " + blackscore);
    }

}
