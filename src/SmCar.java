import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class SmCar extends Car {

	private ImageIcon[] possibleImages = { 
			new ImageIcon("images/smCars/smCar1.png"), new ImageIcon("images/smCars/smCar2.png"),
			new ImageIcon("images/smCars/smCar3.png"), new ImageIcon("images/smCars/smCar4.png"), 
			new ImageIcon("images/smCars/smCar5.png"), new ImageIcon("images/smCars/smCar6.png")
	};

	public SmCar() {
		img = super.randomImg(possibleImages);
		width = img.getWidth(null);
		height = img.getHeight(null);
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

}
