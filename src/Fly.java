import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Fly extends Entity {

	private int[] possibleYs = { 518, 471 };// , 424, 330, 283, 189, 142, 95};
											// //ADJUST FLY SPAWNING
	private Rectangle rect = new Rectangle();

	public Fly() {
		ImageIcon i = new ImageIcon("images/Butterfly.png");
		img = i.getImage();
		x = getRandX();
		y = getRandomY(possibleYs);
		width = img.getWidth(null);
		height = img.getHeight(null);
		rect = new Rectangle(x, y, width, height);
	}

	public void resetFly() {
		ImageIcon i = new ImageIcon("images/Butterfly.png");
		img = i.getImage();
		x = getRandX();
		y = getRandomY(possibleYs);
		width = img.getWidth(null);
		height = img.getHeight(null);
		rect = new Rectangle(x, y, width, height);
	}


	public void setFly() {
		ImageIcon i = new ImageIcon("images/Butterfly.png");
		img = i.getImage();
		x = getRandX();
		y = getRandomY(possibleYs);
		width = img.getWidth(null);
		height = img.getHeight(null);
		rect = new Rectangle(x, y, width, height);
	
	}

	public void destroy() {
		this.img = null;
		this.rect = new Rectangle(0, 0, 0, 0);
	}

	public Rectangle getRect() {
		return rect;
	}

	private int getRandX() {
		// 18 - 582
		Random random = new Random();
		int randomX = random.nextInt(583 - 18) + 18;
		return randomX;
	}

	private int getRandomY(int possibleYs[]) {
		Random random = new Random();
		int randomInt = random.nextInt(possibleYs.length);
		return possibleYs[randomInt];
	}

}
