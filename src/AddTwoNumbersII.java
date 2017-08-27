/*
You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */

public class AddTwoNumbersII {
	// recursive solution:
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int length1 = getLength(l1), length2 = getLength(l2);
		ListNode sum = new ListNode(0);
		int carry = addList(l1, l2, sum, length1, length2, 0, 0);
		if (carry == 0) {
			return sum.next;
		} else {
			sum.val = 1;
			return sum;
		}
	}

	private int addList(ListNode l1, ListNode l2, ListNode l3, int length1, int length2, int index1, int index2) {
		// return carry; l3 is the current node of result.
		int sum = 0, carry = 0;
		ListNode newNode = new ListNode(0);
		if (length1 - index1 > length2 - index2) {
			// l1 is longer than l2
			carry = addList(l1.next, l2, newNode, length1, length2, index1 + 1, index2);
			sum = l1.val + carry;
		} else if (length1 - index1 < length2 - index2) {
			// l2 is longer than l1
			carry = addList(l1, l2.next, newNode, length1, length2, index1, index2 + 1);
			sum = l2.val + carry;
		} else if (length1 - index1 == 0 && length2 - index2 == 0) {
			// hit tails
			return 0;
		} else {
			carry = addList(l1.next, l2.next, newNode, length1, length2, index1 + 1, index2 + 1);
			sum = l1.val + l2.val + carry;
		}
		newNode.val = sum % 10;
		l3.next = newNode;
		return sum / 10;
	}

	private int getLength(ListNode node) {
		int length = 0;
		while (node != null) {
			length++;
			node = node.next;
		}
		return length;
	}

	// try write stack solution:
}
