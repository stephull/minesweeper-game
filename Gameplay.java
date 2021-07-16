import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Gameplay extends Main {

    // main gameplay function
    Gameplay(JPanel panel, int mode, boolean multiplayer, int type) {

        // test button
        JButton testinside = new JButton();
        testinside.setVisible(true);
        testinside.setText("HELLO AGAIN!");
        testinside.setPreferredSize(new Dimension(40, 40));

        // test action listener on button too
        testinside.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                testinside.setText("IT'S ME");
            }
        });
        panel.add(testinside);

        // button panel for all buttons
        JPanel boardPanel = new JPanel();
        boardPanel.setBackground(Color.BLUE);
                // test case

        int gameWidth, gameHeight;
        gameWidth = gameHeight = 9; //default
        switch(mode) {
            case 1:
                gameWidth = gameHeight = 16;
                break;
            case 2:
                gameWidth = 30;
                gameHeight = 16;
                break;
            case 3:
                gameWidth = gameHeight = 30;
                break;
            case 4:
                break;
            default:
                gameWidth = gameHeight = 9;
                break;
        }

        // create 2D array with width and height as assigned above


        boardPanel.setLayout(new GridLayout(gameWidth, gameHeight));
        panel.add(boardPanel);
    }
}
