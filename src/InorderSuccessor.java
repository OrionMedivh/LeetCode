
public class InorderSuccessor {    
    TreeNode successor;
    int found; // 0 not found, 1 found successor, 2 already assigned successor.
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        this.successor = null;
        this.found = 0;
        inorderSuccessorHelper(root, p);
        return this.successor;
    }
    
    public void inorderSuccessorHelper(TreeNode cur, TreeNode p){
        if (cur == null) return; //stop condition
        inorderSuccessorHelper(cur.left, p); //searching left;
        // main operations within each node.
        if (this.found==1){
            this.successor = cur;
            this.found=2;
        }
        if(this.found == 0 && cur == p){
            this.found = 1;
        }
        if(this.found !=2){
        	inorderSuccessorHelper(cur.right, p); //search right.
        }
    }
}
