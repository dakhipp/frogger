import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*; 

public class Board extends JPanel implements ActionListener{
	Timer time;
	Image img;
	CarManager carManager = new CarManager(15,10);
	RiverRect river = new RiverRect(18,90);
	LogManager logManager = new LogManager(10);
	WinningRect winningBank = new WinningRect(18, 40);
	Fly fly;
	TreeManager treeManager = new TreeManager(5);
	Frog f;
	
	public Board() {
		f = new Frog();
		fly = new Fly();
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("images/background.png");
		img = i.getImage();
		time = new Timer(100, this);
		time.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		f.move();
		repaint();
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(img, 0, 0, null);
		logManager.paint(g);
		g2d.drawImage(fly.getImage(), fly.getX(), fly.getY(), null);
		winningBank.paint(g);
		treeManager.paint(g);
		g2d.drawImage(f.getImage(), f.getX(), f.getY(), null);
		river.paint(g);
		carManager.paint(g);
		
		repaint();
	}

	private class AL extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			f.keyReleased(e);
		}
	}
}










