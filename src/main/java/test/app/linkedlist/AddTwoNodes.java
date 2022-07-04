package test.app.linkedlist;

import java.util.Objects;

public class AddTwoNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        int carry = 0;
	        ListNode curr , res ; 
	        res = curr = null;

	        while ( l1!=null || l2!=null || carry!=0 ){
	            int sum = 0;
	           
	            if( Objects.nonNull(l1) ) {
	                sum += l1.val;
	                l1 = l1.next;
	            }
	        
	            if( Objects.nonNull(l2) ) {
	                sum += l2.val;
	                l2 = l2.next;
	            }
	               
	            sum += carry;
	               
	            if ( res == null ){
	                res = curr = new ListNode(sum%10);
	            } else {
	                curr.next = new ListNode(sum%10);
	                curr = curr.next;
	            }
	             
	            carry = sum/10;
	        }
	        
	        return res;
	    }
	    


}
