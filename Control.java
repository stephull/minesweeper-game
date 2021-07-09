import java.io.*;
import java.util.*;
import java.util.Timer; // explicit import
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Control extends JPanel implements ActionListener {

    boolean active; // the game is running on a timer?
    Timer timer;    // for timer
    TimerTask ttask;
    int mines;      // number of mines
    int smile;      // for smiley face button

    public Control(JPanel mainpanel, int mode) {
        JPanel controlpanel = new JPanel();

        active = false;
        
        timer = new Timer("Timer");
        

        switch(mode) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }
        mainpanel.add(controlpanel);
    }

    public void startGame() {
        // start the game WHEN user clicks on first tile on board...
        active = true;
        while (active) {

        }
    }

    public void clearMines() {
        // if one clicks on a clear tile, clear out respective spaces
    }

    public void sendNums() {
        // how many mines are nearby? 1 to 7
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
