package example;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class brick extends tGrid {
	
//	Create images and assign names.
	public Image sQ;
	public Image sQ1;
	public Image sQ2;
	public Image sQ3;
	public Image sQ4;
	public Image sQ5;
	public Image sQ6;
	public Image sQ7;
	
//	Variables for position, case number, and rotate.
	int posX = 2;
	int posY = 2;
	int caseNum;
	int rotate = 1;
	
	int[][] brick;
	
	brick(int posX, int posY, int caseNum) throws SlickException{
			
		this.posX = posX;
		this.posY = posY;
		this.caseNum = caseNum;
		
//		Assign images to variables.
		sQ1 = new Image ("data/LongDmini.png");
		sQ2 = new Image ("data/6mini.png");
		sQ3 = new Image ("data/9mini.png");
		sQ4 = new Image ("data/ThreesomeMini.png");
		sQ5 = new Image ("data/Mini_Boob3.png");
		sQ6 = new Image ("data/ReverseDoggyMini.png");
		sQ7 = new Image ("data/DoggyMini.png");
		
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
	public void update(){
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
		}
	}
}
