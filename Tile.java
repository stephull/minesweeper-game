public class Tile extends Board {

    // configurations for whether the tile
    // contains a mine and whether user flags it
    protected boolean mine;
    protected boolean flagged;
    protected boolean clicked;

    // 0-8 mines closeby
    protected int closeMines;

    Tile() {
        mine = flagged = clicked = false;
        closeMines = 0;
    }

    public void configureMine() {
        mine = true;
    }

    public void configureFlagTrue() {
        flagged = true;
    }

    public void configureFlagFalse() {
        // if someone unflags a tile
        flagged = false;
    }

    public void configureClick() {
        clicked = true;
    }

}
