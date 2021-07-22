import javax.swing.ImageIcon;

/* 
    Board.java
    Separate method for working on gameboard panel
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends Window {

    // for board numbers, wherever a mine is located nearby
    public enum Vicinity {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN
    };
    public static final String ONE = "Images/boardOne.png";
    public static final String TWO = "Images/boardTwo.png";
    public static final String THREE = "Images/boardThree.png";
    public static final String FOUR = "Images/boardFour.png";
    public static final String FIVE = "Images/boardFive.png";
    public static final String SIX = "Images/boardSix.png";
    public static final String SEVEN = "Images/boardSeven.png";
    
    // at the end of a game, show mines on the board
    public enum Mines { PRESENT, CROSSED};
    public static final String PRESENT = "Images/MinePresent.png";
    public static final String CROSSED = "Images/MineCrossed.png";
    
    // for tiles
    public enum Tiles { FULL, EMPTY };
    public static final String FULL = "Images/Tile.png";
    public static final String EMPTY = "Images/EmptyTile.png";

    private JButton[][] buttons;
    private ImageIcon img;
    //private boolean clicked;

    public Board() {
        // default constructor
    }

    public Board(JPanel base, GridBagConstraints c, int height, int width) {
        buttons = new JButton[width][height];
        base.setLayout(new GridLayout(width, height));
        //clicked = false;

        // prepare image for button
        img = prepareImage(FULL);

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
                            readStatus.setText(":: BUTTON TEST :: " + e.toString());
                            //clicked = true;
                            /* do something then revert back to false before exiting */
                
                            img = prepareImage(EMPTY);
                            setButton(temp, img);
                        }
                    }
                });
            }
        }

        // PSEUDO CODE
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
        //return tempimgicon; 
        Image tempimg = tempimgicon.getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH);
        return new ImageIcon(tempimg);
            // SOURCE: https://stackoverflow.com/questions/6714045/how-to-resize-jlabel-imageicon
    }


    // NOTE: all methods here are to be executed in real time while gameplay is initiated
    // METHODS for in-game functions...
    public void randomizeMines() {
        // start of game: randomize mine placement using number generation
        // NOTE: originally thinking of placing new board, skip that!

        // PSEUDOCODE
        /*
            if (user clicks on first tile) {
                generate randomized placements for mines using the number of mines permitted
                try to make sure they are not all stuck in one area, spread them out!
                
                example:
                int temp = mines;
                Random rand = new Random();
                while (temp != 0) {
                    int place1 = rand.nextInt();
                    int place2 = rand.nextInt();

                    add mine to coordinates: board(place1, place2), corresponding to x, y

                    temp--;
                }
            }
            at the end, first tile is changed
        */
    }

    public void clearMines() {
        // if one clicks on a clear tile, clear out respective spaces

        // PSEUDOCODE
        /*
            for every click in-game: 
            while (mines are not within vicinity) {
                keep clearing the area until there are mines incoming
            }
        */
    }

    public void configureNums() {
        // how many mines are nearby? 1 to 7

        // PSEUDOCODE
        /*
            if mines are present in any of the following locations:
            left, right, up, down, northwest, southwest, southeast, northeast
            OR (-1, 0), (1, 0), (0, 1), (0, -1), (-1, 1), (-1, -1), (1, -1), (1,1)
            increment variable
            
            keep incrementing variable for every surrounding tile checked until all 8 are dismissed
            then plug in the number for the board number
        */
    }

    public void showMines() {
        // show mines when game is done, and show marked incorrect mines too

        // PSEUDOCODE
        /*
            if (game ends with PASS || user clicks on a mine) {
                if (mines are incorrectly flagged) {
                    show mines with cross-out on respective locations
                }
                show mines where placed, including the one clicked (if applicable)
            }
        */
    }
}
