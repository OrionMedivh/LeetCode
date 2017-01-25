public class PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        plusOneHelper(newHead);
        if(newHead.val == 1) return newHead;
        return head;
    }
    
    public int plusOneHelper(ListNode node){
        if(node.next == null)
        {
            node.val++;
        }else{
            node.val += plusOneHelper(node.next);
        }
        if(node.val > 9){
            node.val%=10;
            return 1;
        }
        return 0;
    }
}