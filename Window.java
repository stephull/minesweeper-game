/*
    Window.java
    Define and initialize frame and panel properties for main Minesweeper window. 
    Includes menu bar for single player, multiplayer modes, help, and options. 
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.time.format.*;
import java.time.*;

public class Window {

    // constant values for dimensional purposes
    private static final int MAX_WIDTH = 1080;//780;
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

    // status bar for the bottom of window, static for all classes to access
    protected static JLabel readStatus = new JLabel("STATUS BAR");
    protected static final Insets insets = new Insets(0, 0, 0, 0);

    Window() {
        // default constructor
    }

    Window(JFrame frame, JPanel panel) {
        // frame properties
        frame.setTitle("Minesweeper Project -- TEST");
        frame.setResizable(true);
        frame.setVisible(true);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(180, 60, MAX_WIDTH, MAX_HEIGHT);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Images/Flag.png"));

        // panel + layout
        panel = new JPanel();
        panel.setLayout(new BorderLayout(4, 0));
            // CONSIDER: https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
        panel.setVisible(true);
        frame.add(panel); 

        // menu + status bar 
        createMenu(panel);
        panel.add(readStatus, BorderLayout.SOUTH);

        // action listeners
        enableMenuActions();

        // redirect to the controls
        new Configurations(panel);
    }

    // all menu bar properties and action listener methods
    protected void createMenu(JPanel panel) {
  
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

        panel.add(menubar, BorderLayout.NORTH);
    }

    protected void enableMenuActions() {
        // MORE: https://hajsoftutorial.com/jmenuitem-with-actionlistener/

        // single player AND multiplayer
        easysingle.addActionListener(new CustomActionListener());
        mediumsingle.addActionListener(new CustomActionListener());
        hardsingle.addActionListener(new CustomActionListener());
        crazysingle.addActionListener(new CustomActionListener());
        easyvsall.addActionListener(new CustomActionListener());
        mediumvsall.addActionListener(new CustomActionListener());
        hardvsall.addActionListener(new CustomActionListener());
        crazyvsall.addActionListener(new CustomActionListener());
        easybomb.addActionListener(new CustomActionListener());
        mediumbomb.addActionListener(new CustomActionListener());
        hardbomb.addActionListener(new CustomActionListener());
        crazybomb.addActionListener(new CustomActionListener());
        
        // options + help
        opfeedback.addActionListener(new CustomActionListener());
        helphowto.addActionListener(new CustomActionListener());
        helpcontrols.addActionListener(new CustomActionListener());
        helpabout.addActionListener(new CustomActionListener());
    }

    // actionListener interface
    // FROM: https://www.tutorialspoint.com/swing/swing_action_listener.htm 
    class CustomActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            readStatus.setText(e.toString());
    
            if (e.getSource() == easysingle ||
                e.getSource() == mediumsingle || 
                e.getSource() == hardsingle ||
                e.getSource() == crazysingle) {
                readStatus.setText(":: SINGLE PLAYER MODE :: " + e.toString());
                if (e.getSource() == easysingle) {
                    readStatus.setText(" :: DEFAULT MODE :: " + e.toString());
                } else if (e.getSource() == crazysingle) {
                    readStatus.setText(" ::: WARNING: game may take a while to load due to user-customized constraints ::: " + e.toString());
                    /*
                        TIME COMPLEXITY PROBLEM: more tiles = way more time to load up...
                    */
                }
            }

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
                    // new SocketMain();    // NOTE: gets stuck...
                }
    
            // feedback option, redirect to website for user input
            if (e.getSource() == opfeedback) {
                readStatus.setText(":: CONNECTING TO INTERNET :: " + e.toString());
                opfeedback.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            Desktop.getDesktop().browse(new URI("https://www.roblox.com"));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        // BLANK
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        readStatus.setText(":: Please note that choosing 'Feedback'"
                            + " will redirect to a web browser ::");
                    }
                });
                // CHECK: https://www.codejava.net/java-se/swing/how-to-create-hyperlink-with-jlabel-in-java-swing
            }
    
            // for help menu
            if (e.getSource() == helphowto) {
                readStatus.setText(":: SELECT Help >> How To Play ::");
                new MenuHelp(0);
            } else if (e.getSource() == helpcontrols) {
                readStatus.setText(":: SELECT Help >> Controls ::");
                new MenuHelp(1);
            } else if (e.getSource() == helpabout) {
                readStatus.setText(":: SELECT Help >> About ::");
                new MenuHelp(2);
            }
        }

    }

    // main method for testing
    public static void main(String[] args) {
        // always print message before running program with timestamp...
        System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()) 
            + " :: Beginning Minesweeper...");

        // start
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Window(new JFrame(), new JPanel());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        /*
            EventQueue.invokeLater() involves threading; changes in the GUI will not 
            affect the current thread, but will operate after. 
            SOURCE: https://stackoverflow.com/questions/22534356/
        */
    }
}
