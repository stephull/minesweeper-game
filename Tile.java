/*
    Tile.java
*/

import javax.swing.*;
//import java.awt.*;

public class Tile extends Board {

    // configurations for whether the tile
    // contains a mine and whether user flags it
    protected boolean mine;
    protected boolean flagged;
    protected boolean clicked;
    protected boolean numerated;
    protected ImageIcon image;

    // 0-8 mines closeby
    protected JLabel label;
    protected int closeMines;
    protected int x, y;

    Tile(boolean mine, int i, int j) {
        this.mine = mine;
        flagged = clicked = numerated = false;
        closeMines = 0;
        x = i;
        y = j;
        label = new JLabel();
        prepareImage(DEF);
    }

    public int getI() {
        return x;
    }

    public int getJ() {
        return y;
    }

    public String getCoors() {
        return "[" + x + ", " + y + "]";
    }

    // getters and setters for boolean and int values
    public void setMine(boolean m) {
        mine = m;
    }
    public boolean getMine() {
        return mine;
    }

    public void setFlag(boolean f) {
        flagged = f;
    }
    public boolean isFlagged() {
        return flagged;
    }

    public void click() {
        clicked = true;
    }
    public boolean isClicked() {
        return clicked;
    }

    public void setCloseMines(int c) {
        closeMines = c;
    }
    public int getCloseMines() {
        return closeMines;
    }

    public void setNumerated(boolean n) {
        numerated = n;
    }
    public boolean isNumerated() {
        return numerated;
    }

    public void setLabel(JLabel l) {
        label = l;
    }
    public JLabel getLabel() {
        return label;
    }
}
