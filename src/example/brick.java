package example;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class brick {
	
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
		
		switch(this.caseNum){
		case 1: // Long Piece
			brick = new int[][]{{this.posX,this.posY-2},{this.posX,this.posY-1},{this.posX,this.posY},{this.posX,this.posY+1}};
			sQ = new Image ("data/LongDmini.png");
		break;
		}
	}
}
