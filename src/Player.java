public class Player {

	private int score, level, lives, hops, flysCaught;
	
	public Player() {
		score = 0;
		level = 1;
		lives = 3;
		hops = 0;
		flysCaught = 0;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getScore() {
		return score;
	}
	
	public void increaseLevel() {
		level = level + 1;
	}
	
	public void incraseScoreLevel() {
		score = score + 250;
	}
	
	public void decreaseLives() {
		lives = lives - 1;
	}
    
	public void increaseLives() {
		lives = lives + 1;
		flysCaught = flysCaught + 1;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void increaseHop() {
		hops = hops + 1;
		score = score + 10;
	}
	
	public int getHops() {
		return hops;
	}
	
	public void checkHighScore() {
		
	}
	
	public void checkLevel() {
		
	}
	
	public void checkLives() {
		
	}
	
	public void checkHops() {
		
	}
	
	public void checkFlysCaught() {
		
	}
	

}
