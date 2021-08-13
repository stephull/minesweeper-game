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

    // everything else...
    protected ArrayList<Tile> targetList, nonTargetList;
    private Tile[][] tiles;
    private JLabel[][] labels;
    private int flagClicks;
    private int flagCountFromBoard;

    Board() {
        // default constructor
    }

    Board(JPanel base, int mines) {
        base.setPreferredSize(new Dimension(640, 640));
        base.setBorder(new EmptyBorder(10, 10, 10, 10));
        base.setLayout(new GridLayout(9, 4, 1, 1));
        /**TEST */ //base.setBackground(Color.RED);
        base.setBorder(new LineBorder(Color.BLACK, 2));

        tiles = new Tile[width][height];
        labels = new JLabel[width][height];
        targetList = new ArrayList<Tile>();
        nonTargetList = new ArrayList<Tile>();

        flagClicks = 0;
        flagCountFromBoard = mines;

        randomizeCoordinates(mines);
        setBoard(base);
    }

    protected void setBoard(JPanel base) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j] = new Tile(false, i, j);
                Tile t = tiles[i][j];

                labels[i][j] = new JLabel();
                JLabel b = labels[i][j];

                if (coordinatesList.contains(Arrays.asList(i, j))) {
                    targetList.add(t);
                    t.setMine(true);
                } else {
                    nonTargetList.add(t);
                }
                setBoardButton(b, prepareImage(FULL));
                
                b.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent me) {
                        if (SwingUtilities.isLeftMouseButton(me)) {
                            // IF left click, to clear mine

                            active = true;
                            if (t.getMine()) {
                                setBoardButton(b, prepareImage(PRESENT));
                                ms.changeFaces(FAIL);
                                gameOver = true;
                                active = false;
                            } else {
                                setBoardButton(b, prepareImage(EMPTY));
                            }
                            b.removeMouseListener(this);
                        } else if (SwingUtilities.isRightMouseButton(me)) {
                            // IF right click, for flag

                            if (flagClicks % 2 == 0) {
                                setBoardButton(b, prepareImage(FLAG));
                                if (t.getMine()) {
                                    System.out.println("MINE CAUGHT");  // test
                                } else {
                                    if (!active && gameOver) {
                                        setBoardButton(b, prepareImage(CROSSED));
                                        // so far, only works if game is not on,
                                        // we want it when the game ends
                                    }
                                }
                                mc.setCounter(flagCountFromBoard--);
                            } else {
                                setBoardButton(b, prepareImage(FULL));
                                mc.setCounter(flagCountFromBoard++);
                            }
                            flagClicks++;
                        }
                    }
                });
                base.add(b);
            }
        }
        for (Tile a : nonTargetList) {
            calculateCloseMines(a.getI(), a.getJ());
        }
    }

    protected void setBoardButton(JLabel b, ImageIcon img) {
        b.setVisible(true);
        b.setFocusable(false);
        b.setIcon(img);
    }

    protected ImageIcon prepareImage(String link) {
        ImageIcon temp = new ImageIcon(getClass().getResource(link));
        return new ImageIcon(temp.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
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

    protected void calculateCloseMines(int i, int j) {
        int count = 0;
        // ORDER: northwest, north, northeast, east, southeast, south, southwest, west
        if (i > 0 && j > 0 && tiles[i-1][j-1].getMine()) {
            count++;
        }
        if (i > 0 && tiles[i-1][j].getMine()) {
            count++;
        }
        if (i > 0 && j < width-1 && tiles[i-1][j+1].getMine()) {
            count++;
        }
        if (j < width-1 && tiles[i][j+1].getMine()) {
            count++;
        }
        if (i < height-1 && j < width-1 && tiles[i+1][j+1].getMine()) {
            count++;
        }
        if (i < height-1 && tiles[i+1][j].getMine()) {
            count++;
        }
        if (i < height-1 && j > 0 && tiles[i+1][j-1].getMine()) {
            count++;
        }
        if (j > 0 && tiles[i][j-1].getMine()) {
            count++;
        }

        tiles[i][j].setCloseMines(count);
        //System.out.println("\t" + tiles[i][j].getCoors() + ":" + tiles[i][j].getCloseMines());

        ImageIcon temp = new ImageIcon();
        switch(tiles[i][j].getCloseMines()) {
            case 1: temp = prepareImage(ONE);
            case 2: temp = prepareImage(TWO);
            case 3: temp = prepareImage(THREE);
            case 4: temp = prepareImage(FOUR);
            case 5: temp = prepareImage(FIVE);
            case 6: temp = prepareImage(SIX);
            case 7: temp = prepareImage(SEVEN);
            default: temp = prepareImage(FULL);
        }
        setBoardButton(labels[i][j], temp);
    }
}