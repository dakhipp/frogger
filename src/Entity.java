import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class Entity {
	
	protected int x, y, width, height;
	protected Image img;
	
	public Entity() {
	
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(this.getImage(), this.x, this.y, null);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return x;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Image getImage() {
		return img;
	}

}
