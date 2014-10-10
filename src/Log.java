import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Log extends MovingEntity {

	private int[] possibleYs = { 189, 95 };
	private boolean goingRight;

	public Log(int level) {
		ImageIcon i = new ImageIcon("images/Log.png");
		img = i.getImage();
		x = getRandX(possibleXs);
		y = yValue(x);
		startingX = x;
		speed = 1;
		isDead = false;
		width = img.getWidth(null);
		height = (img.getHeight(null) + 25);
		setSpeed();
		
	}
	
	public void setSpeed() {
		if(level > 3) {
			speed = (speed + 1)/2;
		} if ( level > 5) {
			speed = (speed + 1)/2;
		} if(speed > 9) {
			speed = (speed + 1)/2;
		}
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
