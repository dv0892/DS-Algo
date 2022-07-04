package test.app.linkedlist;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode node5 = new ListNode(2);
		ListNode node4 = new ListNode(2, node5);
		
		//list A
		ListNode node3 = new ListNode(1, node4);
		ListNode node2 = new ListNode(1, node3);
		ListNode node1 = new ListNode(1, node2);
		
		System.out.println( new RemoveDuplicatesFromSortedList().deleteDuplicates(node1));
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        
        while ( curr != null ){
            
            while( curr.next != null && curr.val == curr.next.val )
                curr.next = curr.next.next;
            
            curr = curr.next;
        }
        
        return head;
    }

}
