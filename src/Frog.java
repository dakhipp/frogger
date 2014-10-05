import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Frog {
	
	protected int x, dx, y, dy, width, height;
	protected Image frogImg;
	
	public Frog() {
		ImageIcon i = new ImageIcon("images/frog.png");
		frogImg = i.getImage();
		x = 300;
		y = 612;
		width = frogImg.getWidth(null);
		height = frogImg.getHeight(null);
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

}
