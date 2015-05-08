package example;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class NextBrick{
	
//	Position and caseNum.
	int x,y;
	int caseNum;
	
//	Variable to draw the loaded images.
	public Image Draw;
	
//	Image variables named.
	public Image nB1;
	public Image nB2;
	public Image nB3;
	public Image nB4;
	public Image nB5;
	public Image nB6;
	public Image nB7;
	
	NextBrick() throws SlickException{
		
		nB1 = new Image ("data/LongD.png");
		nB2 = new Image ("data/6.png");
		nB3 = new Image ("data/9.png");
		nB4 = new Image ("data/Threesome.png");
		nB5 = new Image ("data/Boob.png");
		nB6 = new Image ("data/ReverseDoggy.png");
		nB7 = new Image ("data/Doggy.png");
		
		Draw = nB1;
				
	}
	
//	Void check is called within the mainclasses void update, so it constantly checks for the caseNumbers and swtiches to the right number
	public void check(){
		
//		Switch-case that draws each of the images.
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
