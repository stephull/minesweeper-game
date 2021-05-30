/*
 * Board.java
 * Class for the board, including mines and ability to click
 * on each board-piece, randomization of bomb locations. 
 */

import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends Window {
	
	/*
	 *  ::: HOW IT WORKS :::
	 *  EASY: 9x9, 10 mines (0.1234...)
	 *  MEDIUM: 16x16, 40 mines (0.15625)
	 *  HARD: 16x30, 99 mines (0.20625)
	 *  EXPERT: 30x30, 216 mines (0.24)
	 *  & CRAZY: 60x60, 999 mines (<= 0.2775)
	 */ 
	
	// different dimensions for window, assumes hardest setting of game
	static final int[] widths = {9, 16, 30, 30, 60};
	static final int[] heights = {9, 16, 16, 30, 60};
	
	// number of mines based on difficulty, also counts for number of flags used
	static final int[] bombs = {10, 40, 99, 216, 999};
	
	static final int mult = 10;
	
	// assign index value based on user's choice of difficulty:
	int userLevel;
	
	Board() {
		userLevel = 1;
		random = new Random();
	}
	
	
}
