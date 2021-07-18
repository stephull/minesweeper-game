/*
    Gameplay.java

*/

//import java.io.*;
//import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gameplay extends Main {

    public Gameplay() {
        // default constructor
    }

    // main gameplay function
    public Gameplay(JPanel panel) {
        test(panel);
    }       

    public void test(JPanel panel) {
                // test button
                JButton testinside = new JButton();
                testinside.setVisible(true);
                testinside.setText("HELLO AGAIN!");
                testinside.setPreferredSize(new Dimension(40, 40));
        
                // test action listener on button too
                testinside.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        testinside.setText("IT'S ME");
                    }
                });
                panel.add(testinside);
    }

    // NOTE: all methods here are to be executed in real time while gameplay is initiated
    
    public void randomizeMines() {
        // start of game: randomize mine placement using number generation
        // NOTE: originally thinking of placing new board, skip that!
    }

    public void clearMines() {
        // if one clicks on a clear tile, clear out respective spaces
    }

    public void configureNums() {
        // how many mines are nearby? 1 to 7
    }

    public void showMines() {
        // show mines when game is done, and show marked incorrect mines too
    }
}
