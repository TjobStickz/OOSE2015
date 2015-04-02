package example;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class SimpleSlickGame extends BasicGame
{
	
	private Image longD = null;
	public float PosX = 320f;
	public float PosY = 50f;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		longD = new Image("data/LongD.png");
		longD.rotate(90);
		
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
		PosY += 0.2f;
		
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		longD.draw(PosX,PosY, 1.5f);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;

			appgc = new AppGameContainer(new SimpleSlickGame("Tetris"));
			appgc.setDisplayMode(640, 481, false);

			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
