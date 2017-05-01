import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	// public List<String> binaryTreePaths(TreeNode root) {
	// List list = new ArrayList<String>();
	// if (root == null) return list;
	// StringBuffer sb = new StringBuffer();
	// binaryTreePath(root, list, sb);
	// return list;
	// }
	//
	// public void binaryTreePath(TreeNode Node, List<String> list, StringBuffer
	// sb){
	// if (Node == null){
	// return;
	// }
	// if(sb.length() == 0){
	// sb.append(Node.val);
	// }
	// else{
	// sb.append("->"+Node.val);
	// }
	// if (Node.left == null && Node.right == null){
	// list.add(sb.toString());
	// return;
	// }
	// StringBuffer sb2=new StringBuffer(sb);
	// binaryTreePath(Node.left, list, sb);
	// binaryTreePath(Node.right, list, sb2);
	// }

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		if (root != null) {
			StringBuffer sb = new StringBuffer();
			binaryTreePaths(root, list, sb);
		}
		return list;
	}

	private void binaryTreePaths(TreeNode node, List<String> list, StringBuffer sb) {
		if (node.left == null && node.right == null) {
			sb.append(node.val);
			list.add(sb.toString());
			return;
		}
		sb.append(node.val + "->");
		if (node.left != null) {
			binaryTreePaths(node.left, list, new StringBuffer(sb));
		}
		if (node.right != null) {
			binaryTreePaths(node.right, list, new StringBuffer(sb));
		}
	} // actually slower
}