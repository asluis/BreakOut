import java.awt.Color;
import java.awt.Graphics;

public class Ball {

	private static final int RADIUS = 60;
	private static final int SPAWN_HEIGHT = 400;
	private static final Color ballColor = Color.CYAN;
	
	private int panelSizeX;
	private int panelSizeY;
	private int velX = 1;
	private int velY = 2;
	private int ballX;
	private int ballY;

	public Ball(int panelSizeX, int panelSizeY) {
		this.panelSizeX = panelSizeX;
		this.panelSizeY = panelSizeY;
		ballX = panelSizeX / 2 - RADIUS / 2;
		ballY = panelSizeY - SPAWN_HEIGHT;

	}

	public void drawBall(Graphics g) {
		g.setColor(ballColor);
		g.fillOval(ballX, ballY, RADIUS, RADIUS);
	}

	public void updateBall() {
		ballX += velX;
		ballY += velY;
		keepInBounds();
	}

	private void keepInBounds() {
		if (ballX <= 0 || ballX >= panelSizeX - RADIUS) {
			velX = -velX;
		} 
		if(ballY <= 0) {
			changeVelY();
		} 
	}
	
	
	public boolean isGameOver() {
		return ballY >= panelSizeY - RADIUS - RADIUS / 2;
	}

	public int getX() {
		return ballX;
	}
	
	public int getY() {
		return ballY;
	}
	
	public void changeVelY() {
		velY = -velY;
	}
	
	
	public int getRadius() {
		return RADIUS;
	}
	
	
	

}