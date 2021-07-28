/* 
    Board.java
    Separate method for working on gameboard panel
*/

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Board extends Configurations {

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

    // everything else...
    protected ArrayList<JButton> targetList;
    private JButton[][] buttons;
    private int buttonsClicked;

    Board() {
        // default constructor
    }

    Board(JPanel base, int height, int width) {
        buttons = new JButton[width][height];
        buttonsClicked = 0;
        base.setPreferredSize(new Dimension(640, 640));
        base.setBorder(new EmptyBorder(10, 10, 10, 10));
        base.setLayout(new GridLayout(9, 4, 1, 1));
        /**TEST */ //base.setBackground(Color.RED);
        targetList = new ArrayList<JButton>();

        // make button board on screen...
        int i = 0, j = 0;
        for (i = 0; i < width; i++) {
            for (j = 0; j < height; j++) {
                buttons[i][j] = new JButton();
                JButton tempBtn = buttons[i][j];
                if (coordinatesList.contains(Arrays.asList(i, j))) {
                    targetList.add(tempBtn);
                }
                setButton(tempBtn, prepareImage(FULL), Color.GRAY);
                base.add(tempBtn);

                /**
                 *  DIFFERENCE BETWEEN MOUSELISTENER & ACTIONLISTENER?
                 *  https://stackoverflow.com/questions/32399652/ 
                 */
                tempBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == tempBtn) {
                            active = true;
                            if (++buttonsClicked == 1) {
                                System.out.println("TEST GAME BEGIN");
                                /*if (targetList.contains(tempBtn)) {
                                    Random random = new Random();
                                }*/
                                //randomizeCoordinates(mines, width, height);
                                    // ???
                                //gameplay.run();
                                    // when first tile is clicked, we start game, timer, everything...
                                //implementRandomMines();
                                    // Do we need this?
                            } 
                            if (targetList.contains(tempBtn)) {
                                setButton(tempBtn, prepareImage(PRESENT), Color.RED);
                            } else {
                                setButton(tempBtn, prepareImage(EMPTY), Color.LIGHT_GRAY);
                            }
                            tempBtn.removeActionListener(this);
                        }
                    }
                });
            }
        }

        base.setBorder(new LineBorder(Color.BLACK, 2));
    }

    private void setButton(JButton button, ImageIcon img, Color color) {
        button.setVisible(true);
        button.setBackground(color);
        button.addActionListener(new CustomActionListener());
        button.setFocusable(false);
        button.setIcon(img);
    }

    private ImageIcon prepareImage(String link) {
        ImageIcon temp = new ImageIcon(getClass().getResource(link));
        return new ImageIcon(temp.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
            // SOURCE: https://stackoverflow.com/questions/6714045/
    }

    // NOTE: all methods here are to be executed in real time while gameplay is initiated
    // METHODS for in-game functions...
    protected void implementRandomMines() {
        
        // System.out.println("ANOTHER TEST, RANDOM MINES");

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

    // switch method from Gameplay.java to here
    protected void startBoard() {
        // when game is over, press the smiley face or switch game mode; board will start over
        /**
         *  GOAL: try to switch around action listener into its own class within Board.java
         *  and take JButton[][] buttons to implement onto the board, within THIS method.
         */
    }
}
