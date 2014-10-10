public class Player {

	private int score, level, lives, hops, flysCaught, hopBonus;
	private int smCarsStart, lgCarsStart, logsStart, startTrees;

	public Player() {
		score = 0;
		level = 1;
		lives = 3;
		hops = 0;
		hopBonus = hops*5;
		flysCaught = 0;
		smCarsStart = 5;
		lgCarsStart = 5;
		logsStart = 10;
		startTrees = 0;
	}

	public int getHopBonus() {
		return hopBonus;
	}

	public void addBonus() {
		score = score + hopBonus;
	}

	public void setHopBonus() {
		hopBonus = hops * 5;
	}

	public int getFlysCaught() {
		return flysCaught;
	}

	public int getStartTrees() {
		setTrees();
		return startTrees;
	}

	private void setTrees() {
		if (level < 5) {
			startTrees = 2;
		} else {
			startTrees = 0;
		}
	}

	public int getLogsStart() {
		return logsStart;
	}

	public int getLgCarsStart() {
		return smCarsStart;
	}

	public int getSmCarsStart() {
		return lgCarsStart;
	}

	public void setHops(int hops) {
		this.hops = hops;
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
		score = score + 5;
	}

	public int getHops() {
		return hops;
	}

	public void resetPlayer() {
		score = 0;
		level = 1;
		lives = 3;
		hops = 0;
		flysCaught = 0;
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
