
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode p1 = head, p2 = head.next;
		while (p2 != null && p2.next != null) {
			p2 = p2.next.next;
			p1 = p1.next;
			if (p1 == p2) {
				return true;
			}
		}
		return false;
	}
}
