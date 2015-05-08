package example;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class brick extends tGrid {
	
//	sQ stores the currentBricks Image (color of currentBrick).
	public Image sQ;
	
//	sQ1 to sQ7 contains all different brick colors purpose for drawing them once stored in storage array in main.
	public Image sQ1;
	public Image sQ2;
	public Image sQ3;
	public Image sQ4;
	public Image sQ5;
	public Image sQ6;
	public Image sQ7;
	
//	Variables for brick.
	int posX = 2;
	int posY = 2;
	int caseNum;
	int rotate;
	
//	2D array storing X position in first column, Y position in second column.
	int[][] brick; // [x][y] positions
	
//	brick class constructor.
	brick(int posX, int posY, int caseNum, int rotate) throws SlickException{
		
//		Initializing variables for brick class.
		this.rotate = rotate;
		this.posX = posX;
		this.posY = posY;
		this.caseNum = caseNum;
		sQ1 = new Image ("src/data/LongDmini.png");
		sQ2 = new Image ("src/data/6mini.png");
		sQ3 = new Image ("src/data/9mini.png");
		sQ4 = new Image ("src/data/ThreesomeMini.png");
		sQ5 = new Image ("src/data/Mini_Boob3.png");
		sQ6 = new Image ("src/data/ReverseDoggyMini.png");
		sQ7 = new Image ("src/data/DoggyMini.png");
		
//		Switch case system for brick types, 1 for each brickType.
//		Each brick consists of 4 positions, 1 standard position and 3 other positions shaping the bricks.
		switch(this.caseNum){
		
//		Long piece.
		case 1:
			brick = new int[][]{{this.posX,this.posY-2},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX,this.posY+1}};
			sQ = new Image ("src/data/LongDmini.png");
		break;
		
//		L piece "left".
		case 2: 
			brick = new int[][]{{this.posX,this.posY-2},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX+1,this.posY}};
			sQ = new Image ("src/data/6mini.png");
		break;
		
//		L piece "right".
		case 3:
			brick = new int[][]{{this.posX,this.posY-2},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX-1,this.posY}};
			sQ = new Image ("src/data/9mini.png");
		break;
		
//		T piece.
		case 4:
			brick = new int[][]{{this.posX,this.posY-1},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX+1,this.posY}};
			sQ = new Image ("src/data/ThreesomeMini.png");
		break;
		
//		Square piece.
		case 5:
			brick = new int[][]{{this.posX-1,this.posY-1},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX,this.posY-1}};
			sQ = new Image ("src/data/Mini_Boob3.png");
		break;
		
//		S piece.
		case 6:
			brick = new int[][]{{this.posX-1,this.posY},{this.posX+1,this.posY-1},{this.posX,this.posY},{this.posX,this.posY-1}};
			sQ = new Image ("src/data/ReverseDoggyMini.png");
		break;
		
//		Z piece.
		case 7:
			brick = new int[][]{{this.posX-1,this.posY-1},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX+1,this.posY}};
			sQ = new Image ("src/data/DoggyMini.png");
		break;
		}
	}
	
//	Void update that constantly updates the position of brick. Is called within Void update in main class
	public void update(){
		
//		This switch case swaps through the different bricks
//		And the switch cases under this swaps through the positions of the different rotations available for each brick
		switch(this.caseNum){
//		Long piece.
		case 1:
			switch(rotate){
			case 1: brick = new int[][]{{this.posX,this.posY-2},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX,this.posY+1}};
			break;
			case 2: brick = new int[][]{{this.posX-2,this.posY},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX+1,this.posY}};
			break;
			case 3: brick = new int[][]{{this.posX,this.posY-2},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX,this.posY+1}};
			break;
			case 4: brick = new int[][]{{this.posX-2,this.posY},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX+1,this.posY}};
			break;
			}
		break;
		
//		L piece "left".
		case 2:
			switch(rotate){
			case 1: brick = new int[][]{{this.posX,this.posY-2},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX-1,this.posY}};
			break;
			case 2: brick = new int[][]{{this.posX,this.posY-1},{this.posX+1,this.posY},{this.posX,this.posY},{this.posX+2,this.posY}};
			break;
			case 3: brick = new int[][]{{this.posX,this.posY+2},{this.posX,this.posY+1},{this.posX,this.posY},{this.posX+1,this.posY}};
			break;
			case 4: brick = new int[][]{{this.posX-1,this.posY},{this.posX,this.posY+1},{this.posX,this.posY},{this.posX-2,this.posY}};
			break;
			}
		break;
		
//		L piece "right".
		case 3:
			switch(rotate){
			case 1: brick = new int[][]{{this.posX,this.posY-2},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX+1,this.posY}};
			break;
			case 2: brick = new int[][]{{this.posX,this.posY+1},{this.posX+1,this.posY},{this.posX,this.posY},{this.posX+2,this.posY}};
			break;
			case 3: brick = new int[][]{{this.posX,this.posY+2},{this.posX,this.posY+1},{this.posX,this.posY},{this.posX-1,this.posY}};
			break;
			case 4: brick = new int[][]{{this.posX-1,this.posY},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX-2,this.posY}};
			break;
			}
		break;
		
//		T piece.
		case 4:
			switch(rotate){
			case 1: brick = new int[][]{{this.posX,this.posY-1},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX+1,this.posY}};
			break;
			case 2: brick = new int[][]{{this.posX,this.posY-1},{this.posX,this.posY+1},{this.posX,this.posY},{this.posX+1,this.posY}};
			break;
			case 3: brick = new int[][]{{this.posX,this.posY+1},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX+1,this.posY}};
			break;
			case 4: brick = new int[][]{{this.posX,this.posY-1},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX,this.posY+1}};
			break;
			}
		break;
		
//		Square piece.
		case 5:
			switch(rotate){
			case 1: brick = new int[][]{{this.posX-1,this.posY-1},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX,this.posY-1}};
			break;
			case 2: brick = new int[][]{{this.posX-1,this.posY-1},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX,this.posY-1}};
			break;
			case 3: brick = new int[][]{{this.posX-1,this.posY-1},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX,this.posY-1}};
			break;
			case 4: brick = new int[][]{{this.posX-1,this.posY-1},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX,this.posY-1}};
			break;
			}
		break;
		
//		S piece.
		case 6:
			switch(rotate){
			case 1: brick = new int[][]{{this.posX-1,this.posY},{this.posX+1,this.posY-1},{this.posX,this.posY},{this.posX,this.posY-1}};
			break;
			case 2: brick = new int[][]{{this.posX-1,this.posY},{this.posX-1,this.posY-1},{this.posX,this.posY},{this.posX,this.posY+1}};
			break;
			case 3: brick = new int[][]{{this.posX-1,this.posY},{this.posX+1,this.posY-1},{this.posX,this.posY},{this.posX,this.posY-1}};
			break;
			case 4: brick = new int[][]{{this.posX-1,this.posY},{this.posX-1,this.posY-1},{this.posX,this.posY},{this.posX,this.posY+1}};
			break;
			}
		break;
		
//		Z piece.
		case 7:
			switch(rotate){
			case 1: brick = new int[][]{{this.posX-1,this.posY-1},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX+1,this.posY}};
			break;
			case 2: brick = new int[][]{{this.posX-1,this.posY+1},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX,this.posY-1}};
			break;
			case 3: brick = new int[][]{{this.posX-1,this.posY-1},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX+1,this.posY}};
			break;
			case 4: brick = new int[][]{{this.posX-1,this.posY+1},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX,this.posY-1}};
			break;
			}
		break;
		}
	}
}
