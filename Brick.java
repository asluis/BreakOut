import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Brick extends JPanel{
	
	// spacing in between the bricks
	private static final int SPACING = 25;
	private static final int WIDTH = 100;
	private static final int HEIGHT = 50;
	private static final int SPAWN_HEIGHT = 550;
	private static final int NUMBER_OF_COLORS = 5;
	private static final int BUFFER = 8;
	
	private int rows;
	private int cols;
	private ArrayList<Integer> xTracker = new ArrayList<Integer>();
	private ArrayList<Integer> yTracker = new ArrayList<Integer>();
	private int panelWidth;
	private int panelHeight;
	
	public Brick(int panelX, int panelY) {
		panelWidth = panelX;
		panelHeight = panelY;
		rows = (panelWidth - SPACING * 2) / WIDTH; 
		cols = (panelHeight - SPAWN_HEIGHT - SPACING * 2) / HEIGHT;
		brickTracker();
	}
	
	private void brickTracker() {
		for(int r = 1; r <= rows - 3; r++) {
			for(int c = 1; c <= cols; c++) {
				xTracker.add(SPACING * r + WIDTH * r);
				yTracker.add(SPACING * c + HEIGHT * c);
			}
		}
	}
	
	
	public void makeBricks(Graphics g) {
		for(int i = 0; i < yTracker.size(); i++) {
			if(xTracker.get(i) != null && yTracker.get(i) != null) {
				g.setColor(colorChooser(i));
				g.fillRect(xTracker.get(i), yTracker.get(i), WIDTH, HEIGHT);
			}
		}
	}
	
	
	
	
	
	
	public ArrayList<Integer> getAllX(){
		
		return xTracker;
	}
	
	public ArrayList<Integer> getAllY(){
		return yTracker;
	}
	
	
	
	
	
	private Color colorChooser(int x) {
		if(x % NUMBER_OF_COLORS == 1) {
			return Color.BLUE;
		} else if(x % NUMBER_OF_COLORS == 2) {
			return Color.RED;
		} else if(x % NUMBER_OF_COLORS == 3) {
			return Color.GRAY;
		} else if(x % NUMBER_OF_COLORS == 4) {
			return Color.GREEN;
		} else {
			return Color.ORANGE;
		}
	}
	
	public int getWidth() {
		return WIDTH;
	}
	
	public int getBuffer() {
		return BUFFER;
	}
	
	public int getHeight() {
		return HEIGHT;
	}
	
	public int getSpawnHeight() {
		return SPAWN_HEIGHT;
	}
	
	public int getSpacing() {
		return SPACING;
	}
	
}