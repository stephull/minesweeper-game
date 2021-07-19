/*
    Gameplay.java

*/

//import java.io.*;
//import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gameplay extends Window {

    public Gameplay() {
        // default constructor
    }

    // main gameplay function
    public Gameplay(JPanel panel) {
        

        // while the game is running...
        /*while (true) {

        }*/
    }       

    // NOTE: all methods here are to be executed in real time while gameplay is initiated
    
    public void randomizeMines() {
        // start of game: randomize mine placement using number generation
        // NOTE: originally thinking of placing new board, skip that!
    }

    public void clearMines() {
        // if one clicks on a clear tile, clear out respective spaces
    }

    public void configureNums() {
        // how many mines are nearby? 1 to 7
    }

    public void showMines() {
        // show mines when game is done, and show marked incorrect mines too
    }
}
