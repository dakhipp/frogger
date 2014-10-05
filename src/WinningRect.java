import java.awt.Graphics;

public class WinningRect extends Entity {

	public WinningRect(int xVal, int yVal) {
		x = xVal;
		y = yVal;
		width = 610;
		height = 40;
	}
	
	 public void paint(Graphics g) {
	    g.drawRect (x, y, width, height);  
	 }

}