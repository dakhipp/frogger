import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class LogManager {

	private int logAmmount;
	private List<Log> logs = new ArrayList<Log>();
	
	public LogManager(int a) {
		this.logAmmount = a;

		spawnLog();
		
	}

	private void spawnLog() {
		int size = logs.size();
		if(size < logAmmount) {
			for(int i = 0; i < logAmmount - size; i++) {
				logs.add(new Log());
			}
		} else if ( size > logAmmount) {
			for(int i = 0; i < size - logAmmount; i++) {
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
