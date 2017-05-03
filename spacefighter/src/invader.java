import java.awt.*;

public class invader {
	Color invaderColor;
	int x;
	int y;
	int width;
	int height;
	
	public invader(Color thisColor,int thisWidth,int thisHeight){
		invaderColor = thisColor;
		x = 0;
		y = 0;
		width = thisWidth;
		height = thisHeight;
	}
	
	public void drawInvader(Graphics page){
		page.setColor(invaderColor);
		page.fillRect(x, y, width, height);
	}
	
	public void setPosition(int thisX, int thisY){
		x = thisX;
		y = thisY;
	}
	
}
