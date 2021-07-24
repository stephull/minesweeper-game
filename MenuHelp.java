/* 
    MenuHelp.java
    For the help menu, each option will open a new window with the main window
    open. This includes instructions for how to play the game, control configurations,
    and credits via the about option.
*/

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class MenuHelp extends Window implements MenuListener {

    // for help options, windows will always appear smaller...
    private static final int HELP_WIDTH = 600;
    private static final int HELP_HEIGHT = 480;

    // panel for window
    public JFrame frame;
    public JPanel helppanel;
    public String[] titles = new String[] {
        "How to Play", "Controls", "About"
    };

    public MenuHelp() {
        // default constructor
    }

    public MenuHelp(int type) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            // NOTE: EXIT_ON_CLOSE exits everything!
        frame.setVisible(true);
        frame.setResizable(true);
        frame.pack();
        frame.setBounds(240, 80, HELP_WIDTH, HELP_HEIGHT);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Images/Flag.png"));

        helppanel = new JPanel();
        c = new GridBagConstraints();

        JLabel helplabel = new JLabel();
        helplabel.setText(titles[type]);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.insets = insets;
        helplabel.setBackground(Color.RED);
        helppanel.add(helplabel, c);

        switch(type) {
            case 0: displayHowTo(); break;
            case 1: displayControls(); break;
            case 2: displayAbout(); break;
        }
        
        frame.setTitle(titles[type]);
        frame.add(helppanel);
    }

    public void displayHowTo() {
        JLabel label1 = new JLabel();
        label1.setText("How to Play Minesweeper");
        
        JButton single = new JButton();
        JButton multi = new JButton();
        single.setText("Single Player Rules");
        multi.setText("Multiplayer Rules");

        helppanel.add(single);
        helppanel.add(multi);
    }

    public void displayControls() {
        JLabel label1 = new JLabel();
        label1.setText("Controls for Minesweeper");

        helppanel.add(label1);
    }

    public void displayAbout() {
        JLabel label1 = new JLabel();
        label1.setText("Created by Stephen Hullender");
        label1.setBackground(Color.BLUE);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        helppanel.add(label1, c);
    }

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
