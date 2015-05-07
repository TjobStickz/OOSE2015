package example;
import java.util.Random;
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
	
	int xCor = 7;
	int yCor = 5;
	int fallSpeed = 0;
	int caseType = randomInt(7);
	int ColorTrack;
	int rotation = 1;
	public boolean refresh = true;
	
	tGrid grid;
	brick Long;
	
	int[][] storage = new int[28][14];
	int[][] startBrick;
	int[][] nextBrick;
	int[][] currentBrick;
	int fullRow;
	int moveRow;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException 
	{
		for(int i = 0; i < 28; i++){
			for(int j = 0; j < 14; j++){
				storage[i][j] = 0;
			}
		}
		
		grid = new tGrid();
		Long = new brick(xCor, yCor, caseType);
		
		nextBrick = Long.brick;
		startBrick = Long.brick;
		currentBrick = startBrick;
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException 
	{
		Long.update();
		if(refresh){
			currentBrick = Long.brick;
		}
		
		ColorTrack = Long.caseNum;
		fallSpeed += delta;
		Long.update();
		currentBrick = Long.brick;
		
		Input input = gc.getInput();
		
		if(fallSpeed/1000 == 1){
			
			if(fallTest() == true && hitTestDown() == true){
				Long.posY += 1;
			} else if(fallTest() == false || hitTestDown() == false ) {
				for(int i = 0; i < 4; i++){
					storage[currentBrick[i][1]][currentBrick[i][0]] = ColorTrack;
				}
				currentBrick = null;
			}
			fallSpeed = 0;
		}

		
		if(currentBrick == null){
			currentBrick = nextBrick;
			nextBrick = null;
		}
		if(nextBrick == null){
			Long = new brick(xCor,yCor,randomInt(7));
			nextBrick = Long.brick;
		}
		if(input.isKeyPressed(Input.KEY_A)){
			
			
			if(sideTestLeft() == true && hitTestLeft())
				
			Long.posX -= 1;
				
		}
		if(input.isKeyPressed(Input.KEY_D)){
		
			
			if(sideTestRight() == true && hitTestRight() == true)
				
			Long.posX += 1;
				
		}
		if(input.isKeyPressed(Input.KEY_S)){
			
			
			if(fallTest() == true && hitTestDown() == true){
				Long.posY += 1;
			}
		}
		
		if(input.isKeyPressed(Input.KEY_W)){
			if(Long.rotate == 1){
				Long.rotate = 2;
			} else if(Long.rotate == 2) {
				Long.rotate = 3;
			} else if(Long.rotate == 3) {
				Long.rotate = 4;
			} else {
				Long.rotate = 1;
			}
		}
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		
//		Draw Tetris grid.
		for(int i = 4; i < grid.yRow.length - 2; i++){
			for(int j = 2; j < grid.xRow.length - 2; j++){
				if(storage[i][j] == 0){
					grid.gridImg.draw(grid.xRow[j],grid.yRow[i]);
					} else if(storage[i][j] == 1){
						Long.sQ1.draw(grid.xRow[j],grid.yRow[i]);
					} else if(storage[i][j] == 2){
						Long.sQ2.draw(grid.xRow[j],grid.yRow[i]);
					} else if(storage[i][j] == 3){
						Long.sQ3.draw(grid.xRow[j],grid.yRow[i]);
					} else if(storage[i][j] == 4){
						Long.sQ4.draw(grid.xRow[j],grid.yRow[i]);
					} else if(storage[i][j] == 5){
						Long.sQ5.draw(grid.xRow[j],grid.yRow[i]);
					} else if(storage[i][j] == 6){
						Long.sQ6.draw(grid.xRow[j],grid.yRow[i]);
					} else if(storage[i][j] == 7){
						Long.sQ7.draw(grid.xRow[j],grid.yRow[i]);
					}
			}
		}
		for(int i = 0; i < 4; i++)
			Long.sQ.draw(Long.xRow[currentBrick[i][0]],Long.yRow[currentBrick[i][1]]);
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
	
	public boolean fallTest(){
		for(int i = 0; i < 4; i++){
			if(currentBrick[i][1] >=  grid.yRow.length -3 ){
				return false;
			} 
		}
		return true;
	}
	
	public boolean hitTestDown(){
		for(int i = 0; i < 4; i++){
			if(storage[currentBrick[i][1] + 1][currentBrick[i][0]] != 0){
				return false;
			}
		}
		return true;
		
	}
	public boolean hitTestLeft(){
		for(int i = 0; i < 4; i++){
			if(storage[currentBrick[i][1]][currentBrick[i][0] - 1] != 0){
				return false;
			}
		}
		return true;
		
	}
	
	public boolean hitTestRight(){
		for(int i = 0; i < 4; i++){
			if(storage[currentBrick[i][1]][currentBrick[i][0] + 1] != 0){
				return false;
			}
		}
		return true;
	}
	public boolean sideTestRight(){
		for(int i = 0; i < 4; i++){
			if(currentBrick[i][0] > grid.xRow.length -4){
				return false;
			}
		}
		return true;
	}
	public boolean sideTestLeft(){
		for(int i = 0; i < 4; i++){
			if(currentBrick[i][0] < 3){
				return false;
			}
		}
		return true;
	}
		
	public int randomInt(int max){
		Random rand = new Random();
		int randomNum;
		randomNum = rand.nextInt(max)+1;
		return randomNum;
	}
}
