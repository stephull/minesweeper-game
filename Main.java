import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Main {

    // constant values for dimensional purposes
    public static final int MAX_WIDTH = 840;
    public static final int MAX_HEIGHT = 840;

    // main method
    public static void main(String[] args) {
        // frame properties, add window
        JFrame frame = new JFrame();
        frame.setTitle("Minesweeper Project");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(MAX_WIDTH, MAX_HEIGHT);

        // panel
        JPanel panel = new JPanel(new GridLayout(20, 4, 4, 4));
        panel.setVisible(true);
        frame.add(panel);

        // ::: DEFAULT SETTINGS FOR FIRST GAME :::
        boolean single = true;      
            // set to single player for default settings, when opening the game
        int mode = 0;       
            // 0 for easy, 1 for med., 2 for hard, 3 for crazy, 4 for etc.
        int type = 0;
            // for multiplayer, 0 for one vs. one, 1 for one vs. bomb

        // menu bar for top of program
        JMenuBar menubar = new JMenuBar();
        menubar.setBounds(0, 0, MAX_WIDTH, 30);
        
        // ...single player drop down menu
        JMenu singlemode = new JMenu("Single Player");
        menubar.add(singlemode);
        JMenuItem easysingle = new JMenuItem("Easy");
        JMenuItem mediumsingle = new JMenuItem("Medium");
        JMenuItem hardsingle = new JMenuItem("Hard");
        JMenuItem crazysingle = new JMenuItem("Crazy");
        singlemode.add(easysingle);
        singlemode.add(mediumsingle);
        singlemode.add(hardsingle);
        singlemode.add(crazysingle);

        // ... multiplayer drop down menu
        JMenu multimode = new JMenu("Multiplayer");
        menubar.add(multimode);
        JMenuItem onevsall = new JMenuItem("One vs. All");
        JMenuItem onevsbomb = new JMenuItem("One vs. Bomb");
        multimode.add(onevsall);
        multimode.add(onevsbomb);

        // ... options menu
        JMenu optionsmenu = new JMenu("Options");
        menubar.add(optionsmenu);
        
        // ... help menu
        JMenu helpmenu = new JMenu("Help");
        menubar.add(helpmenu);
        JMenuItem helphowto = new JMenuItem("How to Play");
        JMenuItem helpcontrols = new JMenuItem("Controls");
        JMenuItem helpabout = new JMenuItem("About");
        helpmenu.add(helphowto);
        helpmenu.add(helpcontrols);
        helpmenu.add(helpabout);

        panel.add(menubar);

        // test button :-)
        JButton button = new JButton();
        button.setText("Test Button");
        button.setPreferredSize(new Dimension(40, 40));
        panel.add(button);  
        
        if (single) {
            new Gameplay(panel, mode);
        } else {
            new Gameplay(panel, mode, type);
        }
    }
}