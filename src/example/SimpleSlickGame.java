package example;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

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
	brick Long;
	brick PhantomBrick;
	NextBrick NextBrickImage;
	Image Border;
	Image l0st;
	
	int xCor = 7;
	int yCor = 5;
	int fallSpeed = 0;
	int caseType = randomInt(7);
	int nextType = randomInt(7);
	int ColorTrack;
	int rotationTestCase = 2;
	
	int score = 0;
	int lines = 0;
	
	int[][] storage = new int[28][14];
	int[][] startBrick;
	int[][] nextBrick;
	int[][] currentBrick;
	int fullRow;
	int moveRow;
	boolean lost = false;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		
//		Initialize Storage loop.
		for(int i = 0; i < 28; i++)
			for(int j = 0; j < 14; j++)
				storage[i][j] = 0;

//		Initialize different variables
		Border = new Image("data/Grid_border_tina.png");
		l0st = new Image("data/Game_Over.png");
		grid = new tGrid();
		Long = new brick(xCor,yCor,caseType, 1);
		
		PhantomBrick = new brick(xCor,yCor, caseType, 2);
		NextBrickImage = new NextBrick();
		
		nextBrick = Long.brick;
		startBrick = Long.brick;
		currentBrick = startBrick;	
	}
	@Override
//	Void update that consistently updates objects inside it.
	public void update(GameContainer gc, int delta) throws SlickException {
		Input input = gc.getInput();
		
//		if lost just ensures that you cannot move any objects and it wont update anymore after lost check turns lost = true
		if(lost == false){
		Long.update();
		PhantomBrick.update();
		NextBrickImage.check();
		
		NextBrickImage.caseNum = nextType;
		currentBrick = Long.brick;

		System.out.println(currentBrick[1][1]);
				
		ColorTrack = Long.caseNum;
		fallSpeed += delta;
		
		
//		Checks for full rows.
		if(rowTest() == true) {
			if(fullRow != 0) {
				for(int i = 0; i < 12; i++){
					storage[fullRow][i] = 0;
					moveRow = 1;
				}
			}
		}
		
//		Triggers when a row is full and moves all above rows 1 row down.
		if(moveRow == 1){
			for(int j = fullRow; j > 1; j--)
				for(int i = 0; i < 12; i++)
					storage[j][i] = storage[j-1][i];
			moveRow = 0;
			fullRow = 0;
			score += 1000;
			lines += 1;
		}
		
//		Checks for a collision with anything below currentBrick, and stops it when a collision is detected.
		if(fallSpeed/500 == 1){
			if(fallTest() == true && hitTestDown() == true){
				Long.posY += 1;
				score += 10;
			} else if(fallTest() == false || hitTestDown() == false ) {
				for(int i = 0; i < 4; i++){
					storage[currentBrick[i][1]][currentBrick[i][0]] = ColorTrack;
				}
				currentBrick = null;
			}
			fallSpeed = 0;
		}
		
//		These if-statements check which brick is currently in play, and which will be the next brick to spawn.
		if(currentBrick == null){
			Long.brick = nextBrick;
			currentBrick = Long.brick;
			nextBrick = null;
		}
		if(nextBrick == null){
			int currentType = nextType;
			Long = new brick(xCor,yCor,currentType, 1);
			nextBrick = Long.brick;
			nextType = randomInt(7);
		}
		
//		Input controls. Very simple WASD or arrow keys.
//		Also checks for collision to the sides of the current brick.
		if(input.isKeyPressed(Input.KEY_A) || input.isKeyPressed(Input.KEY_LEFT)){
			if(sideTestLeft() == true && hitTestLeft())
				Long.posX -= 1;
		}
		
		if(input.isKeyPressed(Input.KEY_D) || input.isKeyPressed(Input.KEY_RIGHT)){
			if(sideTestRight() == true && hitTestRight() == true)	
				Long.posX += 1;	
		}
		
//		Causes the current brick to fall faster.
		if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN)){
			fallSpeed += 10;
		}	
		
//		Rotates the current brick. Checks for room to rotate, and if there isn't it will not rotate.
		if(input.isKeyPressed(Input.KEY_W) || input.isKeyPressed(Input.KEY_UP)){
			if(turnCheck() == true){
				if(Long.rotate == 1)
					Long.rotate = 2;
				else if(Long.rotate == 2)
					Long.rotate = 3;
				else if(Long.rotate == 3)
					Long.rotate = 4;
				else
					Long.rotate = 1;
			}
		}
		follow();
		}
		
//		Going through the storage array checking top positions within the array, if they are not 0, means a brick is at top and you lose
		for(int i = 0; i < 5; i++)
			for(int j = 2; j < 11; j++)
		if(storage[i][j] != 0){
			lost = true;
		}
		
//		If lost is true, you can press the enter key to reset storage(remove all bricks) and null lines and score.
//		turning lost into false again, to resume playing
		
		if(lost == true){
			if(input.isKeyPressed(Input.KEY_ENTER)){
				for(int i = 0; i < 28; i++)
					for(int j = 0; j < 14; j++)
						storage[i][j] = 0;
				
				score = 0;
				lines = 0;
				lost = false;
			}
		}
		
	}

	@Override
