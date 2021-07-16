/*
    Window.java
    Define and initialize frame and panel properties for main Minesweeper window. 
    Includes menu bar for single player, multiplayer modes, help, and options. 
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

public class Window extends JFrame implements ActionListener {
    // constant values for dimensional purposes
    private static final int MAX_WIDTH = 720;
    private static final int MAX_HEIGHT = 720;

    private JMenuBar menubar;
    private JMenu singlemode, multimode;
    private JMenu onevsall, onevsbomb;
    private JMenuItem easysingle, mediumsingle, hardsingle, crazysingle;
    private JMenuItem easyvsall, mediumvsall, hardvsall, crazyvsall;
    private JMenuItem easybomb, mediumbomb, hardbomb, crazybomb;

    private JMenu optionsmenu, helpmenu;
    private JMenuItem helphowto, helpcontrols, helpabout;

    public JLabel readStatus;

    public Window(JFrame frame, JPanel panel) {
        // frame properties
        frame.setTitle("Minesweeper Project -- TEST");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(MAX_WIDTH, MAX_HEIGHT);

        // panel
        panel = new JPanel(new GridLayout(8, 4, 4, 4));
            // redefine panel settings
        panel.setVisible(true);
        frame.add(panel); 

        // menu + status bar 
        createMenu(panel);
        readStatus = new JLabel("MINESWEEPER BEEP BOOP");
        readStatus.setSize(350, 100);
        panel.add(readStatus, BorderLayout.SOUTH);
        enableMenuActions();

        // redirect to the controls
        new Control(panel);
    }

    /*
        all menu bar properties and action listener methods
    */
    public void createMenu(JPanel panel) {
        // menu bar for top of program
        menubar = new JMenuBar();
        menubar.setBounds(0, 0, MAX_WIDTH, 30);
        
        // ...single player drop down menu
        singlemode = new JMenu("Single Player");
        menubar.add(singlemode);
        easysingle = new JMenuItem("Easy");
        mediumsingle = new JMenuItem("Medium");
        hardsingle = new JMenuItem("Hard");
        crazysingle = new JMenuItem("Crazy");
        singlemode.add(easysingle);
        singlemode.add(mediumsingle);
        singlemode.add(hardsingle);
        singlemode.add(crazysingle);

        // ... multiplayer drop down menu
        multimode = new JMenu("Multiplayer");
        menubar.add(multimode);
        onevsall = new JMenu("One vs. All");
        onevsbomb = new JMenu("One vs. Bomb");
        multimode.add(onevsall);
        multimode.add(onevsbomb);
        easyvsall = new JMenuItem("Easy");
        mediumvsall = new JMenuItem("Medium");
        hardvsall = new JMenuItem("Hard");
        crazyvsall = new JMenuItem("Crazy");
        onevsall.add(easyvsall);
        onevsall.add(mediumvsall);
        onevsall.add(hardvsall);
        onevsall.add(crazyvsall);
        easybomb = new JMenuItem("Easy");
        mediumbomb = new JMenuItem("Medium");
        hardbomb = new JMenuItem("Hard");
        crazybomb = new JMenuItem("Crazy");
        onevsbomb.add(easybomb);
        onevsbomb.add(mediumbomb);
        onevsbomb.add(hardbomb);
        onevsbomb.add(crazybomb);

        // ... options menu
        optionsmenu = new JMenu("Options");
        menubar.add(optionsmenu);
        
        // ... help menu
        helpmenu = new JMenu("Help");
        menubar.add(helpmenu);
        helphowto = new JMenuItem("How to Play");
        helpcontrols = new JMenuItem("Controls");
        helpabout = new JMenuItem("About");
        helpmenu.add(helphowto);
        helpmenu.add(helpcontrols);
        helpmenu.add(helpabout);

        panel.add(menubar, BorderLayout.NORTH);
    }

    public void enableMenuActions() {
        /*
            less than optimal solution to adding actionListener's
            for all menu items
            MORE: https://hajsoftutorial.com/jmenuitem-with-actionlistener/
        */
        easysingle.addActionListener(this);
        mediumsingle.addActionListener(this);
        hardsingle.addActionListener(this);
        crazysingle.addActionListener(this);
        easyvsall.addActionListener(this);
        mediumvsall.addActionListener(this);
        hardvsall.addActionListener(this);
        crazyvsall.addActionListener(this);
        easybomb.addActionListener(this);
        mediumbomb.addActionListener(this);
        hardbomb.addActionListener(this);
        crazybomb.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        readStatus.setText(e.toString());

        // for multiplayer options, apply socket programming
        if (e.getSource() == easyvsall || 
            e.getSource() == mediumvsall ||
            e.getSource() == hardvsall || 
            e.getSource() == crazyvsall ||
            e.getSource() == easybomb ||
            e.getSource() == mediumbomb ||
            e.getSource() == hardbomb ||
            e.getSource() == crazybomb) {
                readStatus.setText(":: REQUESTING SERVER CONNECTION ::" + e.toString());
                //new SocketMain();
                    // NOTE: gets stuck if left like this...
            }

        // for help menu
        if (e.getSource() == helphowto) {
            new MenuHelp(0);
        } else if (e.getSource() == helpcontrols) {
            new MenuHelp(1);
        } else if (e.getSource() == helpabout) {
            new MenuHelp(2);
        }
    }
}
