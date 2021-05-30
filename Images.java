/*
 * Images.java
 * Class for all pictures or shapes constructed for visual purposes.
 * Examples: smiley face, flag, numbers (hints), bomb, etc. 
 */

import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Images extends Window {

	public void painComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		if (active) {
			;
		}
	}
	
}
