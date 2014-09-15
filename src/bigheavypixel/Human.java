package bigheavypixel;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Human {
	
	private Image image;
	private float x;
	private float y;
	public static final float HumanYposition = (75*BigHeavyPixel.GAME_HEIGHT)/100;
	
	public Human(float x) throws SlickException{
		image = new Image("res/human.png");
		this.x = x;
		this.y = HumanYposition;
	}
	
	public void render() {
		image.draw(x,y);
	}
	public void moveLeft (){
		  x -= 5;
		  image.setRotation(270);
	}
	public void moveRight (){
		  x += 5;
		  image.setRotation(90); 
	}
} 
