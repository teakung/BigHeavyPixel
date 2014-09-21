package bigheavypixel;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

public class Pixel {
	
	private static final Color C = null;
	private Image image;
	protected float x;
	protected float y;
	protected float g = 15;
	Random random = new Random();
//	private Shape shape;
	private Color color;
	
	public Pixel() throws SlickException{
		image = new Image("res/Pixel.png");
		x = 25+random.nextInt(BigHeavyPixel.GAME_WIDTH);
		y = 0;
	}
	public void update() throws SlickException{
		y+=g;
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
	
}
