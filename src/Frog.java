import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Frog {
	
	protected int x, dx, y, dy, width, height;
	protected Image frogImg;
	protected Rectangle rect;
	
	public Frog() {
		ImageIcon i = new ImageIcon("images/frog.png");
		frogImg = i.getImage();
		x = 300;
		y = 612;
		width = frogImg.getWidth(null);
		height = frogImg.getHeight(null);
	}
	
	public void resetFrog() {
		ImageIcon i = new ImageIcon("images/frog.png");
		frogImg = i.getImage();
		x = 300;
		y = 612;
		width = frogImg.getWidth(null);
		height = frogImg.getHeight(null);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(frogImg, x, y, null);
		rect = new Rectangle(x, y, width, height);
	}
	
	public void moveWithLog(int logSpeed) {
		dx = logSpeed;
		x = x + dx;
	}
	
	public void move() {
		if(dx != 0) {
			x = x + dx;
			dx = 0;
		}
		if(dy != 0) {
			y = y + dy;
			dy = 0;
		}
	}
	
	public void setX(int xVal) {
		x = xVal;
	}
	
	public void setY(int yVal) {
		x = yVal;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Image getImage() {
		return frogImg;
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT && x > 18) {
			dx = -47;
		}
		if(key == KeyEvent.VK_RIGHT && x < 582) {
			dx = 47;
		}
		if(key == KeyEvent.VK_DOWN && y < 612) {
			dy = 47;
		}
		if(key == KeyEvent.VK_UP && y > 50) {
			dy = -47;
		}
	}

	public Rectangle getRect() {
		return rect;
	}
	
	public boolean intersects(Rectangle r) {
		return rect.intersects(r);
	}

}
