/*
    Main.java
    Declare JFrame and JPanel, main method for execution. 
*/

import javax.swing.*;
import java.awt.*;

public class Main {
    // main method
    private static JFrame frame;
    private static JPanel panel; 
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame = new JFrame();
                panel = new JPanel();
                new Window(frame, panel);
            }
        });
        /*
            Important: EventQueue.invokeLater()
            involves threading; changes in the 
            GUI will not affect the current 
            thread, but will operate after. 
            SOURCE: https://stackoverflow.com/questions/22534356/java-awt-eventqueue-invokelater-explained
        */
    }
}