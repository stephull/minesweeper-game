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
    protected final String EIGHT = "Images/boardEight.png";
    
    // at the end of a game, show mines on the board
    protected final String PRESENT = "Images/MinePresent.png";
    protected final String CROSSED = "Images/MineCrossed.png";
    
    // for tiles
    protected final String FULL = "Images/Tile.png";
    protected final String EMPTY = "Images/EmptyTile.png";

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
        base = new JPanel();
        boardBase = base;

        base.setPreferredSize(new Dimension(640, 640));
        base.setBorder(new EmptyBorder(10, 10, 10, 10));
        base.setLayout(new GridLayout(9, 4, 1, 1));
        /**TEST */ //base.setBackground(Color.RED);
        base.setBorder(new LineBorder(Color.BLACK, 2));

        tiles = new Tile[width][height];
        labels = new JLabel[width][height];
        targetList = new ArrayList<Tile>();
        nonTargetList = new ArrayList<Tile>();

        flagCountFromBoard = mines;
        flagClicks = 0;

        // randomize mines and start board
        randomizeCoordinates(mines);
        setBoard(base);
    }

    public JPanel getBase() {
        return boardBase;
    }

    protected void setBoard(JPanel base) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j] = new Tile(false, i, j);
                Tile t = tiles[i][j];
                labels[i][j] = new JLabel();
                JLabel b = labels[i][j];
                t.setLabel(b);

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

                            //run();
                            active = true;
                            if (t.getMine()) {
                                setBoardButton(b, prepareImage(PRESENT));
                                ms.changeFaces(FAIL);
                                gameOver = true;
                                active = false;
                                showMines(t.getI(), t.getJ());
                            } else if (t.isNumerated()) {
                                setBoardButton(b, prepareImage(numerateCloseMines(t.getCloseMines())));
                            } else {
                                setBoardButton(b, prepareImage(EMPTY));
                            }
                            b.removeMouseListener(this);
                        } else if (SwingUtilities.isRightMouseButton(me)) {
                            // IF right click, for flag

                            if (flagClicks % 2 == 0) {
                                setBoardButton(b, prepareImage(FLAG));
                                /*if (t.getMine()) {
                                    System.out.println("MINE CAUGHT");  // test
                                }*/
                                if (gameOver && t.isFlagged() && nonTargetList.contains(t)) {
                                    setBoardButton(b, prepareImage(CROSSED));
                                    // this would only work if we also had a solution to restard board at once...
                                    // this is where showMines(), below, comes into place.
                                }
                                mc.setCounter(flagCountFromBoard--);
                                flagClicks = 1;
                            } else {
                                setBoardButton(b, prepareImage(FULL));
                                mc.setCounter(flagCountFromBoard++);
                                flagClicks = 0;
                            }
                        }
                    }
                    @Override
                    public void mouseClicked(MouseEvent me) {
                        if (SwingUtilities.isLeftMouseButton(me)) {
                            ms.changeFaces(INTER);
                        }
                    }
                    @Override 
                    public void mouseReleased(MouseEvent me) {
                        ms.changeFaces(DEF);
                    }
                    @Override
                    public void mouseEntered (MouseEvent me) {
                        readDirection.setForeground(Color.BLUE);
                        readDirection.setText(t.getCoors());
                        if (gameOver) {
                            readDirection.setVisible(false);
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
        return new ImageIcon(temp.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            // SOURCE: https://stackoverflow.com/questions/6714045/
    }

    protected void restart() {
        // DUPLICATE CODE FOR NOW, TEST RESTARTING GAME

        int i = 0, j = 0;
        if (i < 0 || j < 0 || i > height-1 || j > width-1) {
            return;
        }
        if (tiles[i][j].isClicked()) {
            return;
        }
        tiles[i][j].click();
        setBoardButton(tiles[i][j].getLabel(), prepareImage(FULL));

        showMines(i-1, j-1);
        showMines(i-1, j);
        showMines(i-1, j+1);
        showMines(i, j+1);
        showMines(i+1, j+1);
        showMines(i+1, j);
        showMines(i+1, j-1);
        showMines(i, j-1);
    }

    protected void clearMines(int i, int j) {
        // if one clicks on a clear tile, clear out respective spaces
        /*
            for every click in-game: 
            while (mines are not within vicinity) : keep clearing the area until there are mines incoming
        */
    }

    protected void showMines(int i, int j) {
        // show mines when game is done, and show marked incorrect mines too
        /*
            if (game ends with PASS || user clicks on a mine) {
                if (mines are incorrectly flagged) : show mines with cross-out on respective locations
                show mines where placed, including the one clicked (if applicable)
            }
        */

        if (i < 0 || j < 0 || i > height-1 || j > width-1) {
            return;
        }
        if (tiles[i][j].isClicked()) {
            return;
        }
        tiles[i][j].click();
        setBoardButton(tiles[i][j].getLabel(), prepareImage(EMPTY));

        showMines(i-1, j-1);
        showMines(i-1, j);
        showMines(i-1, j+1);
        showMines(i, j+1);
        showMines(i+1, j+1);
        showMines(i+1, j);
        showMines(i+1, j-1);
        showMines(i, j-1);
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

        if (count > 0) {
            tiles[i][j].setNumerated(true);
        }
        tiles[i][j].setCloseMines(count);
        //System.out.println(tiles[i][j].getCoors() + " : " + tiles[i][j].getCloseMines() + " \t " + tiles[i][j].isNumerated());
    }

    protected String numerateCloseMines(int i) {
        switch (i) {
            case 1: return ONE;
            case 2: return TWO;
            case 3: return THREE;
            case 4: return FOUR;
            case 5: return FIVE;
            case 6: return SIX;
            case 7: return SEVEN;
            case 8: return EIGHT;
            default: return FULL;
        }
    }
}