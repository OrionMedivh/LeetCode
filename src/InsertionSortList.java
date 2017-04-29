
public class InsertionSortList {
	public static ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode start = new ListNode(0);// sorted list start;
		start.next = head;
		ListNode end = head;// sorted list end;
		ListNode find = start;// iteration through sorted list,always use .next;
		ListNode current = head.next;// iteration through the entire list;
		while (current != null) {
			find = start;
			while (find != end && current.val >= find.next.val) {
				find = find.next;
			}
			if (find == end) {// bigger than all
				// end.next=current;
				end = end.next;
				current = current.next;
			} else {// found inserting position
				ListNode tmp = find.next;
				find.next = current;
				current = current.next;
				end.next = current;
				find.next.next = tmp;
			}
		}
		return start.next;
	}

	public static void main(String args[]) {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		System.out.println(insertionSortList(node1));
	}
}
