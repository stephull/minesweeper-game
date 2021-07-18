import javax.swing.ImageIcon;

/* 
    Board.java
    Separate method for working on gameboard panel
*/

import javax.swing.*;
//import java.awt.*;

public class Board extends Control {

    private JButton[][] buttons;
    private ImageIcon img;

    public Board() {
        // default constructor
    }

    public Board(JPanel base, int height, int width) {
        buttons = new JButton[width][height];

        // prepare image for button
        img = new ImageIcon("Images/Tile-01.png");

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                setButton(buttons[i][j]);
            }
        }
    }

    public void setButton(JButton button) {
        
    }
}
