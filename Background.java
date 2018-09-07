import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;


public class Background extends JPanel {
	
	private static final int TIME = 10; // in ms
	private static final Color backgroundColor = Color.BLACK;
	
	
	private Paddle paddle;
	private Ball ball;
	private Brick brick;
	
	
	public Background(Dimension d) {
		ball = new Ball((int)d.getWidth() , (int)d.getHeight());
		paddle = new Paddle((int)d.getWidth() , (int)d.getHeight());
		brick = new Brick((int) d.getWidth(), (int) d.getHeight());
	}
	
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		makeBackground(g);
		wait(TIME);
		handleBallBrickCollision(g);
		update();
		
		
	}
	
	private void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch(Exception e) {
			System.out.println("ERROR: " + e);
		}
	}
	
	
	
	
	private void printL(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(this.getWidth() /2, this.getHeight() / 2, 70, this.getHeight() /4);
		g.fillRect(this.getWidth() /2, this.getHeight() / 2 + this.getHeight() / 4  , 200, 65);
	}
	
	
	private void makeBackground(Graphics g) {
		g.setColor(backgroundColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		if(checkIfLost() == false) {
			if(checkIfWon() == false) {
				ball.drawBall(g);
				paddle.drawPaddle(g);
				brick.makeBricks(g);
				
			} else {
				printW(g);
			}
			
		} else {
			printL(g);
		}
	}
	
	private boolean checkIfWon() {
		for(int i = 0; i < brick.getAllX().size(); i++) {
			if(brick.getAllX().get(i) != null) {
				return false;
			}
		}
		return true;
	}
	
	private void printW(Graphics g) {
		printL(g);
		g.fillRect(this.getWidth() /2 + 200, this.getHeight() / 2, 70, this.getHeight() / 4 + 65);
		g.fillRect(this.getWidth() /2, this.getHeight() / 2 + this.getHeight() / 4  , 450, 65);
		g.fillRect(this.getWidth() / 2 + 400, this.getHeight() / 2, 70, this.getHeight() / 4 + 65);
	}
	
	private void update() { 
		ball.updateBall();
		handleBallPaddleCollision();
		repaint();
	}
	
	private boolean checkIfLost() {
		return ball.isGameOver();
	}
	
	public void handleBallBrickCollision(Graphics g) {
		for(int i = 0; i < brick.getAllX().size(); i++) {
			if(brick.getAllX().get(i) != null && brick.getAllY().get(i) != null) {
				boolean xCheck = ball.getX() >= brick.getAllX().get(i) && ball.getX() + ball.getRadius() <= brick.getAllX().get(i) + brick.getWidth();
				boolean yCheck = ball.getY() + ball.getRadius() >= brick.getAllY().get(i) && ball.getY()  <= brick.getAllY().get(i) + brick.getHeight();
				boolean sideCheckY = ball.getY() + ball.getRadius() / 2 >= brick.getAllY().get(i) && ball.getY() + ball.getRadius() / 2 <= brick.getAllY().get(i) + brick.getHeight();
				boolean midXCheck = ball.getX() + ball.getRadius() / 2 >= brick.getAllX().get(i) && ball.getX() + ball.getRadius() / 2 <= brick.getAllX().get(i) + brick.getWidth();
				if((xCheck || midXCheck)  && (yCheck || sideCheckY)) {
					ball.changeVelY();
					g.setColor(Color.BLACK);
					g.fillRect(brick.getAllX().get(i), brick.getAllY().get(i), brick.getWidth(), brick.getHeight());
					brick.getAllY().set(i , null);
					brick.getAllX().set(i, null);
				} 
			}
		}
	}
	
	
	
	public Paddle getPaddle() {
		return paddle;
	}
	
	public Ball getBall() {
		return ball;
	}
	
	public void handleBallPaddleCollision() {
		boolean ballPaddleXMatch = ball.getX() >= paddle.getX() && ball.getX() + ball.getRadius() <= paddle.getX() + paddle.getWidth();
		boolean ballPaddleYMatch = ball.getY() + ball.getRadius() >= paddle.getY() && ball.getY() <= paddle.getY() + paddle.getHeight();
	
		if(ballPaddleXMatch && ballPaddleYMatch) {
			ball.changeVelY();
		}	
	}
}