import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class SmCarManager {

	private int smAmount;
	public List<SmCar> smCars = new ArrayList<SmCar>();
	
	
	public SmCarManager(int a) {
		this.smAmount = a;
		spawn();	
	}
	
	private void spawn() {
		int size = smCars.size();
		if(size < smAmount) {
			for(int i = 0; i < smAmount - size; i++) {
				smCars.add(new SmCar());
			}
		} else if ( size > smAmount) {
			for(int i = 0; i < size - smAmount; i++) {
				smCars.get(0);
			}
		}
	}
	
	public void paint(Graphics g) {
		update();
		for(SmCar sCar : smCars) sCar.paint(g);
	}
	
	private void update() {
		boolean re = false;
		for(int i = 0; i < smCars.size(); i++) {
			if(smCars.get(i).isDead()) {
				smCars.remove(i);
				re = true;
			}
		}
		
		if(re) spawn();
		
	}
	
	public int size() {
		return smCars.size();
	}

}
