# UPDATES.md

## July 8, 2021
* Restarted code, freshen up on JavaX SWING concepts.
* Added JFrame, JPanel, JMenuBar + items, and JButton for testing purposes. 

## July 9, 2021
* Added sample code for socket programming, including server and client files. 

## July 16, 2021
* Updated modularization for methods involving gameplay and controls for each game. 
* Added action listeners for menu items, menubar.
* Utilized border layout properties for improved window structure.
* Added panel board for buttons, and included icons for each block.

## July 19, 2021
* Utilized GridBagLayout for layout, using GridBagConstraints to describe layout properties.
* Defined properties for board panel. 
* Added an option item called 'Feedback' for future opinions/suggestions. Included a mouse listener for external hyperlink. 
* Created a timestamp for each time a test run occurs. 
* Adding action listeners for board panel (NOTE: CURRENTLY TRYING TO FIX ALL BUTTON LISTENERS). 
* Declared new files for individual timer and counter objects for control panel. 

## July 20, 2021
* Updating layout for proper inheritance. Allocating existing functions into different files; mostly determined by which functions are important while in-game. 
* Declared new file for one more object in the control panel.

## July 22, 2021
* Added pseudocode for board and control item functionalities. 
* Added enum values for images to match the numeric values of time and mine count in controls. 
* Renamed images to match appropriate function names. 
* Created function to correspond numeric input conversion with matching analog number images. 
* Working on hyperlink, began operating on windows for options menu. 

## July 24, 2021
* Changed action listener interface for Window.java and children classes.
* Added all information and semantics for menu options and help. 
* Added HashSet-ArrayList for generating randomized coordinates for mines.
* Changed configurations by separating configurations for game into one file, control panel variables and methods in another; both can be seen in Configurations.java and ControlPanel.java. Control.java deleted. 
* Moved Main.java to main arguments method in Window.java; Window.java is now the main file, Main.java deleted. 
* Changed privacy for most variables and functions from public to protected or private to restrict access from certain classes.  