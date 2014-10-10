import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogManager {

	private int amount, level, spawnDelay;
	private List<Log> logs = new ArrayList<Log>();

	public LogManager(int amount) {
		this.spawnDelay = 400;
		this.amount = amount;
		this.level = 1;
	}

	private void spawnLog() {
		int size = logs.size();
		if (size < amount) {
			logs.add(new Log(level));
		} else if (size > amount) {
			logs.get(0);
		}
	}

	private void updateLogs() {
		for (int i = 0; i < logs.size(); i++) {
			if (logs.get(i).isDead()) {
				logs.remove(i);
			}
		}
		
		Random random = new Random();
		if(spawnDelay > 700) {
			spawnLog();
			spawnDelay = random.nextInt(300 - 100) + 100;
		} else {
			spawnDelay++;
		}
		
	}

	public void paint(Graphics g) {
		updateLogs();

		for (Log log : logs)
			log.paint(g);
	}

	public int logSize() {
		return logs.size();
	}

	public List<Log> allLogs() {
		return this.logs;
	}

	public void updateValues(int level, int amount) {
		this.level = level;
		this.amount = amount;
	}
	
}
