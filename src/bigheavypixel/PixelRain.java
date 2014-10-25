package bigheavypixel;

import java.util.Random;

import org.newdawn.slick.SlickException;

public class PixelRain extends Pixel{

	Random random = new Random();
	
	public PixelRain() throws SlickException {
		super();
		randomX();
		reDropPixel();
	}
	
	@Override
	public void checkOutOfSceen() throws SlickException{
		if(y>=BigHeavyPixel.GAME_HEIGHT){
			y=0;
			randomX();
			reDropPixel();
			randomColor();
		}
	}
}
