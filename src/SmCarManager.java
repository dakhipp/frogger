import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SmCarManager {

	private int amount, level, spawnDelay;
	private List<SmCar> smCars = new ArrayList<SmCar>();

	public SmCarManager(int amount, int level) {
		this.spawnDelay = 500;
		this.amount = level * amount;
	}

	private void spawn() {
		int size = smCars.size();
		if (size < amount) {
			smCars.add(new SmCar());
		} else if (size > amount) {
			smCars.get(0);
		}
	}

	public void paint(Graphics g) {
		update();
		for (SmCar sCar : smCars)
			sCar.paint(g);
	}

	private void update() {
		for (int i = 0; i < smCars.size(); i++) {
			if (smCars.get(i).isDead()) {
				smCars.remove(i);
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
		return smCars.size();
	}

	public List<SmCar> allSmCars() {
		return this.smCars;
	}

}
