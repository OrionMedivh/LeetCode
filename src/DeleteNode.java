
/*
Write a function to delete a node (except the tail) in a 
singly linked list, given only access to that node.
Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are 
given the third node with value 3, the linked list should 
become 1 -> 2 -> 4 after calling your function.
 */

public class DeleteNode {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
	// copy value from next node, and then delete it.

	// public void deleteNode(ListNode node) {
	// ListNode prev = null;
	// while (node.next != null) {
	// node.val = node.next.val;
	// prev = node;
	// node = node.next;
	// }
	// prev.next = null;
	// }
	// //Shift all nodes to left. not needed.
}
