/*
 * Boardpiece.java
 *  Extends actions from board, focusing on each individual square in the main board
 *  area. 
 */

import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Boardpiece extends Board {
	Boardpiece() {
		
		ImageIcon empty_tile_img = new ImageIcon("EmptyTile-01.png");
		Image emptyTile = empty_tile_img.getImage();

		ImageIcon full_tile_img = new ImageIcon("Tile01-png");
		Image tile = full_tile_img.getImage();

	}
}
