package bigheavypixel;

import org.newdawn.slick.Graphics;

public class Score {

	private int score;
	
	public Score(){
		score = 0;
	}
	
	public void addScore(int scoreIn){
		score+=scoreIn;
	}
	
	public void render(Graphics g){
		g.drawString("score : " + score/60, 200, 0);
	}
}
