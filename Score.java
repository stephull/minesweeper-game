/*
 *  Score.java
 *  Functionalities mainly consist of the number of flags that is
 *  available to the user, as well as the timer and the smiley face
 *  (for reset or restart of game). 
 */

import java.util.*;
import java.io.*;

import javax.management.timer.Timer;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends Window {
	
	Timer timer;
	static final int MAX_TIME = 1000;
	int running_time = 0;
	
	Score() {

	}

	// functionalities for the timer
	public void game_timer() {
		timer = new Timer();
		timer.start();
		if (!active) {
			timer.stop();
		}
	}
	
	// functionalities for number of flags used
	public void flags() {
		
	}
	
	// functionalities for the reset/restart button (smiley face)
	public void score_face() {
		
	}
}
