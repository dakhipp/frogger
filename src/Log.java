import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Log extends MovingEntity {

	private int[] possibleYs = { 189, 95 };
	private Rectangle bigRect;
	private boolean goingRight;

	public Log() {
		ImageIcon i = new ImageIcon("images/Log.png");
		img = i.getImage();
		x = getRandX(possibleXs);
		y = yValue(x);
		startingX = x;
		speed = 1;
		isDead = false;
		width = img.getWidth(null);
		height = (img.getHeight(null) + 25);
		
	}
	
	public boolean getGoingRight() {
		return goingRight;
	}
	
	protected void setGoingRight() {
		goingRight = true;
	}
	
	public int getSpeed() {
		return speed;
	}

	protected void move() {
		if (number > 3) {
			if (startingX >= 0) {
				x = x - speed;
				number = 0;
			} else {
				x = x + speed;
				setGoingRight();
				number = 0;
			}
		}
		number++;
		rect = new Rectangle(x, y, width, height);
	}

	private int yValue(int x) {
		int yVal;
		if (x < 1) {
			yVal = 142;
		} else {
			yVal = getRandX(possibleYs);
		}
		return yVal;
	}

}
