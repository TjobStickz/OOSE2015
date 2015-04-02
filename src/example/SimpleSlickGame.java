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
	public int time;
	private Image longD = null;
	@SuppressWarnings("unused")
	private Image sex = null;
	@SuppressWarnings("unused")
	private Image nine = null;
	@SuppressWarnings("unused")
	private Image doggy = null;
	@SuppressWarnings("unused")
	private Image reverseDoggy = null;
	@SuppressWarnings("unused")
	private Image boob = null;
	@SuppressWarnings("unused")
	private Image threesome = null;
	@SuppressWarnings("unused")
	private Image miniBoob = null;
	
	public float PosX = 200f;
	public float PosY = 50f;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		
		
		
		longD = new Image("data/LongD.png");
		sex = new Image("data/6.png");
		nine = new Image("data/9.png");
		doggy = new Image("data/Doggy.png");
		reverseDoggy = new Image("data/ReverseDoggy.png");
		boob = new Image("data/boob.png");
		threesome = new Image("data/Threesome.png");
		miniBoob = new Image("data/Mini_Boob.png");
		
		longD.rotate(90);
		
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
		time += delta;
		PosY += 0.2f;
		
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.drawString("Time : " + time/1000, 0, 0);
		longD.draw(PosX,PosY, 1.5f);
	}

	public static void main(String[] args)
	{
		try
		{
			
			AppGameContainer appgc;
			
			appgc = new AppGameContainer(new SimpleSlickGame("Tetris"));
			appgc.setShowFPS(false);
			appgc.setTargetFrameRate(60);
			appgc.setDisplayMode(540, 720, false);		
			appgc.start();
			
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
