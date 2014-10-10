import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LgCarManager {

	private int amount, level;
	private int spawnDelay;
	private List<LgCar> lgCars = new ArrayList<LgCar>();

	public LgCarManager(int amount) {
		this.spawnDelay = 300;
		this.amount = amount;
		this.level = 1;
	}

	private void spawn() {
		int size = lgCars.size();
		if (size < amount) {
			lgCars.add(new LgCar(level));
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
		if(spawnDelay > 700) {
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
	
	public void updateValues(int level, int amount) {
		this.level = level;
		this.amount = amount;
	}
	
}
