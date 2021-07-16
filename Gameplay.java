/*
    Gameplay.java

*/

//import java.io.*;
//import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gameplay extends Main {

    // main gameplay function
    public Gameplay(JPanel panel) {

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

    public void clearMines() {
        // if one clicks on a clear tile, clear out respective spaces
    }

    public void sendNums() {
        // how many mines are nearby? 1 to 7
    }
}
