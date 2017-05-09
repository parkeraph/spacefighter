import java.awt.*;

public class bullet {
	
	Color bulletColor;
	int x;
	int y;
	int width;
	int height;
	
	public bullet(Color thisColor){
		bulletColor = thisColor;
		width = 10;
		height = 10;
	}
	
	public void setPosition(int thisX,int thisY){
		x = thisX;
		y = thisY;
	}
	
	public int getY(){
		return y;
	}
	
	public int getX(){
		return x;
	}
	
	public void drawBullet(Graphics page){
		page.fillRect(x, y, width, height);
	}
	
}
