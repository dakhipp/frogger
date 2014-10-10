import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Hud  {

	private String scoreLabel, levelLabel, livesLabel;
	private int numberOfLives;
	private Image img;
	
	public Hud() {
		livesLabel = "Lives: ";
	}
	
	public void paint(Graphics g) {
		g.setFont(new Font("Serif", Font.BOLD, 40));
		g.drawString(scoreLabel, 410, 40);
		g.drawString(levelLabel, 10, 40);
		g.drawString(livesLabel, 178, 40);
		int firstLoop = numberOfLives;
		int secondLoop = 0;
		if(numberOfLives > 4) {
			firstLoop = 4;
			secondLoop = numberOfLives - 4;
		}
		for(int i = 0; i < firstLoop; i++) {
			g.drawImage(getImage(), 290+(i*25), 16, img.getWidth(null), img.getHeight(null), null);
		}
		for(int i = 0; i < secondLoop; i++) {
			g.drawImage(getImage(), 290+(i*25), 45, img.getWidth(null), img.getHeight(null), null);
		}
	}
	    
	public void setScoreString(int score) {
		scoreLabel = "Score: " + score;
	}
	
	public void setLevelString(int level) {
		levelLabel = "Level: " + level;
	}
	
	public void livesIcons(int lives) {
		ImageIcon i = new ImageIcon("images/Butterfly.png");
		img = i.getImage();
		numberOfLives = lives;
	}
	
	private Image getImage() {
		return img;
	}

}
