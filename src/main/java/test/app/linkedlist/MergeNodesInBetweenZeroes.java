package test.app.linkedlist;

public class MergeNodesInBetweenZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode mergeNodes(ListNode head) {
    
		ListNode curr = head;
		
		while ( curr != null ) {
			ListNode temp = curr;
			int sum = 0;
			
			while( curr.next != null && curr.next.val != 0) {
				sum += curr.next.val;
				curr = curr.next;
			}
			
			temp.val = sum;
			temp.next = curr.next;
			curr = curr.next;
			
			if( curr.next ==  null ) {
				temp.next = null;
				break;
			}
		}
		
		return head;
    }

}
