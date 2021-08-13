/*
    ControlPanel.java
    
*/

import java.awt.*;
import javax.swing.*;
//import java.awt.event.*;
import javax.swing.border.*;

public class ControlPanel extends Configurations {

    // enumerate and define each analog image for the time and counter
    protected final String ZERO = "Images/0analog.png";
    protected final String ONE = "Images/1analog.png";
    protected final String TWO = "Images/2analog.png";
    protected final String THREE = "Images/3analog.png";
    protected final String FOUR = "Images/4analog.png";
    protected final String FIVE = "Images/5analog.png";
    protected final String SIX = "Images/6analog.png";
    protected final String SEVEN = "Images/7analog.png";
    protected final String EIGHT = "Images/8analog.png";
    protected final String NINE = "Images/9analog.png";

    // components for the control panel in game window
    private JPanel controlpanel;

    ControlPanel() {
        // default
    }

    ControlPanel(JPanel base, int mines) {
        base = new JPanel();
        cpBase = base;

        // create new control panel for all control items below
        controlpanel = new JPanel();
        controlpanel.setLayout(new GridLayout(8, 1, 0, 2));
        base.setPreferredSize(new Dimension(240, 360));
        base.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 0));
        base.setBorder(new LineBorder(Color.BLACK, 2));

        // configure items for control panel above game board 
        controlpanel.add(mc.export());
        controlpanel.add(ms.export());
        controlpanel.add(mt.export());
        base.add(controlpanel);
    }

    public JPanel getBase() {
        return cpBase;
    }

    protected String getAnalog(int input) {
        switch(input) {
            case 1: return ONE;
            case 2: return TWO;
            case 3: return THREE;
            case 4: return FOUR;
            case 5: return FIVE;
            case 6: return SIX;
            case 7: return SEVEN;
            case 8: return EIGHT;
            case 9: return NINE;
            case 0: default: return ZERO;
        }
    }

    // for analog numbers, timer and counter only
    protected void configureAnalogImages(String text, int step, ImageIcon[] images, JPanel panel) {
        // for each starting game, TIMER
        for (int i = step; i < images.length; i++) {
            images[i] = new ImageIcon(getClass().getResource(text));
            images[i] = new ImageIcon(images[i].getImage().getScaledInstance(30, 45, Image.SCALE_SMOOTH));
                // new ImageIcon( ** property of Image object put back into ImageIcon ** )
            panel.add(addImageLabel(images[i]));
        }
    }   public void configureAnalogImages(String[] text, int step, ImageIcon[] images, JPanel panel) {
        // ditto, COUNTER (depends on mode)...
        for (int i = step; i < images.length; i++) {
            images[i] = new ImageIcon(getClass().getResource(text[i]));
            images[i] = new ImageIcon(images[i].getImage().getScaledInstance(30, 45, Image.SCALE_SMOOTH));
            panel.add(addImageLabel(images[i]));
        }
    }

    protected JLabel addImageLabel(ImageIcon image) {
        return new JLabel(image);
    }

    protected void changeAnalogOutput(int numericInput, ImageIcon[] images, JPanel panel) {
        // change images accordingly by its time using 0-9 analog png's 

        // FOR TIMER: always set it to 0 0 0 before every game
        // FOR COUNTER: arbitrary numbers, set according to mine count
        int temp = numericInput;
        if (temp / 100 > 0) {
            configureAnalogImages(getAnalog(temp / 100), 0, images, panel);
            temp %= 100;
        } 
        if (temp / 10 > 0) {
            configureAnalogImages(getAnalog(temp / 10), 1, images, panel);
            temp %= 10;
        }
        if (temp < 10 && temp > 0) {
            // not equal to 0, since the default time always starts at 0
            configureAnalogImages(getAnalog(temp), 2, images, panel);
            temp = 0;
        }
    }
}
