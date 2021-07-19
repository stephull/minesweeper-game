import javax.swing.ImageIcon;

/* 
    Board.java
    Separate method for working on gameboard panel
*/

import javax.swing.*;
import java.awt.*;
//import javax.swing.event.*;
import java.awt.event.*;

public class Board extends Control implements ActionListener {

    private JButton[][] buttons;
    private ImageIcon img;
    public static final int SIZE = 10;

    public Board() {
        // default constructor
    }

    public Board(JPanel base, int height, int width) {
        buttons = new JButton[width][height];
        base.setLayout(new GridLayout(width, height));
        base.setBackground(Color.MAGENTA);

        // prepare image for button
        img = new ImageIcon(getClass().getResource("Images/Tile-01.png"));
        Image tempimg = img.getImage().getScaledInstance(80, 75, Image.SCALE_SMOOTH);
        img = new ImageIcon(tempimg);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                buttons[i][j] = new JButton();
                JButton temp = buttons[i][j];
                setButton(temp, img);
                base.add(temp);
            }
        }
    }

    public void setButton(JButton button, ImageIcon img) {
        button.setVisible(true);
        button.setBackground(Color.PINK);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setIcon(img);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO
    }
}
