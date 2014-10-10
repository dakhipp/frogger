import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class MenuFrog {

	private int x, dx, y, dy, position, finalPosition;
	private Image frogImg;
	private boolean onMenu;

	public MenuFrog() {
		position = 1;
		ImageIcon i = new ImageIcon("images/frog.png");
		frogImg = i.getImage();
		x = 445;
		y = 420;
		onMenu = true;
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(frogImg, x, y, null);
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

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_DOWN && position == 1) {
			dy = 35;
			dx = -25;
			position = 2;
		} else if (key == KeyEvent.VK_DOWN && position == 2) {
			dy = 35;
			dx = 25;
			position = 3;
		} else if (key == KeyEvent.VK_DOWN && position == 3) {
			dy = -70;
			dx = 0;
			position = 1;
		} else if (key == KeyEvent.VK_UP && position == 1) {
			dy = 70;
			dx = 0;
			position = 3;
		} else if (key == KeyEvent.VK_UP && position == 2) {
			dy = -35;
			dx = 25;
			position = 1;
		} else if (key == KeyEvent.VK_UP && position == 3) {
			dy = -35;
			dx = -25;
			position = 2;
		}

		if (key == KeyEvent.VK_ENTER && !onMenu) {
			position = 1;
			finalPosition = 4;
			onMenu = true;
		} else if (key == KeyEvent.VK_ENTER && onMenu) {
			finalPosition = position;
			onMenu = false;
		}

	}

	public int getFinalPosition() {
		return finalPosition;
	}

	public void resetPosition() {
		position = 1;
		x = 445;
		y = 420;
		finalPosition = 0;
		onMenu = true;
	}
}
