
public class DeleteNode {
	public static void deleteNode(ListNode node) {
		// node.val=node.next.val;
		// node.next = node.next.next;
		node = node.next;// wrong
	}

	public static void main(String[] args) {
		ListNode zero = new ListNode(0);
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		zero.next = one;
		one.next = two;
		deleteNode(zero);
		System.out.println(zero.next.next.val);

		// lesson: java is always pass by value. even "reference" is a pointer,
		// which is a value.
		// so we can say pass by pointer.
	}
}
