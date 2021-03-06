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

public class Window extends JFrame {
    private String projectTitle = "Minesweeper Project Test";
    protected final String FLAG = "Images/Flag.png";

    // constant values for dimensional purposes
    protected int MAX_WIDTH = 700;
    protected int MAX_HEIGHT = 500;

    // for help options, windows will always appear smaller...
    protected final int HELP_WIDTH = 600;
    protected final int HELP_HEIGHT = 480;

    // string values for modes
    protected final String EASY = "Easy";
    protected final String MED = "Medium";
    protected final String HARD = "Hard";
    protected final String CRAZY = "Crazy";

    // menu items and bar properties
    private JMenuBar menubar;
    private JMenu singlemode, multimode;
    private JMenu onevsall, onevsbomb;
    private JMenuItem easysingle, mediumsingle, hardsingle, crazysingle;
    private JMenuItem easyvsall, mediumvsall, hardvsall, crazyvsall;
    private JMenuItem easybomb, mediumbomb, hardbomb, crazybomb;
    private JMenu datamenu;
    private JMenuItem data, scores;
    private JMenu optionsmenu, helpmenu;
    private JMenuItem opfeedback;
    private JMenuItem helphowto, helpcontrols, helpabout;

    // status bar for the bottom of window, static for all classes to access
    protected static JLabel readDirection = new JLabel("[ , ]");
    protected static JLabel readStatus = new JLabel("STATUS BAR");

    Window() {
        // default constructor
    }

    Window(JPanel panel) {
        // frame properties
        this.setTitle(projectTitle);
        toggleWindowSize(false);
        this.setVisible(true);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(180, 100, MAX_WIDTH, MAX_HEIGHT);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(FLAG));

        // panel + layout
        panel = new JPanel();
        panel.setLayout(new BorderLayout(4, 0));
            // CONSIDER: https://docs.oracle.com/javase/tutorial/uiswing/layout/box.html
        panel.setVisible(true);
        this.add(panel); 

        // menu + status bar 
        createMenu(panel);
        panel.add(readStatus, BorderLayout.SOUTH);

        // action listeners + PANEL
        enableMenuActions();
        new Configurations(panel);
    }

    public void toggleWindowSize(boolean b) {
        this.setResizable(b);
    }

    // all menu bar properties and action listener methods
    protected void createMenu(JPanel panel) {
  
        // menu bar for top of program
        menubar = new JMenuBar();
        menubar.setBounds(0, 0, MAX_WIDTH, 30);
        
        // ...single player drop down menu
        singlemode = new JMenu("Single Player");
        menubar.add(singlemode);
        easysingle = new JMenuItem(EASY);
        mediumsingle = new JMenuItem(MED);
        hardsingle = new JMenuItem(HARD);
        crazysingle = new JMenuItem(CRAZY);
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

        // ... data menu
        datamenu = new JMenu("Data");
        data = new JMenuItem("Player Data");
        scores = new JMenuItem("Scoreboard");
        datamenu.add(data);
        datamenu.add(scores);
        menubar.add(datamenu);

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

        readDirection.setForeground(Color.BLUE);
        menubar.add(readDirection, SpringLayout.EAST);

        panel.add(menubar, BorderLayout.NORTH);
    }

    protected void enableMenuActions() {

        // single player AND multiplayer
        easysingle.addActionListener(new WindowActionListener());
        mediumsingle.addActionListener(new WindowActionListener());
        hardsingle.addActionListener(new WindowActionListener());
        crazysingle.addActionListener(new WindowActionListener());
        easyvsall.addActionListener(new WindowActionListener());
        mediumvsall.addActionListener(new WindowActionListener());
        hardvsall.addActionListener(new WindowActionListener());
        crazyvsall.addActionListener(new WindowActionListener());
        easybomb.addActionListener(new WindowActionListener());
        mediumbomb.addActionListener(new WindowActionListener());
        hardbomb.addActionListener(new WindowActionListener());
        crazybomb.addActionListener(new WindowActionListener());
        
        // data and scoreboard for all users
        data.addActionListener(new WindowActionListener());
        scores.addActionListener(new WindowActionListener());

        // options + help
        opfeedback.addActionListener(new WindowActionListener());
        helphowto.addActionListener(new WindowActionListener());
        helpcontrols.addActionListener(new WindowActionListener());
        helpabout.addActionListener(new WindowActionListener());
    }

    // actionListener interface
    // FROM: https://www.tutorialspoint.com/swing/swing_action_listener.htm 
    class WindowActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            readStatus.setText(e.toString());
    
            if (e.getSource() == easysingle ||
                e.getSource() == mediumsingle || 
                e.getSource() == hardsingle ||
                e.getSource() == crazysingle) {
                readStatus.setText(":: SINGLE PLAYER MODE :: " + e.toString());
                /*
                     TIME COMPLEXITY PROBLEM: more tiles = way more time to load up...
                */
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
    
            // for user data and all scores
            if (e.getSource() == data) {
                new DataHelp(0);
            } else if (e.getSource() == scores) {
                new DataHelp(1);
            }

            // feedback option, redirect to website for user input
            if (e.getSource() == opfeedback) {
                opfeedback.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent me) {
                        if (SwingUtilities.isLeftMouseButton(me)) {
                            try {
                                Desktop.getDesktop().browse(new URI("https://minesweeperonline.com/"));
                                    // works once, if you click on it two times...
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
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
                    new Window(new JPanel());
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
