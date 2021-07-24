import java.awt.*;
import javax.swing.*;

public class ControlPanel extends Configurations {

    // enumerate and define each analog image for the time and counter
    public static final String ZERO = "Images/0analog.png";
    public static final String ONE = "Images/1analog.png";
    public static final String TWO = "Images/2analog.png";
    public static final String THREE = "Images/3analog.png";
    public static final String FOUR = "Images/4analog.png";
    public static final String FIVE = "Images/5analog.png";
    public static final String SIX = "Images/6analog.png";
    public static final String SEVEN = "Images/7analog.png";
    public static final String EIGHT = "Images/8analog.png";
    public static final String NINE = "Images/9analog.png";

    // components for the control panel in game window
    public JPanel controlpanel;

    // other variables
    int time;

    public ControlPanel() {
        // default
    }

    public ControlPanel(JPanel base, GridBagConstraints c, int mines) {
        controlpanel = new JPanel();
        time = 0;

        // configure items for control panel above game board
        createCounter(controlpanel, mines);
        configureSmiley(controlpanel);
        createTimer(controlpanel);
        base.add(controlpanel);
    }

    // get new constructor

    public String getAnalog(int input) {
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
            default: return ZERO;
        }
    }

    public void configureImages(String text, int step, ImageIcon[] images, JPanel panel) {
        // for each starting game, TIMER
        for (int i = step; i < images.length; i++) {
            images[i] = new ImageIcon(getClass().getResource(text));
            images[i] = new ImageIcon(images[i].getImage().getScaledInstance(30, 45, Image.SCALE_SMOOTH));
                // new ImageIcon( ** property of Image object put back into ImageIcon ** )
            panel.add(new JLabel(images[i]));
        }
    }   public void configureImages(String[] text, int step, ImageIcon[] images, JPanel panel) {
        // ditto, COUNTER (depends on mode)...
        for (int i = step; i < images.length; i++) {
            images[i] = new ImageIcon(getClass().getResource(text[i]));
            images[i] = new ImageIcon(images[i].getImage().getScaledInstance(30, 45, Image.SCALE_SMOOTH));
            panel.add(new JLabel(images[i]));
        }
    }

    public void changeAnalogOutput(int numericInput, ImageIcon[] images, JPanel panel) {
        // change images accordingly by its time using 0-9 analog png's 

        // FOR TIMER: always set it to 0 0 0 before every game
        // FOR COUNTER: arbitrary numbers, set according to mine count
        int temp = numericInput;
        if (temp / 100 > 0) {
            configureImages(getAnalog(temp / 100), 0, images, panel);
            temp %= 100;
        } 
        if (temp / 10 > 0) {
            configureImages(getAnalog(temp / 10), 1, images, panel);
            temp %= 10;
        }
        if (temp > 0) {
            configureImages(getAnalog(temp), 2, images, panel);
            temp = 0;
        }
    }

    // creation of control panel items
    public void createTimer(JPanel panel) {
        // create timer
        MineTimer timer = new MineTimer(time);
        panel.add(timer.exportTimer());
    }

    public void configureSmiley(JPanel panel) {
        // ??? create or settings for smiley thing
        MineSmiley smiley = new MineSmiley();
        panel.add(smiley.exportSmiley());
    }

    public void createCounter(JPanel panel, int count) {
        // create counter for number of flags
        MineCounter counter = new MineCounter(count);
        panel.add(counter.exportCounter());
    }
    
}
