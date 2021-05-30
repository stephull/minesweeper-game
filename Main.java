/*
 *  Main.java
 *  Main method, responsible for window properties & operations 
 *  (e.g. title, resize, visibility, closing).
 */

import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
	
	private Main() {
		// call contents of window into the main framework/window
		this.add(new Window());
		this.setTitle("Minesweeper Game");
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		// test text
		// JLabel label = new JLabel("Hello world!!!");
		// label.setFont(label.getFont().deriveFont(24.0f));
		// this.add(label);
		
		// exit the application by closing with the 'X' button or System.exit
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// unable to resize window
		this.setResizable(true);
		
		// sizes the contents appropriate to the size of the window
		this.pack();
		
		// set to visible
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
