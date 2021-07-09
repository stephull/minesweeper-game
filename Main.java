import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Main {

    public static final int MAX_WIDTH = 720;
    public static final int MAX_HEIGHT = 720;
    public static void main(String[] args) {
        // frame properties, add window
        JFrame frame = new JFrame();
        frame.setTitle("Minesweeper");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(MAX_WIDTH, MAX_HEIGHT);

        // panel
        JPanel panel = new JPanel();
        frame.add(panel);

        // menu bar for top of program
        JMenuBar menubar = new JMenuBar();
        menubar.setBounds(0, 0, MAX_WIDTH, 30);
        
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

        JMenu multimode = new JMenu("Multiplayer");
        menubar.add(multimode);
        JMenuItem onevsall = new JMenuItem("One vs. All");
        JMenuItem onevsbomb = new JMenuItem("One vs. Bomb");
        multimode.add(onevsall);
        multimode.add(onevsbomb);

        JMenu optionsmenu = new JMenu("Options");
        menubar.add(optionsmenu);
        
        JMenu helpmenu = new JMenu("Help");
        menubar.add(helpmenu);
        JMenuItem helpcontrols = new JMenuItem("Controls");
        JMenuItem helpabout = new JMenuItem("About");
        helpmenu.add(helpcontrols);
        helpmenu.add(helpabout);

        frame.add(menubar);

        // test button :-)
        JButton button = new JButton();
        button.setText("Test Button");
        button.setSize(100, 50);
        frame.add(button);        
    }
}