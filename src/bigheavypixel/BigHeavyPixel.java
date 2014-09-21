package bigheavypixel;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class BigHeavyPixel extends BasicGame{
	
	private Human human;
	public static final int GAME_WIDTH = 1280;
	public static final int GAME_HEIGHT = 720;
	private static final int PIXEL_COUNT = 15;
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
	    human = new Human(100);
	    pixels = new Pixel[PIXEL_COUNT];
	    for (int i = 0; i < PIXEL_COUNT; i++) {
	      pixels[i] = new PixelRain();
	      pixels[i].randomColor();
	    }
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		updateHumanMovement(input, delta);
		for(int i =0;i<PIXEL_COUNT;i++)
		{
			pixels[i].update();
		}
	}

	void updateHumanMovement(Input input, int delta) {
		if (input.isKeyDown(Input.KEY_LEFT)) { 
	    	human.moveLeft();
	    }
	    if (input.isKeyDown(Input.KEY_RIGHT)) {
	    	human.moveRight();
	    }
	    human.CheckBorder();
	}
}
