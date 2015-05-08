# Slick2D Eclipse Tetris Projekt
This an eclipse project containing files and code creating a simpleTetris game

The Game contains a Main class which controlls most parts of the game.
Other then that there are 3 different classes, tGrid, Bricks and NextBrick.

tGrid is the class which controlls the position of every brick within the game.
Brick is the class contains all the possible Bricks, and each rotation of each brick.
NextBrick is a class which contains an Image of the next brick which is in line.

In the main class there are several methods which checks if a brick is hitting otherbricks or moving out of the grid.
There is a method which checks if a line is full, and then clears the lines adding you score and such.

Another important thing within the game is the storage array. Its an 2D array made to store what colors the placed bricks have, and at what position a brick is placed within.
Storage is essenctial for removing lines, placing the bricks after they hit buttom or other bricks, and checking if you lost the game

When the game is lost you can press enter to clear all the lines reset scores, and start over with the game

Starting and playing the game !!!

After clicking the "Tetris Game OOSE.jar" or running the code you will start the game right away.

Controlls is either WASD or Arrow keys. A/D or LEFT / RIGHT controlls the bricks movement left and right.
W / UP, will rotate the brick clockwise always. The S/DOWN key is used to speed up the falling process of the brick.

You place the bricks to fill out a compleat vertical line, if a line is filled out you are awarded aditional points to your score, and the line will be removed thus you have more area to place your bricks.
If the bricks are stacked all the way to the top you lose the game, and thus can press enter to restart the game.

Enjoy the relaxing sensation of our Tetris game !!!
