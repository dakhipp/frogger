import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class CarManager {

	private int smAmmount;
	private int lgAmmount;
	private List<SmCar> smCars = new ArrayList<SmCar>();
	private List<LgCar> lgCars = new ArrayList<LgCar>();
	
	public CarManager(int a, int b) {
		this.smAmmount = a;
		this.lgAmmount = b;
		spawnSm();
		spawnLg();
	}
	
	private void spawnSm() {
		int size = smCars.size();
		if(size < smAmmount) {
			for(int i = 0; i < smAmmount - size; i++) {
				smCars.add(new SmCar());
			}
		} else if ( size > smAmmount) {
			for(int i = 0; i < size - smAmmount; i++) {
				smCars.get(0);
			}
		}
	}
	
	private void spawnLg() {
		int size = lgCars.size();
		if(size < lgAmmount) {
			for(int i = 0; i < lgAmmount - size; i++) {
				lgCars.add(new LgCar());
			}
		} else if ( size > lgAmmount) {
			for(int i = 0; i < size - lgAmmount; i++) {
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
