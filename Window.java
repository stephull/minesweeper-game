/*
    Window.java
    Define and initialize frame and panel properties for main Minesweeper window. 
    Includes menu bar for single player, multiplayer modes, help, and options. 
*/

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;

public class Window implements ActionListener {
    // constant values for dimensional purposes
    private static final int MAX_WIDTH = 780;
    private static final int MAX_HEIGHT = 720;

    // menu items and bar properties
    private JMenuBar menubar;
    private JMenu singlemode, multimode;
    private JMenu onevsall, onevsbomb;
    private JMenuItem easysingle, mediumsingle, hardsingle, crazysingle;
    private JMenuItem easyvsall, mediumvsall, hardvsall, crazyvsall;
    private JMenuItem easybomb, mediumbomb, hardbomb, crazybomb;
    private JMenu optionsmenu, helpmenu;
    private JMenuItem opfeedback;
    private JMenuItem helphowto, helpcontrols, helpabout;

    // status bar for the bottom of window
    public JLabel readStatus;

    // layout properties
    public GridBagConstraints c;
    private static final Insets insets = new Insets(0, 0, 0, 0);    // borders of a container

    public Window() {
        // default constructor
    }

    public Window(JFrame frame, JPanel panel) {
        // frame properties
        frame.setTitle("Minesweeper Project -- TEST");
        frame.setResizable(true);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(180, 60, MAX_WIDTH, MAX_HEIGHT);
        
        // image for window
        Image icon = Toolkit.getDefaultToolkit().getImage("Images/Flag.png");
        frame.setIconImage(icon);

        // panel + layout
        panel = new JPanel();
        c = new GridBagConstraints();
        panel.setLayout(new GridBagLayout());    // CONSIDER: https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
        panel.setVisible(true);
        frame.add(panel); 

        // menu + status bar 
        createMenu(panel, c);
        readStatus = new JLabel("STATUS BAR");

        // constraints for status bar, add onto panel
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        c.insets = insets;
        panel.add(readStatus, c);

        // action listeners
        enableMenuActions();

        // redirect to the controls
        new Control(panel, c);
    }

    /*
        all menu bar properties and action listener methods
    */
    public void createMenu(JPanel panel, GridBagConstraints c) {
  
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
        opfeedback = new JMenuItem("Feedback");
        optionsmenu.add(opfeedback);
        
        // ... help menu
        helpmenu = new JMenu("Help");
        menubar.add(helpmenu);
        helphowto = new JMenuItem("How to Play");
        helpcontrols = new JMenuItem("Controls");
        helpabout = new JMenuItem("About");
        helpmenu.add(helphowto);
        helpmenu.add(helpcontrols);
        helpmenu.add(helpabout);

        //c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = c.weighty = 0.5;
        c.gridx = c.gridy = 0;
        c.insets = insets;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        panel.add(menubar, c);
    }

    public void enableMenuActions() {
        /*
            less than optimal solution to adding actionListener's
            for all menu items
            MORE: https://hajsoftutorial.com/jmenuitem-with-actionlistener/
        */

        // single player AND multiplayer
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
        
        // options
        opfeedback.addActionListener(this);

        // help
        helphowto.addActionListener(this);
        helpcontrols.addActionListener(this);
        helpabout.addActionListener(this);
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
                readStatus.setText(":: REQUESTING SERVER CONNECTION :: " + e.toString());
                // new SocketMain();    // NOTE: gets stuck if left like this...
            }

        // feedback option, redirect to website for user input
        if (e.getSource() == opfeedback) {
            readStatus.setText(":: CONNECTING TO INTERNET :: " + e.toString());
            opfeedback.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://msn.com"));
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // BLANK
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    // BLANK
                }
            });
                // CHECK: https://www.codejava.net/java-se/swing/how-to-create-hyperlink-with-jlabel-in-java-swing
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
