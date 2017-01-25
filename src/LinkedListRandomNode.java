public class LinkedListRandomNode {

ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
    	int pick;
    	int index;
    	ListNode node = head;
        pick = head.val;
        index=1;
        while(node.next!=null){
            node = node.next;
            index++;
            if( Math.random() <= 1.0/index ){
                pick=node.val;
            }
        }
        return pick;
    }
}

/**
 * Your FlipGameII object will be instantiated and called as such:
 * FlipGameII obj = new FlipGameII(head);
 * int param_1 = obj.getRandom();
 */