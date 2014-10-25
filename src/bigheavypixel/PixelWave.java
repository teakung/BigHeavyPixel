package bigheavypixel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class PixelWave extends Pixel{

//	private static int default_bullet_delay = 1000;
//	private static int time = 0;
//	public boolean trigger;
	private int delay = 500;
	protected float g = 10;
	public PixelWave(int desireX) throws SlickException {
		// TODO Auto-generated constructor stub
		super();
		x = desireX;
		y = -1*(Pixel.HEIGHT);
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException{
//		time -= delta;
//	    if (time <= 0) {
//			trigger = true;     
//	        time = default_bullet_delay;  // Reset the timer
//	    }
//	    if(trigger){
	    	y+=g;
	    	if(y>=BigHeavyPixel.GAME_HEIGHT){
//	    		trigger = false;
	    		y = -1*(delay);
	    		randomColor();
	    	}
	    }
}
