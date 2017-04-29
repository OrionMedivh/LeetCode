
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		} else if (head.next.next == null) {
			if (head.val > head.next.val) {
				ListNode newHead = head.next;
				newHead.next = head;
				head.next = null;
				return newHead;
			} else
				return head;
		} else {
			ListNode countNode = head;
			int count = 1;
			while (countNode.next != null) {
				countNode = countNode.next;
				count++;
			}
			ListNode half = head;
			for (int i = 1; i < count / 2; i++) {
				half = half.next;
			}
			ListNode second = sortList(half.next);
			half.next = null;
			ListNode first = sortList(head);
			ListNode newList = new ListNode(0), end = newList;
			while (first != null && second != null) {
				if (first.val > second.val) {
					end.next = second;
					second = second.next;
				} else {
					end.next = first;
					first = first.next;
				}
				end = end.next;
			}
			if (first != null) {
				end.next = first;
			}
			if (second != null) {
				end.next = second;
			}
			return newList.next;
		}
	}

	public static void main(String[] args) {
		SortList sol = new SortList();
		ListNode node1 = new ListNode(3), node2 = new ListNode(2), node3 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		ListNode newNode = sol.sortList(node1);
		while (newNode != null) {
			System.out.println(newNode.val);
			newNode = newNode.next;
		}
	}
}