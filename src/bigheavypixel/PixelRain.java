package bigheavypixel;

import java.util.Random;

import org.newdawn.slick.SlickException;

public class PixelRain extends Pixel{

	Random random = new Random();
	
	public PixelRain() throws SlickException {
		super();
		randomX();
		randomY();
	}
	
	@Override
	public void update() throws SlickException{
		y+=g;
		if(y>=BigHeavyPixel.GAME_HEIGHT){
			y=0;
			randomX();
			randomY();
			randomColor();
		}
	}
	
	private void randomY() {
		y = random.nextInt(BigHeavyPixel.GAME_HEIGHT*2)*-1;
		
	}
	private void randomX() {
		x = 25+random.nextInt(BigHeavyPixel.GAME_WIDTH);
	}
}
