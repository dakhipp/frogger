import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class MovingEntity extends Entity {

	protected int [] possibleXs = {-120, 692};
	protected int startingX, speed;
	protected boolean isDead;
	
	public MovingEntity() {
		
	}
	
	protected int getRandX(int possibleX []) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(possibleX.length);
		return possibleX[randomInt];
	}
	
	public void paint(Graphics g) {
		move();
		offScreenKill();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(this.getImage(), this.x, this.y, null);
	}
	
	public void move() {
		if(startingX >= 0) {
			x = x - speed;
		} else {
			x = x + speed;
		}
		
	}
	
	public void offScreenKill() {
		if(x < -120 || x > 692) {
			isDead = true;
		}
	}
	
	public boolean isDead() {
		return isDead;
	}

}
