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
                    int input = JOptionPane.showConfirmDialog(null, dialogText, titleText, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (input == 0) {
                        ;
                    } else if (input == 1) {
                        ;
                    }
                }

                // SUGGESTION: testcount counts how many games the player goes through (for data?)
                changeFaces(DEF);
                ++gameCount;
                active = false;

                //new Board(new JPanel(), mines);
            }
        });
    }

    protected void changeFaces(String resource) {
        ImageIcon image = new ImageIcon(getClass().getResource(resource));
        image = new ImageIcon(image.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

        // PSEUDO CODE
        /* if (clicked) {
            change face to :O
            immediately switch back to default face
        }

        if (game end due to MINE) {
            change face to X(
        } else if (game end due to COMPLETION) {
            change face to B)
        }

        */
        smiley.setIcon(image);
        export();
    }

    protected JButton export() {
        return smiley;
    }
}
