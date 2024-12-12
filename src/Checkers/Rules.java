package Checkers;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Rules extends JFrame {
    static Font font;
    static {
    try {
        font = Font.createFont(Font.TRUETYPE_FONT, new File(
                "sources/fonts/mainFont.ttf")).deriveFont(13f);
    } catch (FontFormatException | IOException e) {
        throw new RuntimeException(e);
    }
    }
    public Rules() {
        setTitle("Game Rules");
        setSize(300, 300);
        setLocation(850, 100);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea rulesArea = new JTextArea();
        rulesArea.setEditable(false);
        rulesArea.setLineWrap(true);
        rulesArea.setWrapStyleWord(true);

        String rulesText = """
                Game Rules:
                1. The game is played on an 8x8 board.
                2. The white pieces always move first.
                3. Players take turns moving their pieces.
                4. Pieces can only move diagonally on dark squares.
                5. A player wins when all opponent’s pieces are captured.
                6. Backward movement is allowed only when capturing.
                """;

        rulesArea.setText(rulesText);
        rulesArea.setFont(font);
        JScrollPane scrollPane = new JScrollPane(rulesArea);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
