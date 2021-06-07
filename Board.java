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
	 	/*
			1. if user picks easy, get sizes index 0 0
			2. medium, index 1 1
			3. hard, 1 2
			4. expert, 2 2
			5. & crazy, 3 3
		*/
	
	// different dimensions for window, assumes hardest setting of game
	static final int[] sizes = {9, 16, 30, 60};
	
	// number of mines based on difficulty, also counts for number of flags used
	static final int[] bombs = {10, 40, 99, 216, 999};
	
	Board() {
		int userLevel = 1;
		int mines = bombs[0];
		random = new Random();

		int[][] tiles = pickDiff(mines, userLevel);
	}
	
	public int[][] pickDiff(int mines, int ul) {
		int h, w;
		switch (ul) {
			default:
			case 1:
			case 2:
				h = w = sizes[(ul-1)];
			case 3:
				h = sizes[1];
				w = sizes[2];
			case 4:
			case 5:
				h = w = sizes[(ul-2)];
		}
		mines = bombs[(ul-1)];
		return new int[h][w];
	}
}
