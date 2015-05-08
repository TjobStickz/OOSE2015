package example;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
//tGrid is the class that contains the image of grid, and the positions of all 14*28 grid positions.
public class tGrid{
	
//	Initial draw area.
	int posX;
	int posY;
	
//	14 x rows, 28 y rows, creating a 14*28 grid.
	public int[] xRow = new int[14];
	public int[] yRow = new int[28];
	
//	Storing Image gridImg.
	public Image gridImg;
	
	tGrid() throws SlickException{
			
		posX = -16;
		posY = -52;
		
//		Initialize grid at posX, posY . for every 18 pix draw a new square of the grid.
		for(int i = 0; i < xRow.length; i++ )
			xRow[i] = posX + (i*18);
		for(int i = 0; i < yRow.length; i++ )
			yRow[i] = posY + (i*18);
		
//		Grids image ("every square" of the grid beeing 18x18 pix").
		gridImg = new Image("src/data/BlackTest.png");
		
	}

}
