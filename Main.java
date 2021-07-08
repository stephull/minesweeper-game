import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // create frame
        JFrame frame = new JFrame("Minesweeper");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create button
        JButton button = new JButton("test button");
        frame.add(button);
    }
}