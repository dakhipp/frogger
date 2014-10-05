import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*; 

public class Board extends JPanel implements ActionListener{
	Frog f;
	Image img;
	Timer time;
	CarManager carManager = new CarManager(15,10);
	LogManager logManager = new LogManager(10);

	public Board() {
		f = new Frog();
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("images/background.png");
		img = i.getImage();
		time = new Timer(5, this);
		time.start();

	}
	
	public void actionPerformed(ActionEvent e) {
		f.move();
		repaint();
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(img, 0, 0, null);
		g2d.drawImage(f.getImage(), f.getX(), f.getY(), null);
		carManager.paint(g);
		logManager.paint(g);
		
		repaint();
	}

	private class AL extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			f.keyReleased(e);
		}
	}
}










