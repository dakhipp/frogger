import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Frog {
	
	int x, dx, y, dy;
	Image frogImg;
	
	public Frog() {
		ImageIcon i = new ImageIcon("images/frog.png");
		frogImg = i.getImage();
		x = 300;
		y = 612;
	}
	
	public void move() {
		if(dx != 0 ) {
			x = x + dx;
		}
		if(dy != 0) {
			y = y + dy;
		}
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
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT) {
			dx = -1;
		}
		if(key == KeyEvent.VK_RIGHT) {
			dx = 1;
		}
		if(key == KeyEvent.VK_DOWN) {
			dy = 1;
		}
		if(key == KeyEvent.VK_UP) {
			dy = -1;
		}
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if(key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
		if(key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
		if(key == KeyEvent.VK_UP) {
			dy = 0;
		}
	}
	
	
	
	
	
	
	
	
	
}
