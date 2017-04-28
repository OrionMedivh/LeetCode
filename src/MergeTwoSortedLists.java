
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0), l = head;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				l.next = l1;
				l1 = l1.next;
			} else {
				l.next = l2;
				l2 = l2.next;
			}
			l = l.next;
		}
		if (l1 == null) {
			l.next = l2;
		}
		if (l2 == null) {
			l.next = l1;
		}
		return head.next;
	}
}
