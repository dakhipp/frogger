import javax.swing.*;

public class Frame {

	public static void main(String [] args) {
		JFrame frame = new JFrame("Frogger");
		frame.add(new Board());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(650, 672);
		frame.setVisible(true);
	}

}
