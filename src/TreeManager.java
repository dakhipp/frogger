import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class TreeManager {

	private List<Tree> trees = new ArrayList<Tree>();

	public TreeManager() {
		
	}

	public void spawnTrees(int level) {
		int treeAmount = 0;
		if(level > 3) {
			treeAmount = 1 + (level-2);
		}
		if (trees.size() < treeAmount) {
			for (int i = 0; i < treeAmount - trees.size(); i++) {
				trees.add(new Tree());
			}
		} else if (trees.size() > treeAmount) {
			for (int i = 0; i < trees.size() - treeAmount; i++) {
				trees.get(0);
			}
		}
	}

	public void destroyTrees() {
		trees.removeAll(trees);
	}

	public void paint(Graphics g) {
		for (Tree tree : trees) {
			tree.paint(g);
		}
	}

	public int treeSize() {
		return trees.size();
	}

	public List<Tree> allTrees() {
		return this.trees;
	}

}