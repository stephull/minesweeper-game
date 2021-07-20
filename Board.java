import javax.swing.ImageIcon;

/* 
    Board.java
    Separate method for working on gameboard panel
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends Control {

    private JButton[][] buttons;
    private ImageIcon img;
    public static final int SIZE = 10;
    private boolean clicked;

    public Board() {
        // default constructor
    }

    public Board(JPanel base, GridBagConstraints c, int height, int width) {
        buttons = new JButton[width][height];
        base.setLayout(new GridLayout(width, height));
        clicked = false;

        // prepare image for button
        img = prepareImage("Images/Tile-01.png");

        // make button board on screen...
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                buttons[i][j] = new JButton();
                JButton temp = buttons[i][j];
                setButton(temp, img);
                base.add(temp);

                temp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == buttons) {
                            clicked = true;
                            /* do something then revert back to false before exiting */
                
                            img = prepareImage("Images/EmptyTile-01.png");
                            setButton(temp, img);
                        }
                    }
                });
            }
        }

        // WHAT: when button is clicked
        // WHY: when a JButton is clicked, disable the button and change the image
        //		to empty tile from tile, OR other tiles like mine or numbers...
        /*if (clicked) {
            //buttons.setEnabled(true);
        } else {
            //buttons.setEnabled(false);
        }*/
    }

    public void setButton(JButton button, ImageIcon img) {
        button.setVisible(true);
        button.setBackground(Color.GRAY);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setIcon(img);
    }

    public ImageIcon prepareImage(String link) {
        ImageIcon tempimgicon= new ImageIcon(getClass().getResource(link));
        Image tempimg = tempimgicon.getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH);
        return new ImageIcon(tempimg);
            // SOURCE: https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
    }
}
