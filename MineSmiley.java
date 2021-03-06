/*
    MineSmiley.java
    Configure smiley face thing in the middle of the control panel.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MineSmiley extends ControlPanel {

    protected JButton smiley;
    protected int gameCount;

    // getter for total number of games played
    protected int getGameCount() {
        return gameCount;
    }

    // setter for total number of games played
    protected void setGameCount(int newGameCount) {
        this.gameCount = newGameCount;
    }

    MineSmiley() {
        gameCount = 0;

        smiley = new JButton();
        smiley.setBackground(Color.GRAY);
        changeFaces(DEF);

        // add action listener to JButton
        smiley.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                boolean wantToChangeModes = false;
                if (wantToChangeModes) {
                    /*
                        'wantToChange' is a test boolean value for whether or not a menu option for single or multiplayer
                        (opposite of the running game) is clicked on while the game is active... this will be added later on...
                            NOTE: DIALOG ONLY POPS UP IF USER WANTS TO SWITCH TO MULTIPLAYER (or vice versa) WHILE THE GAME IS ACTIVE
                            IF USER WANTS TO START SAME GAME OVER, THE USER PRESSES SMILEY AND THE GAME JUST RESTARTS!
                    */
                    // SOURCE: http://www.java2s.com/Tutorials/Java/Swing_How_to/JOptionPane/Create_Custom_Buttons_in_JOptionPane_showInputDialog.htm
                    String dialogText = "Are you sure you want to switch modes while game is running?";
                    String titleText = "Minesweeper :: Game active";
                    int input = JOptionPane.showConfirmDialog(null, dialogText, titleText, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (input == 1) {
                        readStatus.setText(" :: OPT OUT OF DIALOG :: ");
                    }
                }
                changeFaces(DEF);
                ++gameCount;
                active = gameOver = false;
                readDirection.setVisible(true);
                wantsToStartOver = true;

                String temp = (gameOver) ? "You've restarted the game! Enjoy!" : "Boop! You got me!";
                readStatus.setText("SMILEY:   " + temp);
            }
        });
    }

    protected void changeFaces(String resource) {
        ImageIcon image = new ImageIcon(getClass().getResource(resource));
        image = new ImageIcon(image.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        smiley.setIcon(image);
        export();
    }

    protected JButton export() {
        return smiley;
    }
}
