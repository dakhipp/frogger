import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Frog {

	private int x, dx, y, dy, width, height, hops, number;
	private boolean offScreen;
	private Image frogImg;
	private Rectangle rect;

	public Frog() {
		ImageIcon i = new ImageIcon("images/frog.png");
		frogImg = i.getImage();
		x = 300;
		y = 612;
		width = frogImg.getWidth(null);
		height = frogImg.getHeight(null);
		hops = 0;
		number = 0;
		offScreen = false;
	}

	public void resetFrog() {
		ImageIcon i = new ImageIcon("images/frog.png");
		frogImg = i.getImage();
		x = 300;
		y = 612;
		width = frogImg.getWidth(null);
		height = frogImg.getHeight(null);
		offScreen = false;
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(frogImg, x, y, null);
		rect = new Rectangle(x, y, width, height);
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void moveWithLog(int logspeed) {
		if(number > 3) {	
			if(logspeed > 0) {
				x = x + logspeed;
				number = 0;
			}
			if(logspeed < 0 ) {
				x = x + logspeed;
				number = 0;
			}
		}
		number++;
	}
	
	public boolean getOffscreen() {
		offScreenKill();
		return offScreen;
	}

	protected void offScreenKill() {
		if (x < -5 || x > 655) {
			offScreen = true;
		}
	}
	
	public void move() {
		if (dx != 0) {
			x = x + dx;
			dx = 0;
		}
		if (dy != 0) {
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

	private void increaseHops() {
		hops = hops + 1;
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT && x > 18) {
			dx = -47;
			increaseHops();
		}
		if (key == KeyEvent.VK_RIGHT && x < 582) {
			dx = 47;
			increaseHops();
		}
		if (key == KeyEvent.VK_DOWN && y < 612) {
			dy = 47;
			increaseHops();
		}
		if (key == KeyEvent.VK_UP && y > 50) {
			dy = -47;
			increaseHops();
		}
	}

	public int getHops() {
		return hops;
	}

	public Rectangle getRect() {
		return rect;
	}

	public boolean intersects(Rectangle r) {
		return rect.intersects(r);
	}

}
