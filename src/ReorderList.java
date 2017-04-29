
public class ReorderList {
	public void reorderList(ListNode head) {
		ListNode end = head;
		while (end.next != null) {
			end = end.next;
		}
		head = reorder(head, end);
	}

	public ListNode reorder(ListNode head, ListNode end) {
		if (head == null) // no node
			return null;
		else if (head == end)// one node
			return head;
		else if (head.next == end) { // two node
			end.next = head;
			head.next = null;
			return end;
		} else {
			ListNode tail = head.next;
			ListNode tail1 = head;
			while (tail.next != null) {
				tail1 = tail;
				tail = tail.next;
			}
			tail.next = head;
			tail1.next = null;
			head.next = reorder(head.next, tail1);
			return tail;
		}
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ReorderList sol = new ReorderList();
		sol.reorderList(node1);
	}
}