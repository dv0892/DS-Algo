package test.app.linkedlist;

public class MaximumTwinSumOfLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int pairSum(ListNode head) {
	     
	        ListNode mid = mid(head);
	        ListNode rev = reverse(mid);
	        
	        int max = Integer.MIN_VALUE;
	        while(rev != null){
	            max = Math.max( max, rev.val + head.val);
	            rev  = rev.next;
	            head = head.next;
	        }
	        
	        return max;
	    }
	    
	    public ListNode mid( ListNode head ){
	        ListNode slow, fast;
	        slow = fast = head;
	        
	        while( fast!= null && fast.next != null ){
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        return slow;
	    }
	    
	    public ListNode reverse( ListNode head ){
	        ListNode curr = head;
	        ListNode prev = null;
	        
	        while( curr != null ){
	            ListNode temp = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = temp;
	        }
	        
	        return prev;
	    }

}
