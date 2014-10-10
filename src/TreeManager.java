import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class TreeManager {

	private int treeAmount;
	private List<Tree> trees = new ArrayList<Tree>();

	public TreeManager(int amount) {
		this.treeAmount = amount;
		spawnTree();
	}

	public void spawnTree() {
		int size = trees.size();
		if (size < treeAmount) {
			for (int i = 0; i < treeAmount - size; i++) {
				trees.add(new Tree());
			}
		} else if (size > treeAmount) {
			for (int i = 0; i < size - treeAmount; i++) {
				trees.get(0);
			}
		}
	}

	public void destroyTrees() {
		for (Tree tree : trees) {
			trees.remove(tree);
		}
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