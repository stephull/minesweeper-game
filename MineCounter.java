/* 
    MineCounter.java
    Create object for number of flags/mines present in the game.
*/

import javax.swing.*;

public class MineCounter {
    
    public int flags;
    public ImageIcon[] images;
    
    MineCounter() {
        // default
    }

    MineCounter(int count) {
        flags = count;
        images = new ImageIcon[3];

        JButton button = new JButton();
        button.setText("Counter Test");
    }

    public void changeCount() {

    }

    public void configureDefaultImages() {
        for (int i = 0; i < images.length; i++) {
            // assign each image
        }
    }

    public JPanel exportCounter() {
        JPanel temp = new JPanel();
        return temp;
    }
}
