# minesweeper-game: A Java Minesweeper Project
Minesweeper game using Java and JavaX SWING, also to incorporate tools like MySQL, socket programming, Adobe Illustrator, etc.
Created in May 2021, personal project.

# Project Synposis:
* Minesweeper is a puzzle game, where the goal is to clear all the tiles on the grid and to flag whichever tiles supposedly contain the bombs. 

# General Gameplay:
* For this project, each player will have the option of picking any of the following difficulties: Easy, Intermediate, Challenging, Expert, and Crazy. These are different from conventional settings of Minesweeper used in other platforms; for instance, what is typically an 'Expert' game is considered 'Challenging' here. 

* The number of mines hidden in the grid are defined by the user's difficulty. There are an equal number of flags as there are mines. Right-clicking on each tile will place a flag, indicating that there may be a bomb present. Left-clicking on the grid will clear out the selected tile, under the condition that the player may lose when clicking on an undetected bomb. 
** NOTE: the first click will never be a mine. Mines are generated after the first click, just like everything else like the timer. 

* Each player has a timer set once they start the game by clicking their first square. The timer runs for 999 seconds. Any unfinished business is halted when the timer has reached its limit. 

* If a player dies or wants to reset the game, the player can choose to click on the face button, placed between the timer and the flag counter. During a game, the face button will be responsive by each click the player gives on the grid. 

* When a tile is clicked, assuming that the tile in question is safe, the surrounding area is cleared. There will be numbers that signify the number of bombs detected within its vicinity. It is the player's job to make sure that they can figure out where the bomb is. The outcome is solved either by narrowing down which tiles have been reclaimed within a certain perimeter of the detected bomb, and thereby pinpointing the location of the bomb, or making a guess (this is unavoidable in certain scenarios). 

# Additional Gameplay (Multiplayer):
* TBA, come back for more info.

# Goals and Vision of Project:
* The goal is to create a Minesweeper that is reminiscent of the original single-player game, while incorporating new libraries and
types of programming to engage multiple users in multiplayer mode games. The final product will, hopefully, tabulate all scores using a database, and incorporate socket programming to encourage clients, or players in this case, to play minigames together. 

# Timeline of Project:
* More information on RUNS.md

# Source Code, Tutorials, Documentation Used, and Credits:
* Inspired by a similar small project I made back in early January for a Java Snake game, using JavaX SWING. Link: https://www.youtube.com/watch?v=bI6e6qjJ8JQ (sadly, it was never truly finished). 

* All images were created by me via Adobe Illustrator. Vector images include facial expressions, flags, mines, board numbers (1-7), analog numbers (0-9), and tile (both undiscovered and cleared). 
