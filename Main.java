import javax.swing.*;

public class Main {
    // main method
    private static JFrame frame;
    private static JPanel panel; 
    public static void main(String[] args) {
        frame = new JFrame();
        panel = new JPanel();
        new Window(frame, panel);
    }
}