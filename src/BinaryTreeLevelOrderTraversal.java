import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if(root == null){
			return list;
		}
		levelOrder(root, list, 0);
		return list;
	}
	
	public void levelOrder(TreeNode node, List<List<Integer>> list, int level ){
		if(node == null){
			return;
		}
		if(list.size() < level + 1){
			list.add(new ArrayList<Integer>());
		}
		list.get(level).add(node.val);
		levelOrder(node.left, list, level + 1);
		levelOrder(node.right, list, level + 1);
	}
}
