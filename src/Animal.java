import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Animal extends Entity {

	private boolean movingLeft, movingRight;
	
	public Animal(int x, int y, int level) {
		ImageIcon i = new ImageIcon("images/Animal.png");
		img = i.getImage();
		this.x = x;
		this.y = y;
		width = img.getWidth(null);
		height = img.getHeight(null);
		rect = new Rectangle(x, y, width, height);
	}
	
	public void paint(Graphics g) {
		if(movingLeft()) {
			moveLeft();
		} else if(movingRight()) {
			moveRight();
		}
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(this.getImage(), this.x, this.y, null);
		rect = new Rectangle(x, y, width, height);
	}
	
	public void setMovingLeft() {
		movingLeft = true;
		movingRight = false;
	}
	
	public void setMovingRight() {
		movingRight = true;
		movingLeft = false;
	}
	
	
	public boolean movingLeft() {
		return movingLeft;
	}
	
	public boolean movingRight() {
		return movingRight;
	}
	
	protected void moveLeft() {
		x = x - 1;
		rect = new Rectangle(x, y, width, height);
	}
	
	protected void moveRight() {
		x = x + 1;
		rect = new Rectangle(x, y, width, height);
	}

}
