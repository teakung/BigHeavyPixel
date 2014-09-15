package bigheavypixel;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class BigHeavyPixel extends BasicGame{
	
	 public static void main(String[] args) {
		    try {
		      BigHeavyPixel game = new BigHeavyPixel("Super Ship Game");
		      AppGameContainer appgc = new AppGameContainer(game);
		      appgc.setDisplayMode(640, 480, false);
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
		
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
		
	}

}
