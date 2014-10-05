import javax.swing.ImageIcon;


public class LgCar extends Car {

	ImageIcon [] possibleImagesLeft = { 
			new ImageIcon("images/lgCarsLeft/lgCar1.png"),
			new ImageIcon("images/lgCarsLeft/lgCar2.png"),
			new ImageIcon("images/lgCarsLeft/lgCar3.png"),
			new ImageIcon("images/lgCarsLeft/lgCar4.png"),
			new ImageIcon("images/lgCarsLeft/lgCar5.png"),
			new ImageIcon("images/lgCarsLeft/lgCar6.png"),
	};
	
	ImageIcon [] possibleImagesRight = { 
			new ImageIcon("images/lgCarsRight/lgCar1.png"),
			new ImageIcon("images/lgCarsRight/lgCar2.png"),
			new ImageIcon("images/lgCarsRight/lgCar3.png"),
			new ImageIcon("images/lgCarsRight/lgCar4.png"),
			new ImageIcon("images/lgCarsRight/lgCar5.png"),
			new ImageIcon("images/lgCarsRight/lgCar6.png"),
	};

	public LgCar() {
		
		if(getX() > 0) {
			img = super.randomImg(possibleImagesLeft);
		} else {
			img = super.randomImg(possibleImagesRight);
		}
		width = img.getWidth(null);
		height = img.getHeight(null);
		
	}
	

}
