# Slick2D Eclipse Tetris Project
This an eclipse project containing files and code to creating a simple Tetris game.

The game contains a Main class which controls most parts of the game.
Other then that there are 3 different classes: tGrid, Bricks, and NextBrick.

tGrid is the class which controls the position of every brick within the game.
Brick is the class containing all the possible Bricks, and the rotation of each brick.
NextBrick is a class which contains an Image of the next brick which is to spawn.

In the main class there are several methods that check if a brick is hitting any other bricks or moving out of the grid.
There is a method that checks if a line is full and then clears the lines and adds to the score.

Another important aspect within the game is the storage array. It is an 2D array made to store the colors that the placed bricks have, and at what position a brick is placed within.
Storage is essential for removing lines, placing the bricks after they hit buttom or other bricks, and checking if you lost the game.

When the game is lost you can press enter to clear all the lines and reset score, thus starting the game over.

Starting and playing the game:

After clicking the "Tetris Game OOSE.jar" or running the code you will start the game right away.

The game is controlled either with WASD or Arrow keys. A/D or LEFT/RIGHT controls the bricks' movement left and right.
W/UP will rotate the brick clockwise. The S/DOWN key is used to speed up the falling of the brick.

You place the bricks to fill out a complete horizontal line, and if a line is filled out you are awarded additional points to your score. Once a line is full it will be removed, and all bricks on top will move down, thus creating more space.
If the bricks are stacked all the way to the top and you can't move a newly spawned piece anywhere, you will lose the game. Press enter to restart the game.

Enjoy our Tetris game!
