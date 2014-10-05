import javax.swing.ImageIcon;


public class Tree extends Entity {

	public Tree(int xVal, int yVal) {
		ImageIcon i = new ImageIcon("images/Trees.png");
		x = xVal;
		y = yVal;
		img = i.getImage();
		width = img.getWidth(null);
		height = img.getHeight(null);
	}

}
