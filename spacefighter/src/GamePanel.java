import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int width, height;
	ship player;
	int shipPosition;
	ArrayList<invader> invaders = new ArrayList<invader>();
	private bullet bullet;
	Timer timer;
	

	public GamePanel(int width, int height){
		this.width = width;
		this.height = height;
		
		//add listener
		this.addKeyListener(new shipListener());
		
		//player starts at y=300 (middle)
		shipPosition = 300;
		
		//init player ship
		player = new ship(Color.green);
		timer = new Timer(100 ,new shootListener());
		bullet = new bullet(Color.RED);
		
		startGame();
	}
	
	
	public boolean isFocusable(){
		return true;
	}
	
	private void startGame(){
		player.setPosition(275);
		generateInvaders(3, 20);
		repaint();
		this.requestFocus();
	}
	
	public void paintComponent(Graphics page){
		page.fillRect(0, 0, width, height);
		player.drawShip(page);
		bullet.drawBullet(page);
		
		//paint invaders
		for(int i = 1; i < invaders.size(); i++ ){
			invaders.get(i).drawInvader(page);
		}
	}
	
	private void generateInvaders(int rows, int cols){
		invader firstTemp = new invader(Color.blue, 25, 25);
		firstTemp.setPosition(0, 0);
		invaders.add(firstTemp);
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				invader temp = new invader(Color.blue, 25, 25);
				temp.setPosition(j*30, i*30);
				invaders.add(temp);
				System.out.println("x: "+j*50+" Y: "+i*50);
			}
		}
	}
	
	public void shoot(){
		bullet.setPosition(player.getPosition(), 490);
		timer.start();
	}
	
	
	public class shipListener implements KeyListener{

		public void keyPressed(KeyEvent k) {
			int key = k.getKeyCode();
			if(key == 39){
				int curpos = player.getPosition();
				player.setPosition(curpos+7);
				repaint();
			}
			else if(key == 37){
				int curpos = player.getPosition();
				player.setPosition(curpos-7);
				repaint();
			}
			else if(key == 32){
				shoot();
			}
		}

		public void keyReleased(KeyEvent k){
			//************************
		}

		public void keyTyped(KeyEvent k) {
			//**************************
		}
	}
	
	public class shootListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0){
			if(bullet.getY() > 0){
				int playerPos = player.getPosition();
				int currentPos = bullet.getY();
				System.out.println(currentPos);
				bullet.setPosition(playerPos, currentPos - 5);
				repaint();
			}
		} 
	}
}


