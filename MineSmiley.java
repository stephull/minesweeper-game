/*
    MineSmiley.java
    Configure smiley face thing in the middle of the control panel.
*/

import java.awt.*;
import javax.swing.*;

public class MineSmiley extends ControlPanel {
    
    // for smiley face images
    public static String DEF = "Images/DefaultFace.png";
    public static String INTER = "Images/InterFace.png";
    public static String FAIL = "Images/FailFace.png";
    public static String PASS = "Images/PassFace.png";

    public JButton smiley;
    public ImageIcon image;

    public MineSmiley() {
        smiley = new JButton();
        image = new ImageIcon(getClass().getResource(DEF));
        image = new ImageIcon(image.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        smiley.setBackground(Color.GRAY);
        smiley.add(new JLabel(image));

        // PSEUDOCODE
        /*
            if (game is on) {
                changeFaces() -- every time the user clicks on smiley
            }
        */

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
        return smiley;
    }
}
