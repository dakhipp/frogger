import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*; 

import java.awt.Rectangle;

public class Board extends JPanel implements ActionListener{
	Timer time;
	Image img;
	Player player = new Player();
	CarManager carManager = new CarManager(15,10);
	RiverRect river = new RiverRect(18,90);
	LogManager logManager = new LogManager(10);
	WinningRect winningBank = new WinningRect(18, 40);
	Fly fly = new Fly();
	TreeManager treeManager = new TreeManager(5);
	Frog f = new Frog();
	
	public Board() {
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("images/background.png");
		img = i.getImage();
		time = new Timer(100, this);
		time.start();
		frogCollisions();
	}
	
	public void actionPerformed(ActionEvent e) {
		f.move();
		repaint();
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, 0, 0, null);
		
		logManager.paint(g);
		fly.paint(g);
		winningBank.paint(g);
		treeManager.paint(g);
		f.paint(g);
		river.paint(g);
		carManager.paint(g);
		
		repaint();
	}

	private class AL extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			f.keyReleased(e);
			player.increaseHop();
		}
	}
	
	public void frogCollisions() {
		
		for(int i = 0; i < carManager.smSize(); i++) {
			if(f.intersects(carManager.smCars.get(i).getRect())){
				player.decreaseLives();
				System.out.println(player.getLives());
				checkGameOver(); // NEED TO IMPLEMENT STILL
			}
		}
		
		for(int i = 0; i < carManager.lgSize(); i++) {
			if(f.intersects(carManager.lgCars.get(i).getRect())){
				player.decreaseLives();
				checkGameOver(); // NEED TO IMPLEMENT STILL
			}
		}
		
		for(int i = 0; i < treeManager.treeSize(); i++) {
			if(f.intersects(treeManager.trees.get(i).getRect())){
				player.decreaseLives();
				checkGameOver(); // NEED TO IMPLEMENT STILL
			}
		}
		
		for(int i = 0; i < logManager.logSize(); i++) {
			if(f.intersects(logManager.logs.get(i).getRect())){
				f.moveWithLog(logManager.logs.get(i).speed);
			}
		}
		
		if(f.intersects(fly.getRect())) {
			player.increaseLives();
			System.out.println(player.getLives());
		} else if(f.intersects(river.getRect())) {
			player.decreaseLives();
			checkGameOver(); // NEED TO IMPLEMENT STILL
		} else if (f.intersects(winningBank.getRect())) {
			player.increaseLevel();
			player.incraseScoreLevel();
		} 	
	}
	
	public void checkGameOver() {
		if(player.getLives() > 0) {
			// show high scores
			// update high scores if needed
			// go to main menu
		}
	}
	
}










