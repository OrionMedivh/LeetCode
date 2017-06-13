
/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
 */

public class OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenStart = even;
		while (odd.next != null && even.next != null) {
			// move in pairs, stop at 0 or 1 node left
			// odd.next == even here, need to specify both condition since case
			// like 1-3-4, 2-4-null;
			odd.next = even.next; // 1 link to 3;
			odd = odd.next; // 1 moves to 3;
			even.next = odd.next; // 2 link to 4 or null;
			even = even.next; // 2 moves to 4 or null;
		}
		odd.next = evenStart;
		// either 1-3(-4), 2-4(-null) => 1-3-2-4
		// or 1-3(-4), 2-4(-5) => 1-3-5(-null), 2-4(-null) => 1-3-5-2-4
		// so it's safe to concatenate directly in both cases;
		return head;
	}

	public void printList(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static void main(String args[]) {
		OddEvenLinkedList o = new OddEvenLinkedList();
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		o.printList(o.oddEvenList(node1));
	}
}
