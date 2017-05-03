
import java.awt.*;

public class ship {
	private Color shipColor;
	private int position;
	
	public ship(Color newShipColor){
		shipColor = newShipColor;
	}
	
	public ship(Color newShipColor, int initPosition){
		shipColor = newShipColor;
		position = initPosition;
	}
	
	//draw the ship in a certain position on the X axis
	public void drawShip(Graphics page){
		page.setColor(shipColor);
		page.fillRect(position, 500, 50, 20);
		page.fillRect(position+20, 490, 10, 20);
	}
	
	public void setPosition(int pos){
		position = pos;
	}
	
	public int getPosition(){
		return position;
	}
	
	
}
