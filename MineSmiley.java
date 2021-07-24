/*
    MineSmiley.java
    Configure smiley face thing in the middle of the control panel.
*/

import java.awt.*;
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

    protected void changeFaces() {
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

    protected JButton exportSmiley() {
        return smiley;
    }
}
