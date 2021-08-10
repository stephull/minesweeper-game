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

    Tile() {
        //default constructor
    }

    Tile(boolean mine) {
        this.mine = mine;
        flagged = clicked = false;
        closeMines = 0;

        ImageIcon img = prepareImage(DEF);
    }

    protected ImageIcon prepareImage(String link) {
        ImageIcon temp = new ImageIcon(getClass().getResource(link));
        return new ImageIcon(temp.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
            // SOURCE: https://stackoverflow.com/questions/6714045/
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
