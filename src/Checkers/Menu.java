package Checkers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import static java.awt.FlowLayout.*;

public class Menu extends JFrame implements ActionListener {
    private final JPanel mainPanel;
    private final JButton buttonNG;
    private final JButton buttonExit;
    private static final Font font;

    static {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(
                    "sources/fonts/mainFont.ttf")).deriveFont(25f);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Menu() {
        setTitle("Checkers Menu");
        setSize(800, 800);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(CENTER, 400, 80));
        mainPanel.setBackground(Color.WHITE);

        JLabel logo = new JLabel("Checkers");
        logo.setFont(font.deriveFont(Font.BOLD));
        logo.setPreferredSize(new Dimension(250,80));
        logo.setForeground(Color.BLACK);
        mainPanel.add(logo);


        buttonNG = createButton("Start");
        buttonExit = createButton("Exit");


        mainPanel.add(buttonNG);
        mainPanel.add(buttonExit);
        add(mainPanel);
        setVisible(true);

    }
    private JButton createButton(String name) {
        JButton button = new JButton(name);
        button.setPreferredSize(new Dimension(320, 80));
        button.setFont(font);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonNG) {
            mainPanel.setVisible(false);
            new GameWindow();
            new Rules();
            dispose();
        } else if (e.getSource() == buttonExit) {
            System.exit(0);
        }
    }
}
