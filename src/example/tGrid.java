package example;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class tGrid {
	
	int posX;
	int posY;
	
	public int[] xRow = new int [12];
	public int[] yRow = new int [27];
	
	public Image gridImg;
	
	tGrid() throws SlickException {
		
		posX = 150;
		posY = 230;
		
		for(int i = 0; i < xRow.length; i++)
			xRow[i] = posX + (i*18);
		
		for(int i = 0; i < yRow.length; i++)
			yRow[i] = posY + (i*18);
		
		gridImg = new Image("data/BlackTest.png");
		
	}

}
