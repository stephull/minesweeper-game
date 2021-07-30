/*
    DataHelp.java

*/

import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class DataHelp extends Window implements MenuListener {

    protected static final String GAMES_PLAYED_TEXT = "Games played total under: ";
    protected static final String GAMES_WON_TEXT = "Games won: ";
    protected static final String HIGHEST_SCORE_TEXT = "Highest score: ";

    protected static String username;

    private JFrame frame;
    private JPanel panel;

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
        frame.setBounds(240, 80, MIN_WIDTH, MIN_HEIGHT);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Images/Flag.png"));
        frame.setLayout(new GridLayout(2, 2));

        username = "";

        
    }

    public void displayUserData() {

    }

    public void displayScoreboard() {

    }

    public void extractGamesPlayed() {
        
    }

    public void extractGamesWon() {

    }

    public void extractHighestScore() {

    }

    public void tabulateScores() {
        // includes CSV file 'scores.csv'
    }

    public String exportUsername() {
        return username;
    }

    /*
        DEFAULT IMPLEMENTATIONS FOR MENULISTENER
    */
    @Override
    public void menuSelected(MenuEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void menuDeselected(MenuEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void menuCanceled(MenuEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    // scores.csv NOTES
    // diff -> easy, medium, hard, crazy, customized
    // player -> 1 (single player), 2 (multiplayer)
    // username -> {user's input}
    // time -> {whoever beat the game with most time to spare}
    // wins -> {keep track of how many 'user' did}
}