//	This void renders and draws all of our visual images.
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
//		Drawing the grid depending on storage. If storage have no values, it draws the background grid. 
//		Else it draws stored bricks colors depending on what type of brick is stored.
		for(int i = 4; i < grid.yRow.length - 2; i++){
			for(int j = 2; j < grid.xRow.length -2; j++){
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
		
//		Draws the current brick depending on currentBricks position within the grid.
		for(int i = 0; i < 4; i++)
			Long.sQ.draw(Long.xRow[currentBrick[i][0]],Long.yRow[currentBrick[i][1]]);	
		NextBrickImage.Draw.drawCentered(245.0f, 65.0f);
		
//		Drawing border on top of that drawing strings stating score and lines cleared
		Border.draw(0,0);
		g.drawString("Score :", 209, 150);
		g.drawString(" " + score, 200,170);
		g.drawString("Lines :", 209, 200);
		g.drawString(" " + lines, 200,220);
		
//		drawing an Image saying game over when lost = true, also draws a string saying what to press when game is lost
		if(lost == true) {
			l0st.drawCentered(110, 212);
			g.drawString("Press Enter to replay", 25, 240);
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
			appgc.setDisplayMode(290, 436, false);		
			appgc.start();
			
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
//	Testing if the brick is all the way down, if yes returns false, if not returns true.
	public boolean fallTest(){
		for(int i = 0; i < 4; i++){
		if(currentBrick[i][1] >=  grid.yRow.length -3 ){
			return false;
			} 
		}
		return true;
	}
	
//	Testing if the brick is all the way to the left, if yes returns false, if not returns true.
	public boolean sideTestLeft(){
		for(int i = 0; i < 4; i++){
			if(currentBrick[i][0] < 3){
				return false;
			}
		}
		return true;
	}
	
//	Testing if the brick is all the way to the right, if yes returns false, if not returns true.
	public boolean sideTestRight(){
		for(int i = 0; i < 4; i++){
			if(currentBrick[i][0] > grid.xRow.length -4){
				return false;
			}
		}
		return true;
	}
	
//	Testing if a row is full, and storing what row is full within fullRow.
	public boolean rowTest(){
		for(int j = 1; j < 28; j++){
			if(((storage[j][2]) != 0 && (storage[j][3]) != 0 && (storage[j][4]) != 0 && (storage[j][5]) != 0 && (storage[j][6]) != 0 && (storage[j][7]) != 0 && (storage[j][8]) != 0 && (storage[j][9]) != 0 && (storage[j][10]) != 0 && (storage[j][11]) != 0)){
				
				fullRow = j;
				return true;
			}
		}
		return false;
	}
	
//	Testing if current brick is on top of another brick.
	public boolean hitTestDown(){
		for(int i = 0; i < 4; i++){
			if(storage[currentBrick[i][1] + 1][currentBrick[i][0]] != 0){
				return false;
			}
		}
		return true;
	}
	
//	Testing if current brick is next to a placed brick on its Left side.
	public boolean hitTestLeft(){
		for(int i = 0; i < 4; i++){
			if(storage[currentBrick[i][1]][currentBrick[i][0] - 1] != 0){
				return false;
			}
		}
		return true;
	}
	
//	Testing if current brick is next to a placed brick on its right side.
	public boolean hitTestRight(){
		for(int i = 0; i < 4; i++){
			if(storage[currentBrick[i][1]][currentBrick[i][0] + 1] != 0){
				return false;
			}
		}
		return true;
	}
	
//	Function that randomizes which brick to spawn next.
	public int randomInt(int max){
		Random rand = new Random();
		int randomNum;
		randomNum = rand.nextInt(max)+1;
		return randomNum;
	}
	
//	This checks for the PhantomBrick position, if it is on top of another brick, or out of the play field its returns false. Else true.
	public boolean turnCheck(){
		for(int i = 0; i < 4; i++){
			if(storage[PhantomBrick.brick[i][1]][PhantomBrick.brick[i][0]] != 0 || PhantomBrick.brick[i][0] > grid.xRow.length -3 || PhantomBrick.brick[i][0] < 2 || PhantomBrick.brick[i][1] >=  grid.yRow.length -2 ){
				return false;
			}
		}
		return true;
	}
	
//	Function that updates PhantomBrick.Brick so it is similar to CurrentBrick, but the case number of rotate is 1 higher.
//	So we can check for the next rotate(if there is space).
	public void follow(){
			PhantomBrick.posX = Long.posX;
			PhantomBrick.posY = Long.posY;
			PhantomBrick.caseNum = Long.caseNum;
			if(Long.rotate == 1){
				PhantomBrick.rotate = 2;
			} else if (Long.rotate == 2){
				PhantomBrick.rotate = 3;
			} else if (Long.rotate == 3){
				PhantomBrick.rotate = 4;
			} else {
				PhantomBrick.rotate = 1;
			}
	}
}
