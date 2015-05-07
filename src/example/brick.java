package example;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class brick extends tGrid {
	
	// sQ stores the currentBricks Image (color of currentBrick)
	public Image sQ;
	
	// sQ1 - sQ7 contains all different brick colors purpos for drawing them once stored in storage array in main.
	public Image sQ1;
	public Image sQ2;
	public Image sQ3;
	public Image sQ4;
	public Image sQ5;
	public Image sQ6;
	public Image sQ7;
	
	// variables for brick
	int posX = 2;
	int posY = 2;
	int caseNum;
	int rotate;
	
	// 2D array storing X pos in first colum, Ypos in second colum 
	int[][] brick; // [x][y] positions
	
	
	
	
	//brick class constructor
	brick(int posX, int posY, int caseNum, int rotate) throws SlickException{
		
		// initializing variables for brick class
		this.rotate = rotate;
		this.posX = posX;
		this.posY = posY;
		this.caseNum = caseNum;
		sQ1 = new Image ("data/LongDmini.png");
		sQ2 = new Image ("data/6mini.png");
		sQ3 = new Image ("data/9mini.png");
		sQ4 = new Image ("data/ThreesomeMini.png");
		sQ5 = new Image ("data/Mini_Boob3.png");
		sQ6 = new Image ("data/ReverseDoggyMini.png");
		sQ7 = new Image ("data/DoggyMini.png");
		
		// switch case system for brick types, 1 for each brickType
		// Each brick consists of 4 positions, 1 standard position and 3 other positions shaping the bricks
		switch(this.caseNum){
		case 1: // Long Piece
			brick = new int[][]{{this.posX,this.posY-2},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX,this.posY+1}};
			sQ = new Image ("data/LongDmini.png");
		break;
		case 2: // L Piece "left"
			brick = new int[][]{{this.posX,this.posY-2},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX+1,this.posY}};
			sQ = new Image ("data/6mini.png");
		break;
		case 3: // L Piece "right"
			brick = new int[][]{{this.posX,this.posY-2},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX-1,this.posY}};
			sQ = new Image ("data/9mini.png");
		break;
		case 4: // T Piece
			brick = new int[][]{{this.posX,this.posY-1},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX+1,this.posY}};
			sQ = new Image ("data/ThreesomeMini.png");
		break;
		case 5: // Square Piece
			brick = new int[][]{{this.posX-1,this.posY-1},{this.posX-1,this.posY},{this.posX,this.posY},{this.posX,this.posY-1}};
			sQ = new Image ("data/Mini_Boob3.png");
		break;
		case 6: // S Piece
			brick = new int[][]{{this.posX-1,this.posY},{this.posX+1,this.posY-1},{this.posX,this.posY},{this.posX,this.posY-1}};
			sQ = new Image ("data/ReverseDoggyMini.png");
		break;
		case 7: // Z Piece
			brick = new int[][]{{this.posX-1,this.posY-1},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX+1,this.posY}};
			sQ = new Image ("data/DoggyMini.png");
		break;
		}
	}
	// a upates that constantly updates what bricks positions is.
	public void update(){
		// 
		switch(this.caseNum){
		case 1: // Long Piece
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
		case 2: // L Piece "left"
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
		case 3: // L Piece "right"
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
		case 4: // T Piece
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
		case 5: // Square Piece
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
		case 6: // S Piece
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
		case 7: // Z Piece
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
