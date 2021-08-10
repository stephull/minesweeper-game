/*
    Tile.java
*/

import javax.swing.*;
import java.awt.*;

public class Tile extends Board {

    // configurations for whether the tile
    // contains a mine and whether user flags it
    protected boolean mine;
    protected boolean flagged;
    protected boolean clicked;
    protected ImageIcon image;

    // 0-8 mines closeby
    protected int closeMines;
    protected int x, y;

    Tile() {
        //default constructor
    }

    Tile(boolean mine, int coorX, int coorY) {
        this.mine = mine;
        flagged = clicked = false;
        closeMines = 0;
        x = coorX;
        y = coorY;

        ImageIcon img = prepareImage(DEF);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCoors() {
        return "[" + x + ", " + y + "]";
    }

    public void setMine(boolean m) {
        mine = m;
    }

    public void setFlag(boolean f) {
        flagged = f;
    }

    public void click() {
        clicked = true;
    }

    public boolean isClicked() {
        return clicked;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public boolean hasMine() {
        return mine;
    }

    public void setCloseMines(int c) {
        closeMines = c;
    }

    public int getCloseMines() {
        return closeMines;
    }

}
