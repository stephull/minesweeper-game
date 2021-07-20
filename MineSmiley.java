/*
    MineSmiley.java
    Configure smiley face thing in the middle of the control panel.
*/

import javax.swing.*;

public class MineSmiley {
    
    public ImageIcon face;

    MineSmiley() {
        face = new ImageIcon();

        JButton button = new JButton();
        button.setText("Smiley Test");
    }

    public void changeFaces() {

    }

    public JButton exportSmiley() {
        JButton temp = new JButton();
        return temp;
    }
}
