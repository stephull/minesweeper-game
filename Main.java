/*
    Main.java
    Declare JFrame and JPanel, main method for execution. 
*/

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.time.format.*;

public class Main {
    // main method
    private static JFrame frame;
    private static JPanel panel; 
    
    public static void main(String[] args) {
        // always print message before running program with timestamp...
        System.out.println(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now()));
        System.out.println("Beginning Minesweeper...");

        // start
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