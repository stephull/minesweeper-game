/*
    MineTimer.java
    Create object for timer in Minesweeper, contains all images and time counting properties. 
*/

import javax.swing.*;

public class MineTimer {
    
    public int time;
    public ImageIcon[] images;
    
    MineTimer() {
        // default settings
        time = 0;
        images = new ImageIcon[3];

        JButton button = new JButton();
        button.setText("Timer Test");
    }

    public void changeTime(int time) {
        // change images accordingly by its time using 0-9 analog png's 
        // DEFAULT: always set it to 0 0 0 before every game
        if (time / 100 > 0) {
            
        } else if (time / 10 > 0) {

        } else {

        }
    }

    public void configureDefaultImages() {
        // for each starting game
        for (int i = 0; i < images.length; i++) {
            // assign each image
        }
    }

    public JPanel exportTimer() {
        JPanel temp = new JPanel();
        return temp;
    }
}
