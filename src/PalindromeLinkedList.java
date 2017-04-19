
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head){
		if(head == null || head.next == null){
			return true;
		}
		ListNode mid = findMid(head);
		//ListNode tail = reverse(mid);
		ListNode tail = reverse2(null, mid);
		while(head!= null && tail != null){
			if(head.val != tail.val){
				return false;
			}
			head = head.next;
			tail = tail.next;
		}
		return true;
	}
	
	private ListNode findMid(ListNode head){
		ListNode slow = head;
		ListNode fast = head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private ListNode reverse(ListNode head){
		ListNode prev = null;
		while(head != null){
			ListNode next = head.next;
			head.next=prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	private ListNode reverse2(ListNode node1, ListNode node2){
		if(node2 == null){
			return node1;
		}
		ListNode newHead = reverse2(node2, node2.next);
		node2.next = node1;
		return newHead;
	}
}
