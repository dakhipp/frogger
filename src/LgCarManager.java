import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class LgCarManager {

	private int amount;
	public List<LgCar> lgCars = new ArrayList<LgCar>();
	
	public LgCarManager(int a) {
		this.amount = a;
		spawn();
	}
	
	private void spawn() {
		int size = lgCars.size();
		if(size < amount) {
			for(int i = 0; i < amount - size; i++) {
				lgCars.add(new LgCar());
			}
		} else if ( size > amount) {
			for(int i = 0; i < size - amount; i++) {
				lgCars.get(0);
			}
		}
	}
	
	public void paint(Graphics g) {
		update();
		for(LgCar lCar : lgCars) lCar.paint(g);
	}
	
	private void update() {
		boolean re = false;
		for(int i = 0; i < lgCars.size(); i++) {
			if(lgCars.get(i).isDead()) {
				lgCars.remove(i);
				re = true;
			}
		}
		
		if(re) spawn();
	}
	
	public int size() {
		return lgCars.size();
	}

}
