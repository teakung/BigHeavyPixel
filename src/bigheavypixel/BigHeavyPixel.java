package bigheavypixel;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class BigHeavyPixel extends BasicGame{
	
	private boolean isStarted;
	private boolean isGameOver;
	private Human human;
	public static final int GAME_WIDTH = 1280;
	public static final int GAME_HEIGHT = 720;
	private static final int PIXEL_COUNT = 25;
	private Pixel[] pixels;
	
	public static void main(String[] args) {
		try {
			BigHeavyPixel game = new BigHeavyPixel("BigHeavy Pixel");
		    AppGameContainer appgc = new AppGameContainer(game);
		    appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
		    appgc.start();
		} catch (SlickException e) {
		    e.printStackTrace();
		}
	}
	
	public BigHeavyPixel(String title) {
		super(title);
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		human.render();
		for (Pixel pixel : pixels) {
		      pixel.render();
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		container.setVSync(true);
	    container.setTargetFrameRate(60);
	    initHuman();
	    initPixelRain();
	    isStarted = true;
	    isGameOver = false;
	}

	private void initHuman() throws SlickException {
		human = new Human(100);
	}

	private void initPixelRain() throws SlickException {
		pixels = new Pixel[PIXEL_COUNT];
	    for (int i = 0; i < PIXEL_COUNT; i++) {
	      pixels[i] = new PixelRain();
	      pixels[i].randomColor();
	    }
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		if((!isGameOver)&&isStarted){
			Input input = container.getInput();
			updateHumanMovement(input, delta);
			for(int i =0;i<PIXEL_COUNT;i++)
			{
				pixels[i].update();
				if(CollisionDetector.isCollide(human.HumanX(), human.HumanY(), pixels[i].PixelX(), pixels[i].PixelY())){
//					System.out.println("Collision ");
					
					isGameOver=true;
				}
			}
		}
	}

	void updateHumanMovement(Input input, int delta) {
		if (input.isKeyDown(Input.KEY_LEFT)) { 
	    	human.moveLeft();
	    }
	    if (input.isKeyDown(Input.KEY_RIGHT)) {
	    	human.moveRight();
	    }
	    if(input.isKeyDown(Input.KEY_ENTER)){
	    	isGameOver= false;
	    }
	    human.CheckBorder();
	}
	
	@Override
	  public void keyPressed(int key, char c) {
	    if (key == Input.KEY_SPACE){
	    	isGameOver = false;
	    }

	 }
}
