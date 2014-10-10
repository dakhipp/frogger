import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class MovingEntity extends Entity {

	protected int[] possibleXs = { -120, 692 };
	protected int startingX, level, number;
	protected int speed;
	protected boolean isDead;

	public MovingEntity(int level) {
		this.level = level;
		this.isDead = false;
		this.number = 0;
	}

	public MovingEntity() {

	}

	protected int getRandX(int possibleX[]) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(possibleX.length);
		return possibleX[randomInt];
	}
	
	public void paint(Graphics g) {
		move();
		offScreenKill();
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(this.getImage(), this.x, this.y, null);
		rect = new Rectangle(x, y, width, height);
		g.drawRect(this.x, this.y, this.width, this.height);
	}

	protected void move() {
		if (number % 2 == 0) {
			if (startingX >= 0) {
				x = x - speed;
				number = 0;
			} else {
				x = x + speed;
				number = 0;
			}
		}
		number++;
		rect = new Rectangle(x, y, width, height);
	}

	protected void offScreenKill() {
		if (x < -120 || x > 692) {
			isDead = true;
		}
	}
	
	public void kill() {
		isDead = true;
	}

	protected boolean isDead() {
		return isDead;
	}

}
