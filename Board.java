/* 
    Board.java
    Separate method for working on gameboard panel
*/

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//import java.util.concurrent.ThreadLocalRandom;

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
    protected final String FLAG = "Images/Flag.png";

    // color schemes
    protected Color normalColor = Color.GRAY;
    protected Color flagColor = Color.YELLOW;
    protected Color mineColor = Color.RED;

    // everything else...
    protected ArrayList<Tile> targetList;
    private Tile[][] tiles;
    private int flagClicks;
    private int flagCountFromBoard;

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

        //int remaining = 0;
        //double prob = (double) mines / (width * height);
        flagClicks = 0;
        flagCountFromBoard = mines;

        randomizeCoordinates(mines);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                tiles[i][j] = new Tile(false, i, j);
                Tile t = tiles[i][j];

                if (coordinatesList.contains(Arrays.asList(i, j))) {
                    targetList.add(t);
                    t.setMine(true);
                }
                JButton b = new JButton();
                setBoardButton(b, prepareImage(FULL), normalColor);
                base.add(b);
                
                b.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent me) {
                        if (SwingUtilities.isLeftMouseButton(me)) {
                            // IF left click, to clear mine

                            active = true;
                            if (t.hasMine()) {
                                setBoardButton(b, prepareImage(PRESENT), mineColor);
                                ms.changeFaces(FAIL);
                                gameOver = true;
                                active = false;
                            } else {
                                setBoardButton(b, prepareImage(EMPTY), normalColor);
                            }
                            b.removeMouseListener(this);
                        } else if (SwingUtilities.isRightMouseButton(me)) {
                            // IF right click, for flag

                            if (flagClicks % 2 == 0) {
                                setBoardButton(b, prepareImage(FLAG), flagColor);
                                if (t.hasMine()) {
                                    System.out.println("MINE CAUGHT");  // test
                                } else {
                                    if (!active && gameOver) {
                                        setBoardButton(b, prepareImage(CROSSED), mineColor);
                                        // so far, only works if game is not on,
                                        // we want it when the game ends
                                    }
                                }
                                mc.setCounter(flagCountFromBoard--);
                            } else {
                                setBoardButton(b, prepareImage(FULL), normalColor);
                                mc.setCounter(flagCountFromBoard++);
                            }
                            flagClicks++;
                        }
                    }
                });
            }
        }
    }

    protected Tile[][] setBoard() {
        return tiles;
    }

    protected void setBoardButton(JButton b, ImageIcon img, Color c) {
        b.setVisible(true);
        b.setBackground(c);    //test
        b.setFocusable(false);
        b.setIcon(img);
    }

    protected ImageIcon prepareImage(String link) {
        ImageIcon temp = new ImageIcon(getClass().getResource(link));
        return new ImageIcon(temp.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
            // SOURCE: https://stackoverflow.com/questions/6714045/
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

    protected void calculateCloseMines() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int count = 0;
                if (i > 0 && tiles[i-1][j].hasMine()) {
                    count++;    // touch top area
                }
                if (i < height - 1 && tiles[i+1][j].hasMine()) {
                    count++;    // touch bottom area
                }
                if (j > 0) {
                    // touch left
                    if (tiles[i-1][j-1].hasMine()) {
                        count++;    // touch upper-left
                    }
                    if (tiles[i][j-1].hasMine()) {
                        count++;    // touch left-left
                    }
                    if (tiles[i+1][j-1].hasMine()) {  
                        count++;    // touch lower-left
                    }
                }
                if (j < width - 1) {
                    // touch right
                    if (tiles[i-1][j+1].hasMine()) {
                        count++;    // touch upper-right
                    }
                    if (tiles[i][j+1].hasMine()) {
                        count++;    // touch right-right
                    }
                    if (tiles[i+1][j+1].hasMine()) {
                        count++;    // touch lower-right
                    }
                }
                tiles[i][j].setCloseMines(count);
                // IMPLEMENT: set count to corresponding number tile
                // (1-8) on [i][j]
            }
        }
    }
}