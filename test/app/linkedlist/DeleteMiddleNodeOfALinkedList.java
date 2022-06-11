package test.app.linkedlist;

public class DeleteMiddleNodeOfALinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode deleteMiddle(ListNode head) {
        
        ListNode prev = null;
        ListNode slow,fast;
        slow = fast = head;
        
        while( fast!=null && fast.next!= null ){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
        if( prev == null )
            return null;
        
        prev.next = slow.next;
        
        return head;
    }

}
