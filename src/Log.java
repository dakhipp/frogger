import javax.swing.ImageIcon;


public class Log extends MovingEntity {

	private int [] possibleYs = {189, 95};
	
	public Log() {
		ImageIcon i = new ImageIcon("images/Log.png");
		img = i.getImage();
		x = getRandX(possibleXs);
		y = yValue(x);
		startingX = x;
		speed = 1;
		isDead = false;
	}	
	
	private int yValue(int x) {
		int yVal;
		if( x < 1 ) {
			yVal = 142;
		} else {
			yVal = getRandX(possibleYs);
		}
		return yVal;
	}

}
