package bigheavypixel;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class BigHeavyPixel extends BasicGame{
	
	private boolean isStarted;
	private boolean isGameOver;
	private boolean reStart;
	private Human human;
	public static final int GAME_WIDTH = 1280;
	public static final int GAME_HEIGHT = 720;
	private static final int PIXELRAIN_COUNT = 10;
	private static final int PIXELWAVE_COUNT = (GAME_WIDTH/Pixel.WIDTH)/2;
	private int hp;
	private Pixel[] pixelrains;
	private Score score;
	private Pixel[] pixelwaves;
	
	public static void main(String[] args) {
		try {
			BigHeavyPixel game = new BigHeavyPixel("BigHeavyPixel");
		    AppGameContainer appgc = new AppGameContainer(game);
		    appgc.setDisplayMode(GAME_WIDTH, GAME_HEIGHT, false);
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
		human.render();
		for (Pixel pixel : pixelrains) {
		      pixel.render();
		}
		for(Pixel pixel : pixelwaves){
			pixel.render();
		}	
		g.drawString("HP : " + hp, 100, 0);
		score.render(g);
		if(isGameOver){
			g.drawString("Game  Over", GAME_WIDTH/2, GAME_HEIGHT/2);
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		container.setVSync(true);
	    container.setTargetFrameRate(60);
	    initHuman();
	    initPixelRain();
	    score = new Score();
	    hp=100;
	    isStarted = true;
	    isGameOver = false;
	    reStart = false;
	    pixelwaves = new Pixel[PIXELWAVE_COUNT];
	    for (int i = 0; i < PIXELWAVE_COUNT; i++) {
		      pixelwaves[i] = new PixelWave((i*(Pixel.WIDTH)*2));
		}
	}

	private void initHuman() throws SlickException {
		human = new Human(GAME_WIDTH/2);
	}

	private void initPixelRain() throws SlickException {
		pixelrains = new Pixel[PIXELRAIN_COUNT];
	    for (int i = 0; i < PIXELRAIN_COUNT; i++) {
	      pixelrains[i] = new PixelRain();
	    }
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		updateHuman(container);
		updatePixelRain(container, delta);
		if((!isGameOver)&&isStarted){
			for (int i = 0; i < PIXELWAVE_COUNT; i++) {
			     pixelwaves[i].update(container, delta);
			     if(CollisionDetector.isCollide(human.HumanX(), human.HumanY(), pixelwaves[i].PixelX(), pixelwaves[i].PixelY())){
						hp-=1;
				}
			}
		}
		updateScore();
		checkHP();
		checkRestart(container);
		
	}

	private void checkRestart(GameContainer container) throws SlickException {
		if(reStart && hp<=0){
			container.reinit();
		}
	}

	private void updatePixelRain(GameContainer container, int delta) throws SlickException {
		if((!isGameOver)&&isStarted){
			for(int i =0;i<PIXELRAIN_COUNT;i++)
			{
				pixelrains[i].update(container, delta);
				if(CollisionDetector.isCollide(human.HumanX(), human.HumanY(), pixelrains[i].PixelX(), pixelrains[i].PixelY())){
					hp-=10;
					pixelrains[i].reDropPixel();					
				}
			}
		}
	}

	private void updateScore() {
		if((!isGameOver)&&isStarted){
			score.addScore(1);
		}
	}

	private void updateHuman(GameContainer container) {
		if((!isGameOver)&&isStarted){
			Input input = container.getInput();
			if (input.isKeyDown(Input.KEY_LEFT)) { 
		    	human.moveLeft();
		    }
		    if (input.isKeyDown(Input.KEY_RIGHT)) {
		    	human.moveRight();
		    }
		    human.CheckBorder();
		}
	}

	private void checkHP() {
		if(hp<=0){
			isGameOver=true;
		}
	}

	@Override
	  public void keyPressed(int key, char c) {
	    if (key == Input.KEY_SPACE){
	    	restartgame();
	    }
	 }

	private void restartgame() {
		if( hp<=0 ){
			reStart = true;
		}
	}

	
}
