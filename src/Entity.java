import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

public class Entity {
	
	protected int x, y, width, height;
	protected Image img;
	public Rectangle rect = new Rectangle(x, y, width, height);
	
	public Entity() {
	
	}
	
	public Rectangle getRect() {
		return rect;
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
