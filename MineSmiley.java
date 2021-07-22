/*
    MineSmiley.java
    Configure smiley face thing in the middle of the control panel.
*/

import javax.swing.*;

public class MineSmiley extends Control {
    
    public enum Faces {
        DEF, INTER, FAIL, PASS
    };
    public static String DEF = "Images/SmileFace.png";
    public static String INTER = "Images/ShockFace.png";
    public static String FAIL = "Images/DeathFace.png";
    public static String PASS = "Images/GoalFace.png";

    public ImageIcon face;

    MineSmiley() {
        face = new ImageIcon();
        
        exportSmiley();
    }

    public void changeFaces() {
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
    }

    public JButton exportSmiley() {
        JButton temp = new JButton();
        temp.setText("SMILEY");
        return temp;
    }
}
