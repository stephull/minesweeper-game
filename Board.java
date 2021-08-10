/* 
    Board.java
    Separate method for working on gameboard panel
*/

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
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
    protected ArrayList<Tile> targetList;
    private Tile[][] tiles;

    Board() {
        // default constructor
    }

    Board(JPanel base, int mines) {
        tiles = new Tile[width][height];
        base.setPreferredSize(new Dimension(640, 640));
        base.setBorder(new EmptyBorder(10, 10, 10, 10));
        base.setLayout(new GridLayout(9, 4, 1, 1));
        /**TEST */ //base.setBackground(Color.RED);
        targetList = new ArrayList<Tile>();

        base.setBorder(new LineBorder(Color.BLACK, 2));
    }

    protected Tile[][] setBoard() {
        return tiles;
    }

    /*protected void setBoardButton(Tile t, ImageIcon img, Color color) {
        t.setVisible(true);
        t.setBackground(color);
        t.addActionListener(new WindowActionListener());
        t.setFocusable(false);
        t.setIcon(img);
    }*/

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

    protected void calculateCloseMines() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int count = 0;
                if (i > 0 && tiles[i-1][j].hasMine()) {
                    // check upwards
                    count++;
                }
                if (i < width-1 && tiles[i+1][j].hasMine()) {
                    // check downwards
                    count++;
                }
                if (i > 0 && tiles[i][j-1].hasMine()) {
                    // check left
                    count++;
                }
                if (i < height-1 && tiles[i][j+1].hasMine()) {
                    // check right 
                    count++;
                }
                if (i > 0 && tiles[i-1][j-1].hasMine()) {
                    // check northwest
                    count++;
                }
                if (i < height-1 && tiles[i-1][j+1].hasMine()) {
                    // check northeast
                    count++;
                }
                if (i > 0 && tiles[i+1][j-1].hasMine()) {
                    // check southwest
                    count++;
                }
                if (i < height-1 && tiles[i+1][j+1].hasMine()) {
                    // check southeast
                    count++;
                }
                tiles[i][j].setCloseMines(count);
            }
        }
    }
}