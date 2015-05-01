package example;

<<<<<<< HEAD
import org.newdawn.slick.Image;

=======
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
>>>>>>> branch 'master' of https://github.com/TjobStickz/OOSE2015.git

public class Grid {
	
	int x,y;
	
<<<<<<< HEAD
	Grid(int posX, int posY, Image gridColor){
=======
	Image grid = null;
	
	public Grid(GameContainer container, int posX, int posY){
>>>>>>> branch 'master' of https://github.com/TjobStickz/OOSE2015.git
		
		this.x = posX;
		this.y = posY;
		
		
	}
	
	public void render(Graphics g) throws SlickException{
		
		grid = new Image("date/Mini_Boob");
		
		for(int i = 0; i < 22; i++){
			for(int j = 0; j < 10; j++){
				grid.draw(x +(grid.getWidth()*j),y + (grid.getWidth()*i));
			}
		}
		
		g.drawImage(this.grid,0,0);
	}

}
