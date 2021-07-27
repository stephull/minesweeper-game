/*
    MineSmiley.java
    Configure smiley face thing in the middle of the control panel.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MineSmiley extends ControlPanel {
    
    // for smiley face images
    protected final String DEF = "Images/DefaultFace.png";
    protected final String INTER = "Images/InterFace.png";
    protected final String FAIL = "Images/FailFace.png";
    protected final String PASS = "Images/PassFace.png";

    protected JButton smiley;
    protected ImageIcon image;

    MineSmiley() {
        smiley = new JButton();
        smiley.setBackground(Color.GRAY);
        changeFaces(setButton(DEF));

        // add action listener to JButton
        smiley.addActionListener(new ActionListener() {
            int testcount = 0;
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
                    boolean wantToChange = true;
                    if (/*active && */wantToChange) {
                        // opens a new option dialog that lets user choose if they want to exit or not...
                        Object[] dialogOptions = {"YES", "NO"};
                        JOptionPane.showOptionDialog(null, "Are you sure you want to switch modes mid-game?", null, 
                            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, dialogOptions, dialogOptions[0]);
                            // SOURCE: http://www.java2s.com/Tutorials/Java/Swing_How_to/JOptionPane/Create_Custom_Buttons_in_JOptionPane_showInputDialog.htm
                    }
                    // test -- not for actual gameplay
                    // SUGGESTION: testcount counts how many games the player goes through (for data?)
                    String test = "";
                    switch (++testcount % 4) {
                        case 0: test = DEF;     break;
                        case 1: test = INTER;   break;
                        case 2: test = FAIL;    break;
                        case 3: test = PASS;    break;
                    }
                    changeFaces(setButton(test));
                    System.out.println("TESTCOUNT: " + testcount);
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

    protected ImageIcon setButton(String resource) {
        image = new ImageIcon(getClass().getResource(resource));
        return new ImageIcon(image.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
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
