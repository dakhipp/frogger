import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class SmCar extends Car {

	private ImageIcon[] possibleImages = { 
			new ImageIcon("images/smCars/smCar1.png"), new ImageIcon("images/smCars/smCar2.png"),
			new ImageIcon("images/smCars/smCar3.png"), new ImageIcon("images/smCars/smCar4.png"), 
			new ImageIcon("images/smCars/smCar5.png"), new ImageIcon("images/smCars/smCar6.png")
	};

	public SmCar(int level) {
		img = super.randomImg(possibleImages);
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
