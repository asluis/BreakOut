import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {
	
	
	Background background;
	
	
	public static void main(String[] args) {
		Game mainGame = new Game();
		mainGame.start();
		
	}
	
	
	
	public void start(){
		JFrame frame = new JFrame("Breakout -- by LUIS ALVAREZ.... APCSA");
		frame.setSize(1200, 800);
		background = new Background(frame.getSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		background.addKeyListener(new BackgroundListener());
		frame.getContentPane().add(background);
		background.setFocusable(true);	// Focuses on the background, lets java know we need to focus here (used for the 
		//keyboard listener
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}	
	
	
	class BackgroundListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if(keyCode == KeyEvent.VK_LEFT) {
				background.getPaddle().moveLeft();
			} else if(keyCode == KeyEvent.VK_RIGHT) {
				background.getPaddle().moveRight();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
		
	}
	
	
	
	
}