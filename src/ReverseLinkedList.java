
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode p0 = null, p1 = head;
		while (p1 != null) {
			ListNode p2 = p1.next;
			p1.next = p0;
			p0 = p1;
			p1 = p2;
		}
		return p0;
	}
}