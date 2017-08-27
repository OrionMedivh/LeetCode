
/*
Given a list, rotate the list to the right by k places, 
where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

 */

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy, slow = dummy;

		int i = 0;
		while (fast.next != null) { // Get total length
			fast = fast.next;
			i++;
		}

		int j = 0;
		// move to right, means the pointer actually moves to left
		// by k % i. Thus, i - k % i is the index of the new tail.
		// Similarly, to move to left, k % i is the index of the new tail.
		while (j < i - k % i) {
			slow = slow.next;
			j++;
		}

		fast.next = dummy.next; // old tail -> old head.
		dummy.next = slow.next; // dummy -> new head.
		slow.next = null; // new tail -> null

		return dummy.next;
	}
}
