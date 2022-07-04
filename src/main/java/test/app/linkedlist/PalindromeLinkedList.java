package test.app.linkedlist;

public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isPalindrome(ListNode head) {
        
		
		//find the mid
		ListNode mid = findMid(head);
		
		//reverse the list starting from mid
		ListNode revHead = reverse(mid);
		
		
		while( revHead != null ) {
			
			if(revHead.val != head.val)
				return false;
			
			revHead = revHead.next;
			head = head.next;
		}
		
		return true;
    }

	private ListNode reverse(ListNode head) {
		
		ListNode prev, curr;
		prev = null; curr = head;
		
		while( curr != null ) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		
		return prev;
	}

	private ListNode findMid(ListNode head) {

		ListNode slow, fast ;
		slow = fast = head;
		
		while( fast!= null && fast.next != null ) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

}
