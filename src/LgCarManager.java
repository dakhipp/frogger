import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class LgCarManager {

	private int amount, level;
	private int spawnDelay;
	private List<LgCar> lgCars = new ArrayList<LgCar>();

	public LgCarManager(int amount, int level) {
		this.spawnDelay = 500;
		this.amount = amount * level;
//		this.level = level;
	}

//	private void spawn() {
//		int size = lgCars.size();
//		int randomMin = 1;
//		int randomMax = this.amount + this.level;
//		if (size < amount) {
//			for (int i = 0; i < amount - size; i++) {
//				Random random = new Random();
//				int randomRoll = random.nextInt(randomMax - randomMin) + randomMin;
//				if (randomRoll % 3 == 0) {
//					lgCars.add(new LgCar());
//				}
//			}
//		} else if (size > amount) {
//			for (int i = 0; i < size - amount; i++) {
//				lgCars.get(0);
//			}
//		}
//	}

	private void spawn() {
		int size = lgCars.size();
		if (size < amount) {
			lgCars.add(new LgCar());
		} else if (size > amount) {
			lgCars.get(0).kill();
		}
	}
	
	public void paint(Graphics g) {
		update();
		for (LgCar lCar : lgCars)
			lCar.paint(g);
	}

	private void update() {
		for (int i = 0; i < lgCars.size(); i++) {
			if (lgCars.get(i).isDead()) {
				lgCars.remove(i);
			}
		}
		
		Random random = new Random();
		if(spawnDelay > 600) {
			spawn();
			spawnDelay = random.nextInt(200 - 100) + 100;
		} else {
			spawnDelay++;
		}

	}

	public int size() {
		return lgCars.size();
	}

	public List<LgCar> allLgCars() {
		return this.lgCars;
	}
	
}
