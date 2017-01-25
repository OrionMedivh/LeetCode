import java.util.Stack;

public class BSTIterator {
//    private TreeNode root;
//    private Stack<TreeNode> s;
//    public BSTIterator(TreeNode root) {
//        this.root = root;
//        s= new Stack<TreeNode>();
//        traverse(s,root);
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return !s.isEmpty();
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        return s.pop().val;
//    }
//    
//    private void traverse(Stack<TreeNode> s, TreeNode node){
//        if (node == null) return;
//        traverse(s,node.right);
//        s.push(node);
//        traverse(s,node.left);
//    }
    
    private Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s= new Stack<TreeNode>();
        traverse(s,root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !s.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode next = s.pop();
        traverse(s, next.right);
        return next.val;
    }
    
    private void traverse(Stack<TreeNode> s, TreeNode node){
        if (node == null) return;
        s.push(node);
        traverse(s,node.left);
    }

}