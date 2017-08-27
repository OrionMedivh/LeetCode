import java.util.ArrayList;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class SearchRangeInBinarySearchTree {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        searchRange(root, k1, k2, list);
        return list;
    }

    private void searchRange(TreeNode root, int k1, int k2, ArrayList<Integer> list){
        if (root == null || k1 > k2){
            return;
        }
        searchRange(root.left, k1, Math.min(root.val, k2), list);
        if (k1 <= root.val && k2 >= root.val){
            list.add(root.val);
        }
        searchRange(root.right, Math.max(root.val, k1), k2, list);
    }
}