import javax.swing.ImageIcon;


public class SmCar extends Car {
	
	ImageIcon [] possibleImages = { 
			new ImageIcon("images/smCars/smCar1.png"),
			new ImageIcon("images/smCars/smCar2.png"),
			new ImageIcon("images/smCars/smCar3.png"),
			new ImageIcon("images/smCars/smCar4.png"),
			new ImageIcon("images/smCars/smCar5.png"),
			new ImageIcon("images/smCars/smCar6.png"),
	};
	
	public SmCar() {
		img = super.randomImg(possibleImages);
		width = img.getWidth(null);
		height = img.getHeight(null);
	}

}
