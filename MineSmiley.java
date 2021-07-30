/*
    MineSmiley.java
    Configure smiley face thing in the middle of the control panel.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MineSmiley extends ControlPanel {

    protected JButton smiley;
    protected ImageIcon image;

    MineSmiley() {
        smiley = new JButton();
        smiley.setBackground(Color.GRAY);
        changeFaces(setSmileButton(DEF));

        // add action listener to JButton
        smiley.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == smiley) {
                    /*
                        'wantToChange' is a test boolean value for 
                        whether or not a menu option for single or multi
                        player (opposite of the running game) is clicked
                        on while the game is active... this will be added
                        later on, another time!
                    */
                    boolean wantToChangeModes = true;
                    if (active && wantToChangeModes) {
                        // SOURCE: http://www.java2s.com/Tutorials/Java/Swing_How_to/JOptionPane/Create_Custom_Buttons_in_JOptionPane_showInputDialog.htm
                        String dialogText = "Are you sure you want to switch while game is running?";
                        String titleText = "Minesweeper :: Game active";
                        int input = JOptionPane.showConfirmDialog(null, dialogText, titleText, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (input == 0) {
                            ;
                        } else if (input == 1) {
                            ;
                        }
                    }

                    // SUGGESTION: testcount counts how many games the player goes through (for data?)
                    String test = "";
                    switch (++gameCount % 2) {
                        case 0: test = DEF;     break;
                        case 1: test = INTER;   break;
                    }
                    changeFaces(setSmileButton(test));

                    active = false;
                    isActive.setText(IS_ACTIVE_TEXT + returnActive());
                }
            }
        });

        // PSEUDOCODE
        /*
            if (game is on) {
                changeFaces() -- every time the user clicks on smiley
            }
        */
    }

    protected ImageIcon setSmileButton(String resource) {
        image = new ImageIcon(getClass().getResource(resource));
        return new ImageIcon(image.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    }

    protected void changeFaces(ImageIcon img) {
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
        smiley.setIcon(img);
        exportSmiley();
    }

    protected JButton exportSmiley() {
        return smiley;
    }
}
