import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

import java.util.Random;

public class Car {

	int [] possibleXs = {-120, 692};
	int [] possibleY1 = {565, 518, 330};
	int [] possibleY2 = {471, 424, 283};
	
	int x, y, startingX;
	int speed;
	boolean isDead;
	Image carImg;
	
	public Car() {
		x = getRandX(possibleXs);
		y = getRandY(possibleY1, possibleY2);
		startingX = x;
		speed = 1;
		isDead = false;
	}
	
	public boolean isDead() {
		return isDead;
	}
	
	public void paint(Graphics g) {
		move();
		offScreenKill();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(this.getImage(), this.x, this.y, null);
	}
	
	public void move() {
		if(startingX >= 0) {
			x = x - speed;
		} else {
			x = x + speed;
		}
		
	}
	
	public void offScreenKill() {
		if(x < -120 || x > 692) {
			isDead = true;
		}
	}
	
	private int getRandX(int possibleX []) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(possibleX.length);
		return possibleX[randomInt];
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
		
		// flip image
		
		return finalImage;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return x;
	}
	
	public Image getImage() {
		return carImg;
	}
	
	
//	public Image flipOverY(Image toBeFlipped) {
//		
//		//Image toBeFlipped = ImageIO.read(new File(file));
//		BufferedImage buffered = (BufferedImage) toBeFlipped;
//		
//		AffineTransform tx=AffineTransform.getScaleInstance(-1.0,1.0);  //scaling
//	     tx.translate(-buffered.getWidth(),0);  //translating
//	     AffineTransformOp tr=new AffineTransformOp(tx,null);  //transforming
//	     
//	     tr.filter(buffered, null);
//	}

}
