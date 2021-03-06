
/*
Write a program to find the node at which the intersection of two 
singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		ListNode a = headA, b = headB;

		while (a != b) {
			a = (a == null ? headB : a.next);
			b = (b == null ? headA : b.next);
		}

		return a;
	}
}

/*
 * Idea is, let both nodes traverse two lists, starting from head of A and B
 * respectively, once reached tail, switch to the head of the other list, so we
 * can ensure they will meet(if there's one) or both reached null.
 */