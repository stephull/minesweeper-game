import java.util.*;
import java.util.Timer; // explicit import
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Control extends Main {

        // ::: DIFFICULTIES :::
    // easy difficulty -- STANDARD (mode 0)
    public static final int EASY_WIDTH = 9;
    public static final int EASY_HEIGHT = 9;

    // medium difficulty    (mode 1)
    public static final int MED_WIDTH = 16;
    public static final int MED_HEIGHT = 16;

    // hard difficulty  (mode 2)
    public static final int HARD_WIDTH = 16;
    public static final int HARD_HEIGHT = 30;

    // crazy difficulty (mode 3)
    public static final int CRAZY_WIDTH = 30;
    public static final int CRAZY_HEIGHT = 30;

    // for optional settings, must be no more than 3600 tiles
    // (mode 4)
    public static final int ABS_WIDTH = 60;
    public static final int ABS_HEIGHT = 60;

    boolean active; // the game is running on a timer?
    Timer timer;    // for timer
    TimerTask ttask;
    int mines;      // number of mines
    int smile;      // for smiley face button

    public Control(JPanel mainpanel, int mode, boolean isMulti, int type) {
        JPanel controlpanel = new JPanel();
        controlpanel.setBackground(Color.RED);
                // test case

        active = false;
        timer = new Timer("Timer");

        switch(mode) {
            case 1:
                mines = 40;
                break;
            case 2:
                mines = 99;
                break;
            case 3:
                mines = 255;
                break;
            case 4:
                Random rand = new Random();
                mines = rand.nextInt(600) + 255;
                    // fix later
                break;
            default:
                mines = 10;
                break;
        }
        mainpanel.add(controlpanel);

        createBoard(mainpanel);
    }

    public void createBoard(JPanel mainpanel) {
        JPanel board = new JPanel();
        board.setBackground(Color.GREEN);

        for (int i = 0; i < 8; i++) {

        }

        mainpanel.add(board);
    }

    public void startGame() {
        // start the game WHEN user clicks on first tile on board...
        active = true;
        while (active) {

        }
    }

    public void clearMines() {
        // if one clicks on a clear tile, clear out respective spaces
    }

    public void sendNums() {
        // how many mines are nearby? 1 to 7
    }

    public void requestMorePlayers() {
        // for multiplayer, get at least 1-3 other players for games
    }
    
}
