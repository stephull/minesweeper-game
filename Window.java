import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Window extends Main {
    // constant values for dimensional purposes
    private static final int MAX_WIDTH = 720;
    private static final int MAX_HEIGHT = 720;

    Window(JFrame frame, JPanel panel) {
        // frame properties
        frame.setTitle("Minesweeper Project");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(MAX_WIDTH, MAX_HEIGHT);

        // panel
        panel = new JPanel(new GridLayout(8, 4, 4, 4));
            // redefine panel settings
        panel.setVisible(true);
        frame.add(panel); 
        createMenu(panel);

        // ::: DEFAULT SETTINGS FOR FIRST GAME :::
        boolean isMulti = false;      
            // set to single player for default settings, when opening the game
        int mode = 0;       
            // 0 for easy, 1 for med., 2 for hard, 3 for crazy, 4 for etc.
        int type = 0;
        if (isMulti) {
            type = 1;
        }
            // type is 0 if single player
            // otherwise, pick 1 or 2

        /*
            redirect to gameplay
        */
        new Control(panel, mode, isMulti, type);
    }

    public void createMenu(JPanel panel) {
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
        JMenu onevsall = new JMenu("One vs. All");
        JMenu onevsbomb = new JMenu("One vs. Bomb");
        multimode.add(onevsall);
        multimode.add(onevsbomb);
        JMenuItem easyvsall = new JMenuItem("Easy");
        JMenuItem mediumvsall = new JMenuItem("Medium");
        JMenuItem hardvsall = new JMenuItem("Hard");
        JMenuItem crazyvsall = new JMenuItem("Crazy");
        onevsall.add(easyvsall);
        onevsall.add(mediumvsall);
        onevsall.add(hardvsall);
        onevsall.add(crazyvsall);
        JMenuItem easybomb = new JMenuItem("Easy");
        JMenuItem mediumbomb = new JMenuItem("Medium");
        JMenuItem hardbomb = new JMenuItem("Hard");
        JMenuItem crazybomb = new JMenuItem("Crazy");
        onevsbomb.add(easybomb);
        onevsbomb.add(mediumbomb);
        onevsbomb.add(hardbomb);
        onevsbomb.add(crazybomb);

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
    }
}
