import java.awt.Graphics;

public class RiverRect extends Entity {

	public RiverRect(int xVal, int yVal) {
		x = xVal;
		y = yVal;
		width = 200;
		height = 200;
	}
	
	 public void paint(Graphics g) {
	    g.drawRect (x, y, width, height);  
	 }

}
