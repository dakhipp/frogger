import java.util.Random;

import javax.swing.ImageIcon;


public class Tree extends Entity {

	public Tree() {
		ImageIcon i = new ImageIcon("images/Trees.png");
		x = getRandX();
		y = 2;
		img = i.getImage();
		width = img.getWidth(null);
		height = img.getHeight(null);
	}
	
	private int getRandX() {
		Random random = new Random();
		//18 - 582
		int randomX = random.nextInt(583 - 18) + 18;
		return randomX;
	}

}
