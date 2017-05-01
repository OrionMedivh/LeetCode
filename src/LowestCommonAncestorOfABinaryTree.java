//import java.util.LinkedList;
//import java.util.List;

//public class LowestCommonAncestorOfABinaryTree {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (root == null) return root;
//        if (root == p && FindNode(root, q)) return root;
//        if (root == q && FindNode(root, p)) return root;
//        if (FindNode(root.left, p) && FindNode(root.right, q) || FindNode(root.left, q) && FindNode(root.right, p)) return root;
//        TreeNode left= lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        if (left!=null) return left;
//        if (right!=null) return right;
//        return null;
//    }
//    
//    public boolean FindNode(TreeNode root, TreeNode n){
//        if (root == n) return true;
//        if (root == null) return false;
//        return FindNode(root.left, n) || FindNode(root.right, n);
//    }
//}

/*If the current (sub)tree contains both p and q, 
 * then the function result is their LCA. 
 * If only one of them is in that subtree, 
 * then the result is that one of them. 
 * If neither are in that subtree, 
 * the result is null/None/nil.
 */

public class LowestCommonAncestorOfABinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		return left == null ? right : right == null ? left : root;
	}

	public static void main(String args[]) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		a.left = b;
		a.right = c;
		LowestCommonAncestorOfABinaryTree s = new LowestCommonAncestorOfABinaryTree();
		System.out.println(s.lowestCommonAncestor(a, b, c).val);
	}
}