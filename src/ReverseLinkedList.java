
/*
 * Reverse a singly linked list.
 */

/*
 * Basic Idea is:
 * Works like a sewing machine:
 * Reversely connect the broken link pair by pair:
 * null  1->2->3->null, working on pair(null, 1)
 * null<-1  2->3->null, working on pair(1, 2)
 * null<-1<-2  3->null, working on pair(2, 3)
 * null<-1<-2<-3  null, working on pair(3, null)
 * return 3 for the special case
 */

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		return reverseListIterative(head);
		// return reverseListRecursive(head);
	}

	public ListNode reverseListIterative(ListNode head) {
		ListNode p0 = null, p1 = head;
		while (p1 != null) {
			// get next node
			ListNode p2 = p1.next;
			// reversely connect the pair
			p1.next = p0;
			// move to next pair
			p0 = p1;
			p1 = p2;
		}
		return p0;
	}

	public ListNode reverseListRecursive(ListNode head) {
		return reverseListRecursive(null, head);
	}

	private ListNode reverseListRecursive(ListNode node1, ListNode node2) {
		if (node2 == null) {
			return node1;
		}
		// get next node
		ListNode node3 = node2.next;
		// reversely connect the pair
		node2.next = node1;
		// move to next pair
		return reverseListRecursive(node2, node3);
	}
}