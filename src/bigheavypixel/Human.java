package bigheavypixel;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Human {
	
	private Image image;
	private float x;
	private float y;
	public static final float vX = 20;
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
		  x -= vX;
		  //image.setRotation(270);
	}
	public void moveRight (){
		  x += vX;
		  //image.setRotation(90); 
	}

	public void CheckBorder() {
		if (x > BigHeavyPixel.GAME_WIDTH){
			x =0;
		}
		if (x < 0){
			x =BigHeavyPixel.GAME_WIDTH;
		}
		
	}
} 
