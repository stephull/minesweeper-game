/* 
    MenuHelp.java
    For the help menu, each option will open a new window with the main window
    open. This includes instructions for how to play the game, control configurations,
    and credits via the about option.
*/

import javax.swing.*;
import javax.swing.event.*;

public class MenuHelp extends Main implements MenuListener {

    public MenuHelp() {
        // default constructor
    }

    public MenuHelp(int type) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel help = new JPanel();
        JLabel helplabel = new JLabel();
        switch(type) {
            case 0:
                helplabel.setText("How to Play");
                break;
            case 1:
                helplabel.setText("Controls");
                break;
            case 2:
                helplabel.setText("About");
                break;
        }
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
