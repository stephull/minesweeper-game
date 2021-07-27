/* 
    MenuHelp.java
    For the help menu, each option will open a new window with the main window
    open. This includes instructions for how to play the game, control configurations,
    and credits via the about option.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MenuHelp extends Window implements MenuListener {

    // for help options, windows will always appear smaller...
    private final int HELP_WIDTH = 600;
    private final int HELP_HEIGHT = 480;

    // panel for window
    private JFrame frame;
    private JPanel helppanel;
    private String[] titles = new String[] {
        "How to Play", "Controls", "About"
    };

    MenuHelp() {
        // default constructor
    }

    MenuHelp(int type) {
        // new frame + panel contents
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.pack();
        frame.setBounds(240, 80, HELP_WIDTH, HELP_HEIGHT);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Images/Flag.png"));
        frame.setLayout(new GridLayout(2, 2));
        //frame.setLayout(new GridBagLayout());
        helppanel = new JPanel();
        //c = new GridBagConstraints();

        JLabel helplabel = new JLabel();
        helplabel.setText(titles[type]);
        /*c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.insets = insets;*/
        helplabel.setBackground(Color.RED);
        helppanel.add(helplabel);

        switch(type) {
            case 0: displayHowTo(new JPanel()); break;
            case 1: displayControls(new JPanel()); break;
            case 2: displayAbout(new JPanel()); break;
        }
        frame.setTitle(titles[type]);
        frame.add(helppanel);
    }

    /*
        HOW TO PLAY
    */
    private void displayHowTo(JPanel panel) {
        JButton single = new JButton();
        JButton multi = new JButton();
        single.setText("Single Player Rules");
        multi.setText("Multiplayer Rules");

        // if text is written on screen, dispose and replace with
        // requested text; window starts with nothing on it
        JLabel singlepanel = new JLabel();
        JLabel multipanel = new JLabel();
        panel.add(singlepanel);
        panel.add(multipanel);
        panel.add(single);
        panel.add(multi);
                                 
        // if user clicks on either button, the text will change
        // based on the rules applied.
        single.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helppanel.setBackground(Color.YELLOW);
                singlepanel.setText("<html></html>");
                System.out.println(singlepanel);
                helppanel.add(singlepanel);
            }
        });
        multi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                helppanel.setBackground(Color.GREEN);
                multipanel.setText("<html></html>");
                System.out.println(multipanel);
                helppanel.add(multipanel);
            }
        });

        helppanel.add(panel);
    }

    /*
        CONTROLS
    */
    private void displayControls(JPanel panel) {
        JLabel controlsText1 = new JLabel();
        controlsText1.setText("<html><ul style='list-style-type: lower-alpha'>" +
        "<dt><u>GENERAL</u></dt><br>" +
        "<dd>&emsp;SMILEY - left click to reset game</dd><br>" + 
        "<dt><u>IN GAME</u></dt><br>" +
        "<dd>&emsp;LEFT CLICK - clear a tile</dd><br>" + 
        "<dd>&emsp;RIGHT CLICK - flag tile (where a suspected mine is located) </dd><br>" +
        "<dt><u>KEYBOARD SHORTCUTS</u></dt><br>" + 
        "<dd>&emsp;SPACE BAR - (optional), start game by randomly assigning a tile to clear out</dd><br>" +
        "</ul></html>");

        panel.add(controlsText1);
        helppanel.add(panel);
    }

    /*
        ABOUT + CREDS
    */
    private void displayAbout(JPanel panel) {
        JLabel aboutText1 = new JLabel(), aboutText2 = new JLabel();
        aboutText1.setText("<html>" + 
        "<p>&emsp;Minesweeper is a puzzle game, where the objective is to clear all mines from a board<br>" +
        "of tiles without touching one. Typically playable with one player only, the game presents<br>" +
        "with a timer, a counter that determines the number of flags and mines, a button that contains<br>" +
        "a smiley face, and a board. Once the user clicks on the board, the game commences and the timer<br>" +
        "activates. The user can flag a tile where there may be a mine, but once a tile with a mine has been<br>" +
        "detonated, the game is over. The first click is always never a mine, and using flags is not required!<br></p>"
         + "</html>");
         aboutText2.setText("<html>" +
         "<b>About the Creator</b><br>" +
         "<p>&emsp;&emsp;My name is <u>Stephen Hullender</u>. &emsp;I am a Computer Science student attending Temple<br>" +
         "University. This project was programmed using Java, utilizing several libraries such as<br>" +
         "the SWING library, Abstract Window Toolkit, socket programming, and other related libraries.<br>" +
         "This project was first brainstormed in May 2021 when I had developed a habit of playing <br>" +
         "of Minesweeper to pass the time following an ardenous semester of Zoom University. Production began <br>" +
         "shortly after, but was halted until it was completely revamped and improved on July 2021. Since<br>" +
         "then, I've developed new skills in understanding how to create Java applications, as well as finding<br>" +
         "some knowledge in how to develop games. My goal is to create a simple and fun puzzle game, and to<br>" +
         "recreate it with some additional tools such as multiplayer interaction and customizable controls, along<br>"+
         "with implementing a database to keep scores, hopefully via SQL. </p>"
         + "</html>");

        /*c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;*/

        panel.add(aboutText1);
        panel.add(aboutText2);
        helppanel.add(panel);
    }

    /*
        AUTO-GENERATED METHODS FOR MENU
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
}
