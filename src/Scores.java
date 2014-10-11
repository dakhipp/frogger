import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Scores extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon i = new ImageIcon("images/scoresBg.png");
	Image img = i.getImage();

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, 0, 0, null);
	}

}
