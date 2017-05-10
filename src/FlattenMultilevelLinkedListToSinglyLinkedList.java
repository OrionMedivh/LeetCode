import java.util.HashMap;

class MultiListNode {
	MultiListNode down, next;
	int val;

	public MultiListNode(int val) {
		this.val = val;
	}
}

public class FlattenMultilevelLinkedListToSinglyLinkedList {

	private MultiListNode tail;

	// down first, then second
	public MultiListNode flatten(MultiListNode head) {
		if (head == null) {
			return null;
		}
		tail = head;
		MultiListNode next = head.next;
		head.next = flatten(head.down);
		tail.next = flatten(next);
		return head;
	}

	public static void main(String[] args) {
		FlattenMultilevelLinkedListToSinglyLinkedList s = new FlattenMultilevelLinkedListToSinglyLinkedList();
		HashMap<Integer, MultiListNode> map = new HashMap<>();
		for (int i = 0; i <= 24; i++) {
			MultiListNode node = new MultiListNode(i);
			map.put(i, node);
		}
		map.get(1).next = map.get(2);
		map.get(2).next = map.get(3);
		map.get(3).next = map.get(4);
		map.get(7).next = map.get(8);
		map.get(8).next = map.get(10);
		map.get(10).next = map.get(12);
		map.get(17).next = map.get(18);
		map.get(18).next = map.get(19);
		map.get(19).next = map.get(20);
		map.get(15).next = map.get(23);
		map.get(2).down = map.get(7);
		map.get(7).down = map.get(9);
		map.get(9).down = map.get(14);
		map.get(14).down = map.get(15);
		map.get(23).down = map.get(24);
		map.get(8).down = map.get(16);
		map.get(16).down = map.get(17);
		map.get(20).down = map.get(21);
		map.get(10).down = map.get(11);

		MultiListNode head = s.flatten(map.get(1));
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
