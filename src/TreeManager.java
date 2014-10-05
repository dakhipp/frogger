import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class TreeManager {

	private int treeAmount;
	private List<Tree> trees = new ArrayList<Tree>();
	
	public TreeManager(int a) {
		this.treeAmount = a;
		spawnTree();
		
	}

	private void spawnTree() {
		int size = trees.size();
		if(size < treeAmount) {
			for(int i = 0; i < treeAmount - size; i++) {
				trees.add(new Tree());
			}
		} else if ( size > treeAmount) {
			for(int i = 0; i < size - treeAmount; i++) {
				trees.get(0);
			}
		}
	}
	
//	private void updateTrees() {
//		for(int i = 0; i < trees.size(); i++) {
//			if(player.won()) {
//				trees.remove(i);
//			}
//		}
//	}
	
	public void paint(Graphics g) {
		//updateTrees();
		
		for(Tree tree : trees) tree.paint(g);
	}
	
}