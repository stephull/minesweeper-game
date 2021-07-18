import javax.swing.ImageIcon;

/* 
    Board.java
    Separate method for working on gameboard panel
*/

import javax.swing.*;
//import java.awt.*;

public class Board {

    private JButton[][] buttons;
    private ImageIcon[][] buttonimgs;

    public Board(JPanel base, int height, int width) {
        buttons = new JButton[width][height];
        buttonimgs = new ImageIcon[width][height];

        setButtons(buttons, buttonimgs);
    }

    public void setButtons(JButton[][] buttons, ImageIcon[][] imgs) {

        // add images for each button
        setImages(imgs);
    }

    public void setImages(ImageIcon[][] imgs) {

    }
}
