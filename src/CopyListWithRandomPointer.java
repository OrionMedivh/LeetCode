
/*
A linked list is given such that each node contains an additional 
random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 */

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}

		// copy every node and insert into list
		// from a->b to a->a'->b
		RandomListNode p = head;
		while (p != null) {
			RandomListNode newNode = new RandomListNode(p.label);
			newNode.next = p.next;
			p.next = newNode;
			p = newNode.next;
		}

		// copy random pointer for each new node
		p = head;
		while (p != null) {
			if (p.random != null) {
				// copy's random = original's random's copy
				p.next.random = p.random.next;
			}
			p = p.next.next;
		}

		// break the list into two
		p = head;
		RandomListNode newHead = head.next;
		while (p != null) {
			RandomListNode q = p.next;
			p.next = q.next;
			if (q.next != null) {
				q.next = q.next.next;
			}
			p = p.next;
		}
		return newHead;
	}
}
