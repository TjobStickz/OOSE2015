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
	
	public int time;
	public int fallSpeed;
	public int rotate = 0;
	public boolean rotateCheck = false;

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
	@SuppressWarnings("unused")
	private Image[] miniArr = new Image[4];
	
	
	
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
		miniBoob = new Image("data/Mini_Boob2.png");
		
		for(int i = 0; i < miniArr.length; i++){
			
			miniArr[i] = new Image("data/Mini_Boob2.png");
			
		}
		
		
		
		
		
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
		time += delta;
		fallSpeed += delta;
		
		float w = (1.5f) * (longD.getWidth());
		
	
		Input input = gc.getInput();
		
		if(fallSpeed/1000 == 1){
			
			
			PosY += w;
			fallSpeed = 0;
		}
		
		if(input.isKeyPressed(Input.KEY_A)){

			PosX -= w;
				
		}
		if(input.isKeyPressed(Input.KEY_D)){

			PosX += w;
				
		}
		if(input.isKeyDown(Input.KEY_W)){
			
			if(rotate < 50){
				if(rotateCheck = false)
					rotate += 90;
				rotateCheck = true;
			} else if (rotate > 50){
				if(rotateCheck = false)
					rotate -= 90;
				rotateCheck = true;
			}
			longD.rotate(rotate);
		}
		
		
		
		
		
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		
		float w = (1.5f)*(miniBoob.getHeight());
		
		g.drawString("Time : " + time/1000, 0, 0);
		g.drawString("Rotation : " + rotate, 0, 20);
		longD.draw(PosX,PosY, 1.5f);
		
		for(int i = 0; i < miniArr.length; i++){
		miniArr[i].draw(PosX + 20 + (w*i), PosY, 1.5f);
		
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
