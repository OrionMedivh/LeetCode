  
public class BinaryTreeLongestConsecutiveSequence {
	private int max=0;
	
    public int longestConsecutive(TreeNode root) {
    	if (root == null) return 0;
        helper(root, root.val-1, 0);
        return max;
    }
    
    public void helper(TreeNode node, int val, int cur){//return consecutive number
        if(node == null) return;
        if(node.val != val+1) cur=1;
        else cur++;
        max = Math.max(max, cur); 
        helper(node.left, node.val, cur);
        helper(node.right, node.val, cur);
    }
}
