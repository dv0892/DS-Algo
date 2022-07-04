package test.app.linkedlist;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode removeElements(ListNode head, int val) {
        
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            if ( curr.val == val ){
                if( prev == null )  {
                    head = curr.next;
                }  else {
                    prev.next = curr.next;
                }
            } else {
                    prev = curr;
            }
            
            curr = curr.next;
        }
        
        return head;
        
    }

}
