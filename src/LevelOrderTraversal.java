import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {
	// public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	// ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
	// if (root==null) {
	// return result;
	// }
	// Queue<TreeNode> currentQueue=new LinkedList<TreeNode>();
	// Queue<TreeNode> nextQueue=new LinkedList<TreeNode>();
	// nextQueue.add(root);
	// while (!nextQueue.isEmpty()){
	// currentQueue=nextQueue;
	// nextQueue=new LinkedList<TreeNode>();
	// ArrayList<Integer> currentLevel=new ArrayList<Integer>();
	// while (!currentQueue.isEmpty()){
	// TreeNode currentNode=currentQueue.poll();
	// currentLevel.add(currentNode.val);
	// if (currentNode.left!=null) nextQueue.add(currentNode.left);
	// if (currentNode.right!=null) nextQueue.add(currentNode.right);
	// }
	// result.add(currentLevel);
	// }
	// return result;
	// }

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		levelOrder(list, root, 0);
		return list;
	}

	private void levelOrder(List<List<Integer>> list, TreeNode node, int level) {
		if (node == null)
			return;
		if (list.size() < level + 1)
			list.add(new ArrayList<Integer>());
		list.get(level).add(node.val);
		levelOrder(list, node.left, level + 1);
		levelOrder(list, node.right, level + 1);
	} // A hack, this is preorder traversal
}
