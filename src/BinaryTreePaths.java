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
		List list = new ArrayList<String>();
		if (root != null) {
			StringBuffer sb = new StringBuffer();
			binaryTreePath(root, list, sb);
		}
		return list;
	}

	public void binaryTreePath(TreeNode Node, List<String> list, StringBuffer sb) {
		if (Node.left == null && Node.right == null) {
			sb.append(Node.val);
			list.add(sb.toString());
			return;
		}
		sb.append(Node.val + "->");
		if (Node.left != null) {
			binaryTreePath(Node.left, list, new StringBuffer(sb));
		}
		if (Node.right != null) {
			binaryTreePath(Node.right, list, new StringBuffer(sb));
		}
	} // actually slower
}