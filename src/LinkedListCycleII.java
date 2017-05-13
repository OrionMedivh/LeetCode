
public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode p1 = head, p2 = head;
		while (p2 != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2) {
				break;
			}
		}
		if (p2 == null || p2.next == null) {
			return null;
		}
		p1 = head;
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}
