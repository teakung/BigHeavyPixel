package bigheavypixel;


public class CollisionDetector {
	static boolean isCollide(float HumanX, float HumanY, float PixelX, float PixelY) {
		if(HumanX<=PixelX+50&&HumanX>=PixelX-50)
		{
			if(HumanY<=PixelY+100&&HumanY>=PixelY){
				return true;
			}
		}
	    return false;
	}
}
