/* 
    Board.java
    Separate method for working on gameboard panel
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends Window {

    // for board numbers, wherever a mine is located nearby
    protected final String ONE = "Images/boardOne.png";
    protected final String TWO = "Images/boardTwo.png";
    protected final String THREE = "Images/boardThree.png";
    protected final String FOUR = "Images/boardFour.png";
    protected final String FIVE = "Images/boardFive.png";
    protected final String SIX = "Images/boardSix.png";
    protected final String SEVEN = "Images/boardSeven.png";
    
    // at the end of a game, show mines on the board
    protected final String PRESENT = "Images/MinePresent.png";
    protected final String CROSSED = "Images/MineCrossed.png";
    
    // for tiles
    protected final String FULL = "Images/Tile.png";
    protected final String EMPTY = "Images/EmptyTile.png";

    private JButton[][] buttons;
    private ImageIcon img;
    //private boolean clicked;

    Board() {
        // default constructor
    }

    Board(JPanel base, GridBagConstraints c, int height, int width) {
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

                // QUESTION: fix this?????
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

    private void setButton(JButton button, ImageIcon img) {
        button.setVisible(true);
        button.setBackground(Color.GRAY);
        button.addActionListener(new CustomActionListener());
            // NOTE: addActionListener -> new CustomActionListener()
            // connects to window
        button.setFocusable(false);
        button.setIcon(img);
    }

    private ImageIcon prepareImage(String link) {
        ImageIcon temp = new ImageIcon(getClass().getResource(link));
        return new ImageIcon(temp.getImage().getScaledInstance(100, 90, Image.SCALE_SMOOTH));
            // SOURCE: https://stackoverflow.com/questions/6714045/
    }

    // NOTE: all methods here are to be executed in real time while gameplay is initiated
    // METHODS for in-game functions...
    protected void implementRandomMines() {
        
        // start of game: randomize mine placement using number generation

        // PSEUDOCODE
        /*
            if (user clicks on first tile) {
                generate randomized placements for mines using the number of mines permitted
                try to make sure they are not all stuck in one area, spread them out!
                (NOTE: look at Gameplay.java >> randomizeCoordinates()... hehe)
            }
            at the end, first tile is changed
        */
    }

    protected void clearMines() {
        // if one clicks on a clear tile, clear out respective spaces

        // PSEUDOCODE
        /*
            for every click in-game: 
            while (mines are not within vicinity) {
                keep clearing the area until there are mines incoming
            }
        */
    }

    protected void configureNums() {
        // how many mines are nearby? 1 to 7

        // PSEUDOCODE
        /*
            if mines are present in any of the following locations:
            anywhere nearby :: (-1, 0), (1, 0), (0, 1), (0, -1), (-1, 1), (-1, -1), (1, -1), (1,1)
            increment variable
            
            keep incrementing variable for every surrounding tile checked until all 8 are dismissed
            then plug in the number for the board number
        */
    }

    protected void showMines() {
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
