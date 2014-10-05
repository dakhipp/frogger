import java.util.Random;

import javax.swing.ImageIcon;


public class Fly extends Entity {

	private int [] possibleYs = {518, 471};//, 424, 330, 283, 189, 142, 95};
	
	public Fly() {
		ImageIcon i = new ImageIcon("images/Butterfly.png");
		img = i.getImage();
		x = getRandX();
		y = getRandomY(possibleYs);
		width = img.getWidth(null);
		height = img.getHeight(null);
	}
	
	private int getRandX() {
		Random random = new Random();
		//18 - 582
		int randomX = random.nextInt(583 - 18) + 18;
		return randomX;
	}
	
	private int getRandomY(int possibleYs []) {
		Random random = new Random();
		int randomInt = random.nextInt(possibleYs.length);
		return possibleYs[randomInt];
	}
	
}
