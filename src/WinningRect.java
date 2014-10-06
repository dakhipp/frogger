import java.awt.Rectangle;

public class WinningRect extends Entity {

	public WinningRect(int xVal, int yVal) {
		x = xVal;
		y = yVal;
		width = 610;
		height = 40;
		rect = new Rectangle(x, y, width, height);
	}
	
//   COMMENTED FOR DEBUGGEING IF NEEDED	
//	 public void paint(Graphics g) {
//	    g.drawRect (x, y, width, height);  
//	 }

}