import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Board extends JPanel implements ActionListener {

	private static enum STATE {
		MENU, PLAY, CONTROLS, SCORES
	};

	private STATE State = STATE.MENU;

	private Menu menu = new Menu();
	private Scores scores = new Scores();
	private Controls controls = new Controls();
	private Timer time;
	private Image img;
	private Player player = new Player();
	private SmCarManager smCarManager = new SmCarManager(player.getSmCarsStart(), player.getLevel());
	private LgCarManager lgCarManager = new LgCarManager(player.getLgCarsStart(), player.getLevel());
	private RiverRect river = new RiverRect(18, 95);
	private LogManager logManager = new LogManager(player.getLogsStart(), player.getLevel());
	private WinningRect winningBank = new WinningRect(18, 40);
	private Fly fly = new Fly();
	private TreeManager treeManager = new TreeManager(player.getStartTrees());
	private Frog f = new Frog();
	private MenuFrog menuFrog = new MenuFrog();

	public Board() {
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("images/background.png");
		img = i.getImage();
		time = new Timer(15, this);
		time.start();
	}

	public void actionPerformed(ActionEvent e) {
		f.move();
		menuFrog.move();
		repaint();
	}

	public void paint(Graphics g) {
		if (State == STATE.PLAY) {
			removeTouchingObjects();
			Graphics2D g2d = (Graphics2D) g;
			g2d.drawImage(img, 0, 0, null);
			logManager.paint(g);
			if (fly.checkReset(player.getLevel())) {
				fly.resetFly();
			}
			fly.paint(g);
			winningBank.paint(g);
			treeManager.paint(g);
			f.paint(g);
			river.paint(g);
			smCarManager.paint(g);
			lgCarManager.paint(g);
			frogCollisions();
			repaint();
		} else if (State == STATE.MENU) {
			menu.render(g);
			menuFrog.paint(g);
			if (menuFrog.getFinalPosition() == 1) {
				State = STATE.PLAY;
				treeManager.spawnTree();
				menuFrog.resetPosition();
				f.resetFrog();
			} else if (menuFrog.getFinalPosition() == 2) {
				State = STATE.CONTROLS;
				f.resetFrog();
			} else if (menuFrog.getFinalPosition() == 3) {
				State = STATE.SCORES;
				f.resetFrog();
			}
		} else if (State == STATE.CONTROLS) {
			controls.render(g);
			if (menuFrog.getFinalPosition() == 4) {
				State = STATE.MENU;
				menuFrog.resetPosition();
			}
		} else if (State == STATE.SCORES) {
			scores.render(g);
			if (menuFrog.getFinalPosition() == 4) {
				State = STATE.MENU;
				menuFrog.resetPosition();
			}
		}
	}

	private class AL extends KeyAdapter {
		public void keyReleased(KeyEvent e) {
			f.keyReleased(e);
			menuFrog.keyReleased(e);
		}
	}
	
	private void removeTouchingObjects() {
		if(movingObjects().size() > 2) {	
			for(int i = 0; i < movingObjects().size(); i++) {
				int otherObject = i + 1;
				if(i == movingObjects().size() - 1) {
					otherObject = 0;
				}
				if(movingObjects().get(i).intersects(movingObjects().get(otherObject).getRect())) {
					movingObjects().get(i).kill();
				}	
			}
		}
	}
	
	private boolean checkOnLog() {
		boolean onLog = false;
		for(Log log : logManager.allLogs()) {
			if( f.intersects(log.getRect())) {
				onLog = true;
			}
			
		}
		return onLog;
	}
	
	private ArrayList<Entity> movingObjects() {
		ArrayList<Entity> movingObjects = new ArrayList<Entity>();
		if(smCarManager.size() > 0) {
			movingObjects.addAll(smCarManager.allSmCars());
		}
		if(lgCarManager.size() > 0) {
			movingObjects.addAll(lgCarManager.allLgCars());
		}
		if(lgCarManager.size() > 0) {
			movingObjects.addAll(logManager.allLogs());
		}
		return movingObjects;
	}

	private void frogCollisions() {
		if(checkDangerousCollisions()) {
			badHit();
		} else if (checkOnLog()) {
			f.moveWithLog(getLogSpeed());
		} else if (f.intersects(fly.getRect())) {
			caughtFly();
		} else if(f.intersects(river.getRect())) {
			badHit();
		} else if (f.intersects(winningBank.getRect())) {
			winLevel();
		}	
	}

	private int getLogSpeed() {
		int logSpeed = 0;
		for (Log log : logManager.allLogs()) {
			if (f.intersects(log.getRect())) {
				if(log.getGoingRight() == false) {
					logSpeed = (log.getSpeed()*-1);
				} else if(log.getGoingRight() == true) {
					logSpeed = log.getSpeed();
				}
			}
		}
		return logSpeed;
	}

	private boolean checkDangerousCollisions() {
		boolean collision = false;
		for (Entity ent : dangerousObjects()) {
			if (f.intersects(ent.getRect())) {
				collision = true;
			}
		}
		return collision;
	}

	private ArrayList<Entity> dangerousObjects() {
		ArrayList<Entity> hazards = new ArrayList<Entity>();
		hazards.addAll(smCarManager.allSmCars());
		hazards.addAll(lgCarManager.allLgCars());
		hazards.addAll(treeManager.allTrees());
		return hazards;
	}

	private void caughtFly() {
		player.increaseLives();
		player.incraseScoreLevel();
		fly.destroy();
		System.out.println("Lives: " + player.getLives());
		System.out.println("Score: " + player.getScore());
	}

	private void winLevel() {
		player.increaseLevel();
		player.incraseScoreLevel();
		treeManager.destroyTrees();
		f.resetFrog();
		if (fly.checkReset(player.getLevel())) {
			fly.resetFly();
		}
		System.out.println("Level: " + player.getLevel());
		System.out.println("Score: " + player.getScore());
	}

	private void badHit() {
		player.decreaseLives();
		System.out.println("Lives: " + player.getLives());
		f.resetFrog();
		checkGameOver();
	}

	private void checkGameOver() {
		if (player.getLives() < 0) {
			player.setHops(f.getHops());
			player.setHopBonus();
			player.addBonus();
			System.out.println("Game Over!");
			player.setHopBonus();
			player.addBonus();
			System.out.println("Final Score: " + player.getScore());
			System.out.println("Final Level: " + player.getLevel());
			System.out.println("Final Hops: " + player.getHops());
			System.out.println("Hop Bonus: " + player.getHops());
			System.out.println("Flys Caught: " + player.getFlysCaught());

			// check player for high scores
			// show high scores
			treeManager.destroyTrees();
			player.resetPlayer(); // PROBABLY MOVE THIS LATER
			menuFrog.resetPosition();
			State = STATE.MENU;
		}
	}



}