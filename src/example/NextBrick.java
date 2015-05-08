package example;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class NextBrick{
	
	int x,y;
	int caseNum;
	
	public Image Draw;
	
	public Image nB1;
	public Image nB2;
	public Image nB3;
	public Image nB4;
	public Image nB5;
	public Image nB6;
	public Image nB7;
	
	NextBrick() throws SlickException{
		
		nB1 = new Image ("src/data/LongD.png");
		nB2 = new Image ("src/data/6.png");
		nB3 = new Image ("src/data/9.png");
		nB4 = new Image ("src/data/Threesome.png");
		nB5 = new Image ("src/data/Boob.png");
		nB6 = new Image ("src/data/ReverseDoggy.png");
		nB7 = new Image ("src/data/Doggy.png");
		
		Draw = nB1;
				
	}
	
	public void check(){
		
		switch(caseNum){
		case 1: Draw = nB1;
		break;
		case 2: Draw = nB2;
		break;
		case 3: Draw = nB3;
		break;
		case 4: Draw = nB4;
		break;
		case 5: Draw = nB5;
		break;
		case 6: Draw = nB6;
		break;
		case 7: Draw = nB7;
		break;
		}
	}
}
