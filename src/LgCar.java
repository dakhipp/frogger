import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class LgCar extends Car {

	private ImageIcon[] possibleImagesLeft = { 
			new ImageIcon("images/lgCarsLeft/lgCar1.png"), new ImageIcon("images/lgCarsLeft/lgCar2.png"), 
			new ImageIcon("images/lgCarsLeft/lgCar3.png"), new ImageIcon("images/lgCarsLeft/lgCar4.png"), 
			new ImageIcon("images/lgCarsLeft/lgCar5.png"), new ImageIcon("images/lgCarsLeft/lgCar6.png") 
	};

	private ImageIcon[] possibleImagesRight = { 
			new ImageIcon("images/lgCarsRight/lgCar1.png"), new ImageIcon("images/lgCarsRight/lgCar2.png"), 
			new ImageIcon("images/lgCarsRight/lgCar3.png"), new ImageIcon("images/lgCarsRight/lgCar4.png"),
			new ImageIcon("images/lgCarsRight/lgCar5.png"), new ImageIcon("images/lgCarsRight/lgCar6.png") 
	};

	public LgCar(int level) {
		if (getX() > 0) {
			img = super.randomImg(possibleImagesLeft);
		} else {
			img = super.randomImg(possibleImagesRight);
		}
		width = img.getWidth(null);
		height = img.getHeight(null);
		this.level = level;
		speed = 1;
		setSpeed();	
	}

	protected void move() {
		if (number % 2 == 0) {
			if (startingX >= 0) {
				x = x - speed;
				number = 0;
			} else {
				x = x + speed;
				number = 0;
			}
		}
		number++;
		rect = new Rectangle(x, y, width, height);
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

}
