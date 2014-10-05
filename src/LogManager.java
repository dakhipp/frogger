import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class LogManager {

	private int logAmount;
	private List<Log> logs = new ArrayList<Log>();
	
	public LogManager(int a) {
		this.logAmount = a;

		spawnLog();
		
	}

	private void spawnLog() {
		int size = logs.size();
		if(size < logAmount) {
			for(int i = 0; i < logAmount - size; i++) {
				logs.add(new Log());
			}
		} else if ( size > logAmount) {
			for(int i = 0; i < size - logAmount; i++) {
				logs.get(0);
			}
		}
	}
	
	private void updateLogs() {
		boolean re = false;
		for(int i = 0; i < logs.size(); i++) {
			if(logs.get(i).isDead()) {
				logs.remove(i);
				re = true;
			}
		}
		
		if(re) spawnLog();
		
	}
	
	public void paint(Graphics g) {
		updateLogs();
		
		for(Log log : logs) log.paint(g);
	}
	
}
