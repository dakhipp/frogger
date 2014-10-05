import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class CarManager {

	private int smAmount;
	private int lgAmount;
	private List<SmCar> smCars = new ArrayList<SmCar>();
	private List<LgCar> lgCars = new ArrayList<LgCar>();
	
	public CarManager(int a, int b) {
		this.smAmount = a;
		this.lgAmount = b;

		spawnSm();
		spawnLg();
	
	}
	
	private void spawnSm() {
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
	
	private void spawnLg() {
		int size = lgCars.size();
		if(size < lgAmount) {
			for(int i = 0; i < lgAmount - size; i++) {
				lgCars.add(new LgCar());
			}
		} else if ( size > lgAmount) {
			for(int i = 0; i < size - lgAmount; i++) {
				lgCars.get(0);
			}
		}
	}
	
	public void paint(Graphics g) {
		updateSm();
		updateLg();
		
		for(SmCar sCar : smCars) sCar.paint(g);
		for(LgCar lCar : lgCars) lCar.paint(g);
	}
	
	private void updateSm() {
		boolean re = false;
		for(int i = 0; i < smCars.size(); i++) {
			if(smCars.get(i).isDead()) {
				smCars.remove(i);
				re = true;
			}
		}
		
		if(re) spawnSm();
		
	}
	
	private void updateLg() {
		boolean re = false;
		for(int i = 0; i < lgCars.size(); i++) {
			if(lgCars.get(i).isDead()) {
				lgCars.remove(i);
				re = true;
			}
		}
		
		if(re) spawnLg();
		
	}

}
