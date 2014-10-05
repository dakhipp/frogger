import java.awt.Image;

import javax.swing.ImageIcon;

import java.util.Random;

public class Car extends MovingEntity {

	private int [] possibleY1 = {565, 518, 330};
	private int [] possibleY2 = {471, 424, 283};
	
	public Car() {
		x = getRandX(possibleXs);
		y = getRandY(possibleY1, possibleY2);
		startingX = x;
		speed = 1;
		isDead = false;
	}
	
	private int getRandY(int possibleY1 [], int possibleY2 []) {
		Random randomGenerator = new Random();
		int randomInt;
		int y;
		if(x < 0) {
			randomInt = randomGenerator.nextInt(possibleY1.length);
			y = possibleY1[randomInt];
		} else {
			randomInt = randomGenerator.nextInt(possibleY2.length);
			y = possibleY2[randomInt];
		}
		return y;
	}
	
	public Image randomImg(ImageIcon possibleImages []) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(possibleImages.length);
		Image finalImage = possibleImages[randomInt].getImage();
		return finalImage;
	}

}
