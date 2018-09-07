import java.awt.Color;
import java.awt.Graphics;

public class Paddle {

	private static final int WIDTH = 120;
	private static final int HEIGHT = 25;
	private static final int SPAWN_HEIGHT = 80;
	private static final Color paddleColor = Color.WHITE;
	private static final int VELX = 15;
	
	private int x;
	private int y;
	private int panelX;

	public Paddle(int panelX, int panelY) {
		this.panelX = panelX;
		y = panelY - SPAWN_HEIGHT - HEIGHT;
		x = panelX / 2 - WIDTH / 2;
	}

	public void drawPaddle(Graphics g) {
		g.setColor(paddleColor);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public void moveLeft() {
		if(!(x <= 0)) {
			x-=VELX;
		}
		System.out.println("Current X: " + x); //TODO: Delete once it stays in bounds
	}
	
	public void moveRight() {
		if(!(x >= panelX - WIDTH)) {
			x+=VELX;
		}
		System.out.println("Current X: " + x); //TODO: Delete once it stays in bounds
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	
}