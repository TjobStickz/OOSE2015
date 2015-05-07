package example;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SimpleSlickGame extends BasicGame
{
	tGrid grid;
	brick Long;
	brick PhantomBrick;
	
	int xCor = 7;
	int yCor = 5;
	int fallSpeed = 0;
	int caseType = randomInt(7);
	int ColorTrack;
	int rotationTestCase = 2;
	//public boolean refresh = true;
	
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
	public void init(GameContainer gc) throws SlickException {
		
		for(int i = 0; i < 28; i++){
			for(int j = 0; j < 14; j++){
				storage[i][j] = 0;
			}
		}
		
		grid = new tGrid();
		Long = new brick(xCor,yCor,caseType, 1);
		PhantomBrick = new brick(xCor,yCor, caseType, 2);
		
		nextBrick = Long.brick;
		startBrick = Long.brick;
		currentBrick = startBrick;	
	}
	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Long.update();
		PhantomBrick.update();
		
		currentBrick = Long.brick;

		System.out.println(turnCheck());
		
		
		
		ColorTrack = Long.caseNum;
		fallSpeed += delta;
		
		Input input = gc.getInput();
		
		
		if(rowTest() == true){
		if(fullRow != 0){
			for(int i = 0; i < 12; i++){
				storage[fullRow][i] = 0;
				moveRow = 1;
				}
			}
		}
		if(moveRow == 1){
			for(int j = fullRow; j > 1; j--){
				for(int i = 0; i < 12; i++){
					storage[j][i] = storage[j-1][i];
				}
				moveRow = 0;
				fullRow = 0;
			}
		}
		
		
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
			Long = new brick(xCor,yCor,randomInt(7), 1);
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
		
		// 
		if(input.isKeyPressed(Input.KEY_W)){
			if(turnCheck() == true){

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
		follow();
		
		
		
	}

	@Override
	//This void renders and draws all of our visual images
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		//Drawing the grid depending on storage. If storage have no values, it draws the background grid. Else it draws stored bricks colors depending on what type of brick is stored
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
		// Draws the current brick depending on currentBricks position within the grid.
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
	// Testing if the brick is all the way down, if yes returns false, if not returns true
	public boolean fallTest(){
		for(int i = 0; i < 4; i++){
		if(currentBrick[i][1] >=  grid.yRow.length -3 ){
			return false;
			} 
		}
		return true;
	}
	// Testing if the brick is all the way to the left, if yes returns false, if not returns true
	public boolean sideTestLeft(){
		for(int i = 0; i < 4; i++){
			if(currentBrick[i][0] < 3){
				return false;
			}
		}
		return true;
	}
	// Testing if the brick is all the way to the right, if yes returns false, if not returns true
	public boolean sideTestRight(){
		for(int i = 0; i < 4; i++){
			if(currentBrick[i][0] > grid.xRow.length -4){
				return false;
			}
		}
		return true;
	}
	// Testing if a row is full, and storing what row is full within fullRow.
	public boolean rowTest(){
		for(int j = 1; j < 28; j++){
			if(((storage[j][2]) != 0 && (storage[j][3]) != 0 && (storage[j][4]) != 0 && (storage[j][5]) != 0 && (storage[j][6]) != 0 && (storage[j][7]) != 0 && (storage[j][8]) != 0 && (storage[j][9]) != 0 && (storage[j][10]) != 0 && (storage[j][11]) != 0)){
				
				fullRow = j;
				return true;
			}
		}
		return false;
	}
	// Testing if current brick is on top of another brick
	public boolean hitTestDown(){
		for(int i = 0; i < 4; i++){
			if(storage[currentBrick[i][1] + 1][currentBrick[i][0]] != 0){
				return false;
			}
		}
		return true;
		
	}
	// Testing if current brick is next to a placed brick on its Left side
	public boolean hitTestLeft(){
		for(int i = 0; i < 4; i++){
			if(storage[currentBrick[i][1]][currentBrick[i][0] - 1] != 0){
				return false;
			}
		}
		return true;
		
	}
	// Testing if current brick is next to a placed brick on its right side
	public boolean hitTestRight(){
		for(int i = 0; i < 4; i++){
			if(storage[currentBrick[i][1]][currentBrick[i][0] + 1] != 0){
				return false;
			}
		}
		return true;
		
	}
	// Random funktion used to randomize what brick is next
	public int randomInt(int max){
		Random rand = new Random();
		int randomNum;
		randomNum = rand.nextInt(max)+1;
		return randomNum;
	}
	//This checks for the PhantomBricks Pos, if it is ontop of another brick, or out of the play field its returns false. Else true
	public boolean turnCheck(){
		for(int i = 0; i < 4; i++){
			if(storage[PhantomBrick.brick[i][1]][PhantomBrick.brick[i][0]] != 0 || PhantomBrick.brick[i][0] > grid.xRow.length -3 || PhantomBrick.brick[i][0] < 2 || PhantomBrick.brick[i][1] >=  grid.yRow.length -2 ){
				return false;
			}
		}
		return true;
		
	}
	//function that updates PhantomBrick.Brick so it is similar to CurrentBrick, but the case number of rotate is 1 higher.
	//So we can check for the next rotate(if there is space).
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
