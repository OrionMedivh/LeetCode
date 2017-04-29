
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode p1 = head, p2 = head.next;
		while (p2 != null) {
			if (p1.val == p2.val) {
				p1.next = p2.next;
				p2 = p2.next;
			} else {
				p1 = p1.next;
				p2 = p2.next;
			}
		}
		return head;
	}
}