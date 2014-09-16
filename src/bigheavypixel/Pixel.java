package bigheavypixel;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Pixel {
	
	private Image image;
	private float x;
	private float y;
	private float g = 20;
	Random random = new Random();
	
	public Pixel() throws SlickException{
		image = new Image("res/Pixel.png");
		x = 25+random.nextInt(BigHeavyPixel.GAME_WIDTH);
		y = 0;
	}
	public void update(){
		y+=g;
		if(y==BigHeavyPixel.GAME_HEIGHT){
			y=0;
			randomX();
		}
	}
	private void randomX() {
		x = 25+random.nextInt(BigHeavyPixel.GAME_WIDTH);;
	}
	public void render() {
		image.draw(x,y);
	}
}
