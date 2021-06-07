/*
 *  Window.java
 *  Focuses on the main contents displayed when opening the game,
 *  such as the scoreboard, number of flags, the smiley face, 
 *  and the rectangular board containing the bombs. Also used to 
 *  create the background of the window. 
 */

import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JPanel implements ActionListener {
	
	// minimum window dimensions
	static final int MIN_SCREEN = 360;
	
	// JAVAX SWING components and other essential imported functions
	JPanel panel;
	JButton button;
	Random random;
	
	// boolean variable that defines if there is a current running game
	boolean active;
	
	public Window() {
		panel = new JPanel();
		this.setPreferredSize(new Dimension(MIN_SCREEN, MIN_SCREEN));
		this.setBackground(Color.LIGHT_GRAY);

		
		// TESTING FOR WINDOW
		JButton reset = new JButton("TEST");
		this.add(reset);

		// adding all images into ImageIcon, will work on this later...
		ImageIcon smile_face_img = new ImageIcon("SmileFace.png");
		Image smileFace = smile_face_img.getImage();

		ImageIcon shock_face_img = new ImageIcon("ShockFace.png");
		Image shockFace = shock_face_img.getImage();

		ImageIcon dead_face_img = new ImageIcon("DeathFace.png");
		Image deadFace = dead_face_img.getImage();

		ImageIcon victory_face_img = new ImageIcon("GoalFace.png");
		Image victoryFace = victory_face_img.getImage();
	}

	// once a player starts the game by clicking on a boardpiece
	public void currentlyPlaying() {
		active = true;
	}
	
	// action performed in the event of any input (e.g. button)
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
