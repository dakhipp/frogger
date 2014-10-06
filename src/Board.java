import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*; 

public class Board extends JPanel implements ActionListener{
	
	private enum STATE {
		MENU, 
		PLAY,
		SCORES
	};
	private STATE State = STATE.PLAY;
	
	Menu menu = new Menu();
	Timer time;
	Image img;
	Player player = new Player();
	SmCarManager smCarManager = new SmCarManager(10);
	LgCarManager lgCarManager = new LgCarManager(15);
	RiverRect river = new RiverRect(18,90);
	LogManager logManager = new LogManager(10);
	WinningRect winningBank = new WinningRect(18, 40);
	Fly fly = new Fly();
	TreeManager treeManager = new TreeManager(5);
	Frog f = new Frog();
	MenuFrog frog = new MenuFrog();
	
	public Board() {
		addKeyListener(new AL());
		setFocusable(true);
		
		if(State == STATE.PLAY) {
			ImageIcon i = new ImageIcon("images/background.png");
			img = i.getImage();
		} 
		
		time = new Timer(5, this);
		time.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		f.move();
		frog.move();
		repaint();
	}
	
	public void paint(Graphics g) {
		
		if(State == STATE.PLAY) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(img, 0, 0, null);
			logManager.paint(g);
			fly.paint(g);
			winningBank.paint(g);
			treeManager.paint(g);
			f.paint(g);
			river.paint(g);
			smCarManager.paint(g);
			lgCarManager.paint(g);
			
			frogCollisions();
			
			repaint();
		} else if(State == STATE.MENU) {
			
			menu.render(g);
			frog.paint(g);
			
			
		}
		
		
	}

	private class AL extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			f.keyReleased(e);
			frog.keyReleased(e);
			player.increaseHop();
		}
	}
	
	public void frogCollisions() {
		
		for(int i = 0; i < smCarManager.size(); i++) {
			if(f.intersects(smCarManager.smCars.get(i).getRect())){
				badHit();
			}
		}
		
		for(int i = 0; i < lgCarManager.size(); i++) {
			if(f.intersects(lgCarManager.lgCars.get(i).getRect())){
				badHit();
			}
		}
		
		for(int i = 0; i < treeManager.treeSize(); i++) {
			if(f.intersects(treeManager.trees.get(i).getRect())){
				badHit();
				treeManager.trees.get(i).destroy();
			}
		}
		
		for(int i = 0; i < logManager.logSize(); i++) {
			if(f.intersects(logManager.logs.get(i).getRect())){
				while(f.intersects(logManager.logs.get(i).getRect())){
					f.moveWithLog(logManager.logs.get(i).speed);
				}
			}
		}
		
		if(f.intersects(fly.getRect())) {
			caughtFly();
		} else if(f.intersects(river.getRect())) {
			badHit();
		} else if (f.intersects(winningBank.getRect())) {
			winLevel();
		} 	
	}
	
	public void caughtFly() {
		player.increaseLives();
		player.incraseScoreLevel();
		fly.destroy();
		System.out.println("Lives: " + player.getLives());
		System.out.println("Score: " + player.getScore());
	}
	
	public void winLevel() {
		player.increaseLevel();
		player.incraseScoreLevel();
		f.resetFrog();
		System.out.println("Level: " + player.getLevel());
		System.out.println("Score: " + player.getScore());
	}
	
	public void badHit() {
		player.decreaseLives();
		System.out.println("Lives: " + player.getLives());
		f.resetFrog();
		checkGameOver(); 
	}
	
	public void checkGameOver() {
		if(player.getLives() < 0) {
			// show high scores
			// update high scores if needed
			// go to main menu
			System.out.println("Game Over!");
		}
	}
	
}










