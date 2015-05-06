package example;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SimpleSlickGame extends BasicGame
{
	tGrid grid;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException 
	{
		grid = new tGrid();
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException 
	{
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		for(int i = 4; i < grid.yRow.length - 1; i++){
			for(int j = i; j < grid.xRow.length - 1; j++){
				grid.gridImg.draw(grid.xRow[j], grid.yRow[i]);
			}
		}
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			
			appgc = new AppGameContainer(new SimpleSlickGame("Tetris"));
			appgc.setShowFPS(false);
			appgc.setTargetFrameRate(1000);
			appgc.setDisplayMode(540, 720, false);		
			appgc.start();
			
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
