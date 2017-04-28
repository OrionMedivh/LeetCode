
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		return mergeKLists(lists, 0, lists.length - 1);
	}

	public ListNode mergeKLists(ListNode[] lists, int start, int end) {
		if (start > end) {
			return null;
		}
		if (start == end) {
			return lists[start];
		}
		if (start + 1 == end) {
			return mergeTwoLists(lists[start], lists[end]);
		}
		int mid = start + (end - start) / 2;
		return mergeTwoLists(mergeKLists(lists, start, mid), mergeKLists(lists, mid + 1, end));
	}

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
