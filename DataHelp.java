/*
    DataHelp.java
    For the data menu, one option will save the data for the user while another
    option will tabulate all the recorded scores for the entirety of Minesweeper.
*/

import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DataHelp extends Window implements MenuListener {

    /*
            ```DATA (in order):
        username, high score, mode, difficulty, --> number of games played, number of games won 
            ```SCOREBOARD (in order):
        username, high score, mode, difficulty, --> ID (if multiplayer, otherwise #000000)
            ```OPTIONS: 
            sort user alphabetically
            sort by highest score
            sort by lowest or highest difficulty
            & sort by ID (if applicable)
    */

    protected final String USER_TEXT = "User: ";
    protected final String HIGHEST_SCORE_TEXT = "Highest score: ";
    protected final String MODE_TEXT = "Mode: ";
    protected final String DIFF_TEXT = "Difficulty: ";
    protected final String GAMES_PLAYED_TEXT = "Games played total under: ";
    protected final String GAMES_WON_TEXT = "Games won: ";
    protected final String MULTI_ID_TEXT = "Multiplayer Game ID: ";

    private JLabel userLabel, highScoreLabel, modeLabel, difficultyLabel;
    private JLabel gamesPlayedLabel, gamesWonLabel, multiIDLabel;
    private String user, mode, diff;
    private int score, gamesPlayed, gamesWon, id; 

    private JFrame frame;
    private String[] titles = {
        "User Data", "Scoreboard"
    };

    // diff,player,username,time,wins ::: reads .csv or SQL data?
    protected ArrayList<String[]> dataLines = new ArrayList<>();

    DataHelp() {
        // default constructor, for Database.java
    }

    DataHelp(int type) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.pack();
        frame.setBounds(240, 80, HELP_WIDTH, HELP_HEIGHT);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(FLAG));
        frame.setLayout(new GridLayout(2, 2));

        user = "";

        userLabel = new JLabel();
        highScoreLabel = new JLabel();
        modeLabel = new JLabel();
        difficultyLabel = new JLabel();
        gamesPlayedLabel = new JLabel();
        gamesWonLabel = new JLabel();
        multiIDLabel = new JLabel();

        userLabel.setText(USER_TEXT + user);
        highScoreLabel.setText(HIGHEST_SCORE_TEXT + score);
        modeLabel.setText(MODE_TEXT + mode);
        difficultyLabel.setText(DIFF_TEXT + diff);
        gamesPlayedLabel.setText(GAMES_PLAYED_TEXT + gamesPlayed);
        gamesWonLabel.setText(GAMES_WON_TEXT + gamesWon);
        multiIDLabel.setText(MULTI_ID_TEXT + id);

        display(type);
        frame.setTitle(titles[type]);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String newUser) {
        this.user = newUser;
    }

    public int getHighScore() {
        return score;
    }

    public void setHighScore(int newScore) {
        newScore = score;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String newMode) {
        newMode = mode;
    }

    public String getDifficulty() {
        return diff;
    }

    public void setDifficulty(String newDiff) {
        newDiff = diff;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int newGamesPlayed) {
        newGamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int newGamesWon) {
        newGamesWon = gamesWon;
    }

    public int getMultiID() {
        return id;
    }

    public void setMultiID(int newID) {
        newID = id;
    }

    //

    public void display(int type) {
        JPanel base = new JPanel();
        base.add(userLabel);
        base.add(highScoreLabel);
        base.add(modeLabel);
        base.add(difficultyLabel);
        if (type > 0) {
            base.add(multiIDLabel);
        } else {
            base.add(gamesPlayedLabel);
            base.add(gamesWonLabel);
        }
        frame.add(base);
    }

    public void tabulate() {
        
    }

    // DEFAULT IMPLEMENTATIONS FOR MENULISTENER
    @Override
    public void menuSelected(MenuEvent e) {
        
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        
    }
}
