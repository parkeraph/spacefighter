import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int width, height;
	ship player;
	int shipPosition;
	ArrayList<invader> invaders = new ArrayList<invader>();

	public GamePanel(int width, int height){
		this.width = width;
		this.height = height;
		
		//player starts at y=300 (middle)
		shipPosition = 300;
		
		//init player ship
		player = new ship(Color.green);
		
		startGame();
	}
	
	private void startGame(){
		player.setPosition(275);
		generateInvaders(3, 20);
		repaint();
	}
	
	public void paintComponent(Graphics page){
		page.fillRect(0, 0, width, height);
		player.drawShip(page);
		
		//paint invaders
		for(int i = 1; i < invaders.size(); i++ ){
			invaders.get(i).drawInvader(page);
		}
	}
	
	private void generateInvaders(int rows, int cols){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				invader temp = new invader(Color.blue, 25, 25);
				temp.setPosition(j*30, i*30);
				invaders.add(temp);
				System.out.println("x: "+j*50+" Y: "+i*50);
			}
		}
	}
	
}
