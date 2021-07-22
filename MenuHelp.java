/* 
    MenuHelp.java
    For the help menu, each option will open a new window with the main window
    open. This includes instructions for how to play the game, control configurations,
    and credits via the about option.
*/

import java.awt.Toolkit;

import javax.swing.*;
import javax.swing.event.*;

public class MenuHelp extends Window implements MenuListener {

    // for help options, windows will always appear smaller...
    private static final int HELP_WIDTH = 600;
    private static final int HELP_HEIGHT = 480;

    public MenuHelp() {
        // default constructor
    }

    public MenuHelp(int type) {
        String[] titles = new String[] {
            "How to Play", "Controls", "About"
        };

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            // NOTE: EXIT_ON_CLOSE exits everything!
        frame.setVisible(true);
        frame.setResizable(true);
        frame.pack();
        frame.setBounds(240, 80, HELP_WIDTH, HELP_HEIGHT);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Images/Flag.png"));
        /*
            QUESTION: when closing the help window, everything closes.
                How to fix this? 0_0
        */

        JPanel help = new JPanel();
        JLabel helplabel = new JLabel();
        helplabel.setText(titles[type]);
        frame.setTitle(titles[type]);
        frame.add(help);
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
