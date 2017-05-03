import javax.swing.*;

public class SpaceFighter extends JApplet {
	
	private static final long serialVersionUID = 1L;
	private final int WIDTH = 600;
	private final int HEIGHT = 600;
	
	public void init(){
		GamePanel panel = new GamePanel(WIDTH, HEIGHT);
		getContentPane().add(panel);
		setSize(WIDTH, HEIGHT);
	}
}
