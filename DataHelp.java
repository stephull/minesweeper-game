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

    protected final String GAMES_PLAYED_TEXT = "Games played total under: ";
    protected final String GAMES_WON_TEXT = "Games won: ";
    protected final String HIGHEST_SCORE_TEXT = "Highest score: ";

    protected String user;

    private JFrame frame;
    private JPanel panel;
    private String[] titles = {
        "User Data", "Scoreboard"
    };

    // diff,player,username,time,wins
    protected ArrayList<String[]> dataLines = new ArrayList<>();

    DataHelp() {
        // default
    }

    DataHelp(int type) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.pack();
        frame.setBounds(240, 80, HELP_WIDTH, HELP_HEIGHT);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Images/Flag.png"));
        frame.setLayout(new GridLayout(2, 2));

        user = "";

        panel = new JPanel();
        frame.add(panel);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String newUser) {
        this.user = newUser;
    }

    public void getData() {

    }

    public void getGamesPlayed() {
        
    }

    public void getGamesWon() {

    }

    public void getHighScore() {
        // ??? include mode and difficulty ???
    }

    public void tabulateScores() {
        // includes CSV file 'scores.csv'
    }

    public void displayUserData() {

    }

    public void displayScoreboard() {

    }

    /*
        DEFAULT IMPLEMENTATIONS FOR MENULISTENER
    */
    @Override
    public void menuSelected(MenuEvent e) {
        
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        
    }
    
    // scores.csv NOTES
    // diff -> easy, medium, hard, crazy, customized
    // player -> 1 (single player), 2 (multiplayer)
    // username -> {user's input}
    // time -> {whoever beat the game with most time to spare}
    // wins -> {keep track of how many 'user' did}
}
