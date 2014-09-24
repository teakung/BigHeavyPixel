package bigheavypixel;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Pixel {
	
	private Image image;
	protected float x;
	protected float y;
	protected float g = 17;
	static public final int WIDTH = 50;
	static public final int HEIGHT = 100; 
	Random random = new Random();
	private Color color;
	
	public Pixel() throws SlickException{
		image = new Image("res/Pixel.png");
		x = 25+random.nextInt(BigHeavyPixel.GAME_WIDTH);
		y = 0;
	}
	
	public void update() throws SlickException{
		y+=g;
		checkBorder();
	}

	public void checkBorder() throws SlickException{
		if(y>=BigHeavyPixel.GAME_HEIGHT){
			y=0;
			randomColor();
		}
	}
	
	public void randomColor()
	{
		color = new Color(random.nextInt(255), random.nextInt(255),random.nextInt(255));
	}
	
	public void render() {
		image.draw(x,y,color);
	}
	
	public float PixelX(){
		return x;
	}
	
	public float PixelY(){
		return y;
	}
	
	
}
