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
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		container.setVSync(true);
	    container.setTargetFrameRate(60);
	    human = new Human(100);
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		updateHumanMovement(input, delta);
		
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
